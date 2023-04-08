package by.teachmeskills.homeworks.hw_14042023.task3.supplier_task;

import java.util.function.Supplier;

public class Run {
    public static void main(String[] args) {
        Supplier<Integer> lambda = ()-> (int) (Math.random()*11);
        System.out.println(lambda.get());
    }
}
