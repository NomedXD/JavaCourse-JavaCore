package by.teachmeskills.homeworks.hw_31032023.task3;

public class Calculator {

    private Calculator() {

    }

    public static <N extends Number, T extends Number> Double summation(N num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <N extends Number, T extends Number> Double subtraction(N num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <N extends Number, T extends Number> Double multiplication(N num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <N extends Number, T extends Number> Double division(N num1, T num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <N extends Number, T extends Number> Double fastPow(N num1, T power) {
        return Math.pow(num1.doubleValue(), power.doubleValue());
    }

    public static <N extends Number> Double module(N num1) {
        return ((num1.doubleValue() <= 0) ? -num1.doubleValue() : num1.doubleValue());
    }

}
