package by.teachmeskills.homeworks.hw_03032023.task4.calculator_task;

public class Calculator {
    private int operand1;
    private int operand2;

    public Calculator(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    int sumOperation() {
        return operand1 + operand2;
    }

    int subtractionOperation() {
        return operand1 - operand2;
    }

    int multiplicationOperation() {
        return operand1 * operand2;
    }

    float divisionOperation() {
        return (float) operand1 / operand2;
    }
}
