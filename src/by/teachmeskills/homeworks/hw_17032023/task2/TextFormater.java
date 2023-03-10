package by.teachmeskills.homeworks.hw_17032023.task2;

public class TextFormater {
    public static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_17032023\\task2\\files\\";

    public static boolean checkForPalindrom(String sourceString) {
        String[] listWords = sourceString.split("\\P{L}+");
        for (String str : listWords) {
            StringBuilder temp = new StringBuilder(str);
            if (str.equals(temp.reverse().toString()))
                return true;
        }
        return false;
    }

    public static int getWordsCount(String sourceString) {
        return sourceString.split("\\P{L}+").length;
    }
}
