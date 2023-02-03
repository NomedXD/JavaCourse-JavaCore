package by.teachmeskills.homeworks.codewarstasks.SumOfDigits;

import java.util.Scanner;

public class SumOfDigits {
    /*
     * Задача: Найти сумму цифр числа
     * Пример: 124 -> 7; 111 -> 3
     * */

    public static int sumOfDigits(int n) {
        int res=0;
        while(n>=1)
        {
            res+=n%10;
            n/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print("Введите число\n");
        Scanner in = new Scanner(System.in);
        int inNum1 = in.nextInt();
        System.out.println(sumOfDigits(inNum1));
    }
}
