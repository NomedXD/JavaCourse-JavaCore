package by.teachmeskills.homeworks.hw_17022023;

import java.util.Scanner;

public class OutPutStars {
        /*
        Написать программу, которая бы вывела в консоль звездочки следующим образом:
        *****
        *****
        *****
        *****
     */

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print("*");
            System.out.print("\n");
        }
    }
}

