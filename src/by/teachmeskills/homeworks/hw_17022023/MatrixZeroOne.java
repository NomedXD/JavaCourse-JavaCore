package by.teachmeskills.homeworks.hw_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixZeroOne {
    /*
    Создать двумерный массив, размером n x n (размер массива вводить с консоли).
    Если элемент массива является четным числом, вывести 0, если не четным 1. Использовать циклы.
    Пример вывода:
    01001
    01011
    11100
    00100
    10101
    */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность квадратной матрицы n");
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * 30 - 15);
                System.out.print(String.format("%3d", arr[i][j]));
            }
            System.out.print("\n");

        }

        System.out.println("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 == 0)
                    System.out.print(String.format("%1d", 0));
                else
                    System.out.print(String.format("%1d", 1));
            }
            System.out.print("\n");
        }
    }


}
