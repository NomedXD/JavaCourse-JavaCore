package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class DaysInWeek {
        /*
        Имеется целое число n < 10.
        Вывести какому дню недели оно соответствует, если при n = 1 день недели = Понедельник.


     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер дня недели");
        int n = in.nextInt();
        System.out.println(Solution(n));

    }

    private static String Solution(int nFunc) {
        switch (nFunc) {
            case 1, 8:
                return "Понедельник";
            case 2, 9:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
                return "Воскресенье";

        }
        ;
        return "Неизвестный день недели";
    }
}
