package by.teachmeskills.homeworks.hw_10032023.Task3;

import java.util.Arrays;
import java.util.Objects;

public class StringUtils {
    private StringUtils() {

    }

    public static char lastChar(String sourceString) {
        return sourceString.charAt(sourceString.length() - 1);
    }

    public static boolean endsWithExclamationMark(String sourceString) {
        return sourceString.endsWith("!!!");
    }

    public static boolean startWithFazatron(String sourceString) {
        return sourceString.startsWith("Сиреневенький синхрофазатрон");
    }

    public static boolean containsSubString(String sourceString, String subString) {
        return sourceString.contains(subString);
    }

    public static String toUpperCase(String sourceString) {
        return sourceString.toUpperCase();
    }

    public static String toLowerCase(String sourceString) {
        return sourceString.toLowerCase();
    }

    public static String mathExpression(int firstOperant, String operation, int secondOperand) {
        StringBuilder str = new StringBuilder();
        str.append(firstOperant).append(" ").append(operation).append(" ").append(secondOperand).append(" = ");
        switch (operation) {
            case "+":
                str.append(firstOperant + secondOperand);
            case "-":
                str.append(firstOperant - secondOperand);
            case "*":
                str.append(firstOperant * secondOperand);
            case "/":
                str.append((float) (firstOperant / secondOperand));
        }
        return str.toString();
    }

    public static String replaceEquals(String sourceString) {
        StringBuilder str = new StringBuilder(sourceString);
        // Есть же replace как в String так и в StringBuilder,зачем delete+insert...
        int ind = str.lastIndexOf("=");
        str.deleteCharAt(ind);
        str.insert(ind, "равно");
        return str.toString();
    }

    public static String retTwoChars(String sourceString1, String sourceString2) {
        if (sourceString1.length() % 2 != 0 || sourceString2.length() % 2 != 0)
            return null;
        else {
            String temp = sourceString1 + sourceString2;
            return temp.substring(temp.length() / 2 - 1, temp.length() / 2 + 1);
        }
    }

    public static void findPolindroms(String sourceString) {
        // Можно проще, используя set, чтобы хранить уникальные строки :(
        String[] array = sourceString.split("\\P{L}+");
        String[] arrayTemp = new String[array.length];
        int ind = 0;
        for (String a : array) {
            StringBuilder temp = new StringBuilder(a);
            if (a.equals(temp.reverse().toString())) {
                boolean flag = false;
                for (int i = 0; i < ind; i++) {
                    if (Objects.equals(a, arrayTemp[i])) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    arrayTemp[ind] = a;
                    ind++;
                }
            }
        }
        for (int i = 0; i < arrayTemp.length; i++)
            if (arrayTemp[i] != null)
                System.out.print(arrayTemp[i] + " ");
        // Ну или просто Arrays.toString(), но тогда null выведутся, если не все слова = палиндромы
    }

    public static String splitString(String sourceString) {
        String[] array = sourceString.split(" ");
        return Arrays.toString(array);
    }
}
