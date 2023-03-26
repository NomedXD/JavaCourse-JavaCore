package by.teachmeskills.homeworks.hw_31032023.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        boolean option = true;
        Scanner in = new Scanner(System.in);
        while (option) {
            System.out.print("Выберите опцию\n1 - Суммирование чисел\n2 - Вычитание чисел\n");
            System.out.print("3 - Умножение чисел\n4 - Деление чисел\n5 - Возведение в степень\n6 - Модуль числа\n7 - Выход\n");
            switch (in.nextInt()) {
                case 1: {
                    /*
                    Вообще, здесь портится вся суть Generics. Мы как бы позволяем выполнять операции с любым типом,
                    но по итогу передаем все равно double. И, как я понял, когда пишем
                    System.out.println(Calculator.summation(in.nextDouble(), in.nextDouble()));
                    это то же самое, если бы было указано <Double, Double> при вызове :(
                     */
                    System.out.println("Введите 2 слагаемых");
                    System.out.println(Calculator.summation(in.nextDouble(), in.nextDouble()));
                    break;
                }
                case 2: {
                    System.out.println("Введите уменьшаемое и вычитаемое");
                    System.out.println(Calculator.subtraction(in.nextDouble(), in.nextDouble()));
                    break;
                }
                case 3: {
                    System.out.println("Введите 2 множителя");
                    System.out.println(Calculator.multiplication(in.nextDouble(), in.nextDouble()));
                    break;
                }
                case 4: {
                    System.out.println("Введите делимое и делитель");
                    System.out.println(Calculator.division(in.nextDouble(), in.nextDouble()));
                    break;
                }
                case 5: {
                    System.out.println("Введите число и степень");
                    System.out.println(Calculator.fastPow(in.nextDouble(), in.nextDouble()));
                    break;
                }
                case 6: {
                    System.out.println("Введите число");
                    System.out.println(Calculator.module(in.nextDouble()));
                    break;
                }
                case 7: {
                    option = false;
                    break;
                }
            }
        }
    }
}
