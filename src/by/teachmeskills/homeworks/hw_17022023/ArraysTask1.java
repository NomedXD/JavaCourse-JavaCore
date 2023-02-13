package by.teachmeskills.homeworks.hw_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTask1 {
    /*
    В векторе, состоящем из n вещественных элементов, вычислить: сумму отрицательных элементов вектора и произведение
    элементов вектора, расположенных между максимальным и минимальным элементами.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива n");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 200 - 60);
        }
        System.out.println(Arrays.toString(arr));
        solutionArray1(arr);
    }

    private static void solutionArray1(int[] arr) {
        int sum = 0;
        int minI = 0, maxI = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                sum += arr[i];
            }
            if (arr[i] < arr[minI])
                minI = i;
            else if (arr[i] > arr[maxI])
                maxI = i;
        }
        int mult = 1;
        if (minI > maxI) {
            int temp = maxI;
            maxI = minI;
            minI = temp;
        }
        for (int i = minI + 1; i < maxI; i++)
            mult *= arr[i];
        System.out.println("Сумма отрицательных равна " + sum);
        System.out.println("Произведение элементов между минимальным и максимальным равно " + mult);

    }

}
