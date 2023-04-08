package by.teachmeskills.homeworks.hw_14042023.task3.functional_task;

import java.util.Scanner;
import java.util.function.Function;

public class Run {
    public static void main(String[] args) {
        Function<Integer,String> lambda = s -> {
            if(s>0){
                return "Положительное число";
            } else if (s<0) {
              return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };
        Scanner in = new Scanner(System.in);
        System.out.println(lambda.apply(in.nextInt()));
    }
}
