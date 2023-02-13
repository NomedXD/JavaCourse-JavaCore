package by.teachmeskills.homeworks.hw_17022023;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BubleSort {
    /*
    Создать и заполнить массив случайными числами, отсортировать массив по возрастанию,
    используя метод сортировки пузырьком.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива n");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 30);
        }
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
    }
}
