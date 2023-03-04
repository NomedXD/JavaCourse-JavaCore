package by.teachmeskills.homeworks.hw_03032023.task4.calculator_task;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целочисленные операнд 1 и операнд 2");
        Calculator calculator = new Calculator(in.nextInt(), in.nextInt());
        boolean option = false;
        do {
            System.out.println("Введите, что хотите сделать");
            System.out.println("1- ввести новые операнды");
            System.out.println("2- выбрать операцию и выполнить ее");
            System.out.println("3- выйти");
            switch (in.nextInt()) {
                case 1: {
                    System.out.println("Введите 2 целочисленных операнда");
                    calculator.setOperand1(in.nextInt());
                    calculator.setOperand2(in.nextInt());
                    break;
                }
                case 2: {
                    System.out.println("1- сумма");
                    System.out.println("2- разность");
                    System.out.println("3- умножение");
                    System.out.println("4 - деление");
                    switch (in.nextInt()) {
                        case 1:
                            System.out.printf("В результате сложения получилось %d ", calculator.sumOperation());
                            break;
                        case 2:
                            System.out.printf("В результате разности получилось %d ", calculator.subtractionOperation());
                            break;
                        case 3:
                            System.out.printf("В результате умножения получилось %d ", calculator.multiplicationOperation());
                            break;
                        case 4:
                            if (calculator.getOperand2() != 0)
                                System.out.printf("В результате деления получилось %.2f ", calculator.divisionOperation());
                            else System.out.printf("Деление на 0 запрещено!");
                            break;
                    }
                    break;
                }
                case 3:
                    option = true;
                    break;
            }
        } while (!option);
    }
}
