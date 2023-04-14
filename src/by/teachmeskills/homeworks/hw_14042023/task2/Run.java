package by.teachmeskills.homeworks.hw_14042023.task2;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        IFunctional<String> lambda1 = s -> System.out.println(new StringBuilder(s).reverse().toString());
        IFunctional<Integer> lambda2 = s -> {
            int res = 1;
            for (int i = 2; i <= s; i++)
                res *= i;
            System.out.println(res);
        };
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите опцию");
            System.out.println("""
                    1 - вывести строку в обратном порядке
                    2 - вывести факториал числа
                    любое другое - выход""");
            Scanner in = new Scanner(System.in);
            switch (in.nextLine()) {
                case "1": {
                    System.out.println("Введите строку для реверса");
                    lambda1.action(in.nextLine());
                    break;
                }
                case "2": {
                    System.out.println("Введите число для нахождения факториала");
                    lambda2.action(in.nextInt());
                    break;
                }
                default: {
                    exit = true;
                    break;
                }
            }
        }
    }
}
