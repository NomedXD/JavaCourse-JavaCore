package by.teachmeskills.homeworks.codewarstasks.StringReverse;

import java.util.Scanner;

public class StringReverse {
    /*
     * Задача: Инвертировать строку
     * Пример: hello -> olleh
     * */

    public static String solution(String str) {
        StringBuffer firstBuffer = new StringBuffer(str);
        firstBuffer.reverse();
        return firstBuffer.toString();

    }

    public static void main(String[] args) {
        System.out.print("Введите строку\n");
        Scanner in = new Scanner(System.in);
        String inStr = in.next();
        System.out.println(solution(inStr));
    }
}
