package by.teachmeskills.homeworks.hw_17032023.task3;

import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CensorshipChecker {
    private static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task3\\files\\";

    public static void censorCheck() throws IOException {
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(new File(ROOT + "sourcetext.txt")));
             BufferedReader blacklistReader = new BufferedReader(new FileReader(new File(ROOT + "blacklist.txt")))) {
            List<String> resultList = new ArrayList<>();
            List<String> blackList = new ArrayList<>();
            boolean checkBLWords = false;
            int sentencesCount = 0;
            // Считывание blackList слов
            String str = blacklistReader.readLine();
            while (str != null) {
                blackList.add(str);
                str = blacklistReader.readLine();
            }
            // Посимвольное чтение предложение до символов конца строки и поиск их в предложении
            int readChar = sourceReader.read();
            StringBuilder temp = new StringBuilder();
            while (readChar != -1) {
                if ((char) readChar != '.' && (char) readChar != '?' && (char) readChar != '!') {
                    temp.append((char) readChar);
                } else {
                    String[] listWords = temp.toString().split("\\P{L}+");
                    for (String string : listWords) {
                        if (blackList.contains(string)) {
                            sentencesCount++;
                            resultList.add(temp.toString() + (char) readChar);
                            checkBLWords = true;
                            break;
                        }
                    }
                    temp.delete(0, temp.length());
                }
                readChar = sourceReader.read();
            }
            System.out.println((!checkBLWords) ? "Текст прошёл проверку" : "Текст не прошел проверку. Количество предложений = " + sentencesCount);
            for (String s : resultList)
                System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
