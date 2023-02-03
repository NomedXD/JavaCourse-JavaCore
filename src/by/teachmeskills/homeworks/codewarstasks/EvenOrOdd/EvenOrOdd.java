package by.teachmeskills.homeworks.codewarstasks.EvenOrOdd;

import java.util.Scanner;

public class EvenOrOdd {
    /*
     * Задача: Проверить, четное число или нет
     * Пример: 124 -> "Even"; 111 -> "Odd"
     * */
    public static String even_or_odd(int number) {
        if((number&1) == 0)
            return "Even";
        else
            return "Odd";

    }

    public static void main(String[] args) {
        System.out.print("Введите число\n");
        Scanner in = new Scanner(System.in);
        int inNum1 = in.nextInt();
        System.out.println(even_or_odd(inNum1));
    }
}
