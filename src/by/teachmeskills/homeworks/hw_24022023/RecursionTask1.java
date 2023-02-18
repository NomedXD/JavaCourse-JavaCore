package by.teachmeskills.homeworks.hw_24022023;

import java.util.Arrays;

public class RecursionTask1 {
    /*
    Дан массив из 10 положительных элементов.
    Используя рекурсивную функцию, найти сумму элементов массива.
     */
    public static final int N = 10;

    public static void main(String[] args) {
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 10 + 7);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(recursionFunc(array, N - 1));
    }

    public static int recursionFunc(int[] array, int num) {
        if (num == -1)
            return 0;
        else {
            return recursionFunc(array, num - 1) + array[num];
        }
    }
}
