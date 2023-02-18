package by.teachmeskills.homeworks.hw_24022023;

import java.util.Scanner;

public class RecursionTask3 {
    /*
    Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки,
    или слово NO в противном случае.
    Операцией возведения в степень пользоваться нельзя!
     */
    public static void main(String[] args) {
        System.out.println("Введите число N");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        recursionFunc(N);
    }

    private static void recursionFunc(int N) {
        if (N % 2 != 0 || N <= 0) {
            System.out.println("NO");
            return;
        } else {
            N /= 2;
            if (N == 1) {
                System.out.println("YES");
                return;
            } else recursionFunc(N);
        }
    }
}
