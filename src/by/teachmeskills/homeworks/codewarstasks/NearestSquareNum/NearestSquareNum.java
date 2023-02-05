package by.teachmeskills.homeworks.codewarstasks.NearestSquareNum;

import java.util.Scanner;

import static java.lang.Math.*;

public class NearestSquareNum {
    /*
     * Задача: Найти ближайшее относительно n целое число, которое имеет квадрат
     * Пример: 5 -> 4; 111 -> 121
     * */
    public static int nearestSq(final int n) {
        return ((int) pow(round(sqrt((double) n)), 2));
    }

    public static void main(String[] args) {
        System.out.print("Введите целое число\n");
        Scanner in = new Scanner(System.in);
        int inNum = in.nextInt();
        System.out.println(nearestSq(inNum));
    }

}
