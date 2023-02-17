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

        if (A < B) {
            boolean flag = true;
            recursionFunc(A, B + 1, flag);
        } else if (A > B) {
            boolean flag = false;
            recursionFunc(A, B - 1, flag);
        } else System.out.print(A + " " + B);

    }

    private static void recursionFunc(int num, int baseStep, boolean flag) {
        if (num == baseStep)
            return;
        System.out.print(num + " ");
        if (flag)
            num++;
        else num--;
        recursionFunc(num, baseStep, flag);
    }

}
