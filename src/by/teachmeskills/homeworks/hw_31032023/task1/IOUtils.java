package by.teachmeskills.homeworks.hw_31032023.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream; // org.apache.commons.io.IOUtil не нашел :(

public class IOUtils {
    private static final String FOLDER_PATH = "D:" + File.separator + "JavaStudy" + File.separator;
    private static final String FOLDER_NAME = "folder";
    private static final String ZIP_NAME = File.separator + "output.zip";
    private static final String NEW_FOLDER_NAME = "folder_new";

    public static void createAndRemoveFolder() {
        File folder = new File(FOLDER_PATH + FOLDER_NAME);
        if (!folder.exists()) {
            folder.mkdir();
        }
        try (FileOutputStream fos1 = new FileOutputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file1");
             FileOutputStream fos2 = new FileOutputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file2");
             FileOutputStream fos3 = new FileOutputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file3");
             ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(FOLDER_PATH + FOLDER_NAME + ZIP_NAME));
             FileInputStream fin1 = new FileInputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file1");
             FileInputStream fin2 = new FileInputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file2");
             FileInputStream fin3 = new FileInputStream(FOLDER_PATH + FOLDER_NAME + File.separator + "file3")) {
            fos1.write("Some Content1".getBytes());
            fos2.write("Some Content2".getBytes());
            fos3.write("Some Content3".getBytes());
            zos.putNextEntry(new ZipEntry("file1"));
            byte[] buf = new byte[200];
            fin1.read(buf);
            zos.write(buf);
            zos.closeEntry();
            /*
            Интересно, что запись ниже(стока 45-47) реально сработает только потому, что в объекте ZipOutputStram
            есть поле вложенного статик класса. Когда добавляешь Entry происходит вот какая штука:
                  1)  current = new XEntry(e, written);
                  2)  xentries.add(current);
            Где current это поле типа XEntry(это и есть вложенный статик класс с полем типа Entry),
            то есть current - ссылка на объект XEntry и при
            попытке zos.write, судя по всему, будет использоваться последняя такая ссылка на
            Entry(то есть на последний Entry для которого выполнено putNextEntry. Поэтому 3
            строчки кода ниже сработают. Интересна строка 2). xentries - это
            вектор объектов XEntry. Значит ли это, что можно сделать 3 раза putNextEntry и потом как-то
            для каждого из них(объекта Entry) выполнить отдельно zos.write и zos.clodeEntry?
            Ведь в данном случае(как и в примере урока) write и close выполняется для текущего Entry(current)

            Answer:
            Да, похоже, что работа ведется именно с current. То есть просто ссылка
            при создании этого объекта сохраняется в current. Что касается массива xentries, то с ним в
            ообще интересно. Вроде бы он там и вообще не нужен, но его просто использовали, чтобы потом
            в цикле для каждого архива прописывать информацию по типу размера и версии, а именно Центральный
            заголовок архива. Хотя интересно было бы использовать его в качестве реального массива XEntry и
            работать одновременно с несколькими ZipEntry в одном потоке через индекс массива.
             */
            zos.putNextEntry(new ZipEntry("file2"));
            fin2.read(buf);
            zos.write(buf);
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("file3"));
            fin3.read(buf);
            zos.write(buf);
            zos.closeEntry();

        } catch (IOException e) {
            System.out.println("Error occurred while performing I/O operations: " + e.getMessage());
            e.printStackTrace();
        }
        /*
        А вот еще один очень интересный момент. Если попытаться переименовать папку
        прямо в блоке try with resources, то renameTo вернет false и ничего не выйдет.
        Очень возможно, что это связано с открытыми потоками, которые работают с файлами
        внутри этой папки. То есть эти потоки связаны с файлами еще тогда, когда
        папка имела старое название. Что было бы потоками этих файлов, если бы
        путь внешней папки поменялся? Можно ли было в них писать, если бы имя папки изменилось?
        В целях безопасности(как мне кажется) сделано так, что поменять путь внешней
        папки, пока открыты потоки вложенных в эту папку файлов, нельзя. Это бы сломало эти потоки, ну или,
        по крайней мере, приводило бы к неопределенному поведению. Поэтому переименовать папку можно только
        когда потоки внутренних файлов закрыты, то есть за пределами блока try with resources...

        Answer:
        Все верно.
        Если внутри директории есть файл, который используется io
        потоками и нужно переименовать директорию, то Java этого
        сделать не даст, что совершенно логично - как потоку найти путь к файлу,
        если он изменяется в тот момент, пока поток не закрыт? Java не любит непредсказуемости.
         */
        File newFolder = new File(FOLDER_PATH + NEW_FOLDER_NAME);
        boolean flag = folder.renameTo(newFolder);
        /*
        Гении из Oracle решили, что когда делаешь
        renameTo, то не стоит делать механизм, который изменит путь уже
        имеющегося объекта File(в данном случае folder). Лучше же создать
        еще один объект с новым путем, а старый(возможно) удалит
        garbage collector WTF&!&!?? What's going on

        Answer:
        Гении из Oracle очень упростили жизнь разработчикам сделав чистку памяти динамической и
        избавив от необходимости следить за удалением объектов, исключив таким образом человеческий фактор.
        JVM умная штука, и имея такой мощный механизм очистки памяти, который к тому же совершенствуется в
        последних версиях, вполне может позволить создание новых объектов, вместо редактирования старых.
        Плюс, опять же, стоит заглянуть в JavaDoc - As instances of File are immutable, this File object is not
        changed to name the destination file or directory.
        Объекты типа File не изменяемы.
        Это сделано из соображений потокобезопасности (речь сейчас идет не о потоках ввода-вывода,
        а о multitreading когда действия в программе могут выполняться параллельно в несколько потоков,
        а потоки могут получать доступ к общим ресурсам). Если бы файлы были mutable, то пришлось бы
        тратить время и ресурсы на синхронизацию, которая является довольно дорогостоящей операцией.
         */
        for (File file : Objects.requireNonNull(newFolder.listFiles())) {
            System.out.println(file.getPath());
            file.delete();
        }
        /*
        И тут последний сюрприз. Папку нельзя удалить, если в ней содержаться файлы.
        WHAT РАДИ БЕЗОПАСНОСТИ? Как же Java прекрасна :)

        Answer:
        Это тоже вполне логично, ведь директория может содержать нужные файлы. Своего рода защита от дурака.
        Кстати, папка может не удаляться и по другим причинам - например, нет прав у пользователя, или
        стоит защита от записи или ее просто не существует по указанному пути.
        Встроенные в Java потоки ввода/вывода имеют свои достоинства и недостатки, поэтому
        разработчики часто пользуются более удобным инструментами для работы с файлами - apache
        commons FileUtils например или пакетом java.nio.*
         */
        boolean b = newFolder.delete();
    }
}
