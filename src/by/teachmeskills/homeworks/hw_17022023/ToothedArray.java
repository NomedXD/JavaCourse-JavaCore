package by.teachmeskills.homeworks.hw_17022023;
import java.util.Scanner;

public class ToothedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк n в зубчатом массиве");
        int n = in.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int [(int)(Math.random() * 10+1)];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[i].length;j++){
               arr[i][j]= (int)(Math.random()*40-20);
                System.out.print(String.format("%4d", arr[i][j]));
            }
            System.out.print("\n");
        }
    }
}
