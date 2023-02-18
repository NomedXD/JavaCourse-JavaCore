package by.teachmeskills.homeworks.hw_24022023;

import java.util.Scanner;

public class RecursionTask2 {
    /*
    Даны два целых числа A и В (каждое в отдельной строке). Используя рекурсивную функцию,
    выведите все числа от A до B включительно, в порядке возрастания, если A < B, или в порядке
    убывания в противном случае (A > B).
     */
    public static void main(String[] args) {
        System.out.println("Введите целое число А");
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        System.out.println("Введите целое число B");
        int B = in.nextInt();
        recursionFunc(A, B);
    }

    private static void recursionFunc(int A, int B) {
        if (Math.abs(A - B) <= 0) {
            System.out.println(A + " ");
            return;
        }
        if (A > B) {
            System.out.println(A + " ");
            recursionFunc(A - 1, B);
        } else {
            System.out.println(A + " ");
            recursionFunc(A + 1, B);
        }
    }
}
