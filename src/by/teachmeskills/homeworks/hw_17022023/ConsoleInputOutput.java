package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class ConsoleInputOutput {
    /*
    Имеется прямоугольное отверстие размерами a и b.
    Определите можно ли его полностью закрыть круглой картонкой радиусом r.
    Вывести результат на экран.

    Данные a, b и r ввести с консоли.

     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сторону прямоугольника a");
        float a = in.nextFloat();
        System.out.println("Введите сторону прямоугольника b");
        float b = in.nextFloat();
        System.out.println("Введите радиус окружности r");
        float r = in.nextFloat();
        System.out.println(Solution(a, b, r) ? "Можно" : "Нельзя");

    }

    private static boolean Solution(float aFunc, float bFunc, float rFunc) {
        return 2 * rFunc >= Math.sqrt(aFunc * aFunc + bFunc * bFunc);
    }
}
