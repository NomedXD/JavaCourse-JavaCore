package by.teachmeskills.homeworks.hw_17032023.task2;

import java.io.*;
import java.text.BreakIterator;
import java.util.Locale;

public class Run {
    public static void main(String[] args) {
        String str = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(TextFormater.getROOT() + "text.txt")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(TextFormater.getROOT() + "out.txt")))) {
            str += reader.readLine();
            BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
            // Начало цикла по строкам текста
            while (str != null) {
                iterator.setText(str);
                int start = iterator.first();
                int currentSize = 0;
                String[] sentences = new String[200];
                // Итератор разделяет строку на предложения и заносит в массив строк
                for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
                    sentences[currentSize] = str.substring(start, end);
                    currentSize++;
                }
                // Для каждого предложения
                for (int i = 0; i < currentSize; i++) {
                    // Высший приоритет имеет проверка на палиндромы(используем сокращенное вычисление if)
                    // Также дополнительные проверки, чтобы предложение было законченным
                    if ((TextFormater.checkForPalindrom(sentences[i]) ||
                            (TextFormater.getWordsCount(sentences[i]) >= 3 && TextFormater.getWordsCount(sentences[i]) <= 5)) &&
                            (sentences[i].lastIndexOf('.') == sentences[i].length() - 1) || (sentences[i].lastIndexOf('!') == sentences[i].length() - 1)
                            || (sentences[i].lastIndexOf('?') == sentences[i].length() - 1)) {
                        writer.append(sentences[i]).append(String.valueOf('\n'));
                    }
                }
                // Если предложение не было закончено, то нужно дополнить следующей строкой и снова разделить на предложения
                char c = sentences[currentSize - 1].charAt(sentences[currentSize - 1].length() - 1);
                if (c != '.' && c != '?' && c != '!')
                    str = sentences[currentSize - 1] + reader.readLine();
                else str = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
