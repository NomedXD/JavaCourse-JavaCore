package by.teachmeskills.homeworks.codewarstasks.ReplaceAllSubstr;

import java.util.Scanner;

public class ReplaceAllSubStr {
    /*
     * Задача: Заменить подстроку coverage на строку covfefe(заменяются все подстроки).
     * Если в строке не найдена искомая подстрока, covfefe добавляется в конце исходной строки с
     * предшествующим ей пробелом.
     * Пример: coverage coverage -> covfefe covfefe
     * */

    public static String replaceString(String tweet) {
        String str = tweet;

        if (str.contains("coverage"))
            str = str.replaceAll("coverage", "covfefe");
        else
            str = str.concat(" covfefe");
        return str;
    }

    public static void main(String[] args) {
        System.out.print("Введите строку\n");
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        System.out.println(replaceString(inStr));
    }

}
