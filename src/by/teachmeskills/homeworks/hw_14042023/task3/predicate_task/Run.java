package by.teachmeskills.homeworks.hw_14042023.task3.predicate_task;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class Run {
    public static void main(String[] args) {
        Predicate<String> lambdaNullCheck = Objects::nonNull;
        Predicate<String> lambdaEmptyCheck = s -> !s.isEmpty();
        System.out.println("Введите строку");
        Scanner in = new Scanner(System.in);
        String sourceString = in.nextLine();
        System.out.println(lambdaEmptyCheck.and(lambdaNullCheck).test(sourceString));
    }
}
