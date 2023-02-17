package by.teachmeskills.homeworks.hw_24022023;

import java.util.Scanner;

public class CycleTask2 {
    /*
    Одноклеточная амеба каждые 3 часа делится на 2 клетки.
    Необходимо определить, сколько амеб будет через 3, 6, 9, 12,..., 24 часа.
    */
    public static void main(String[] args) {
        System.out.println("Введите количество часов жизни амебки :)");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int countAmeb = 1;
        for (int i = 1; i <= num / 3; i++) {
            countAmeb *= 2;
        }
        System.out.printf("В итоге получилось %d амеб", countAmeb);
    }
}
