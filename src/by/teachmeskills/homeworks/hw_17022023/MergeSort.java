package by.teachmeskills.homeworks.hw_17022023;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива n");
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 30);

        }
        System.out.println(Arrays.toString(arr));
        int[] buffer = new int[arr.length];
        System.out.println(Arrays.toString(Solution(arr,buffer,0, arr.length-1)));
    }

    private static int[] Solution(int[] array, int[] buffer, int leftindex, int rightindex) {
        if (leftindex < rightindex) {
           int middle = (rightindex+leftindex)/2;
           Solution(array,buffer,leftindex,middle);
           Solution(array,buffer,middle+1,rightindex);

           int k=leftindex;
           for(int i=leftindex,j=middle+1;i<=middle || j<=rightindex;){
               if(j>rightindex || (i<=middle && array[i]<array[j])){
                   buffer[k]=array[i];
                   i++;
               } else
               {
                   buffer[k]=array[j];
                   j++;
               }
               k++;
           }

           for(int i=leftindex;i<=rightindex;i++){
               array[i]=buffer[i];
           }
        }
        return array;
    }
}
