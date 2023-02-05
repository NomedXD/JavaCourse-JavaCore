package by.teachmeskills.homeworks.codewarstasks.StringReverse;

import java.util.Scanner;

public class StringReverseV2 {
    /*
     * Задача: Инвертировать строку
     * Пример: hello -> olleh
     * */

    public static char[] solution(String str) {
        char[] revStr = str.toCharArray();
        for (int i = 0; i < revStr.length / 2; i++) {
            char swap = revStr[i];
            revStr[i] = revStr[revStr.length - 1 - i];
            revStr[revStr.length - 1 - i] = swap;
        }
        return revStr;

    }

    public static void main(String[] args) {
        System.out.print("Введите строку\n");
        Scanner in = new Scanner(System.in);
        String inStr = in.next();
        System.out.println(solution(inStr));
    }
}
