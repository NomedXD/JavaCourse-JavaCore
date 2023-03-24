package by.teachmeskills.homeworks.hw_31032023.task3;

import javax.swing.plaf.metal.MetalTheme;

public class Calculator {

    private Calculator() {

    }

    public static <N1 extends Number, N2 extends Number> Double summation(N1 num1, N2 num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> Double subtraction(N1 num1, N2 num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> Double multiplication(N1 num1, N2 num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> Double division(N1 num1, N2 num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <N1 extends Number, N2 extends Number> Double fastPow(N1 num1, N2 power) {
        return Math.pow(num1.doubleValue(), power.doubleValue());
    }

    public static <N1 extends Number> Double module(N1 num1) {
        return ((num1.doubleValue() <= 0) ? -num1.doubleValue() : num1.doubleValue());
    }

}
