package by.teachmeskills.homeworks.hw_24022023;

import java.util.Scanner;

public class ComputerClassTask {

    private TypeProcessor type;
    private int ramCapacity;
    private int hardDriveCapacity;

    private boolean turnOnError, turnOffError, condition;

    public ComputerClassTask(TypeProcessor type, int ramCapacity, int hardDriveCapacity) {
        this.type = type;
        this.ramCapacity = ramCapacity;
        this.hardDriveCapacity = hardDriveCapacity;
        this.turnOnError = false;
        this.turnOffError = false;
        this.condition = false;
    }


    private void printInfo() {
        System.out.printf("Тип процессора: %s; Объем оперативной памяти: %d; Объем жесткого диска: %d", type.toString(), ramCapacity, hardDriveCapacity);
    }

    private void turnOn() {
        if (!condition && !turnOnError) {
            System.out.println("Попытай свою удачу, воин, введи 0 или 1 и испытай судьбу");
            Scanner in = new Scanner(System.in);
            int gener = in.nextInt();
            long rand = Math.round(Math.random());
            if (gener == rand) {
                System.out.println("На этот раз удача при тебе, компик включился");
                condition = true;
            } else {
                System.out.println("Ха, компьютер сгорел и вырубил пробки дома");
                turnOnError = true;
                condition = false;
            }
        } else if (condition)
            System.out.println("Компьютер уже включен!");
        else System.out.println("Компьютеру уже давно крышка");
    }

    private void turnOff() {
        if (condition && !turnOffError) {
            System.out.println("Попробуй выключить компьютер, загадай 0 или 1");
            Scanner in = new Scanner(System.in);
            int gener = in.nextInt();
            long rand = Math.round(Math.random());
            if (gener == rand) {
                System.out.println("Компьютер успешно выключился");
                condition = false;
            } else {
                System.out.println("Компьютер полностью завис и не хочет выключаться");
                turnOffError = true;
            }
        } else if (!condition) {
            System.out.println("Компьютер уже выключен!");
        } else
            System.out.println("Компик уже зависнул");
    }

    private void shiftOff() {
        System.out.println("Чтобы выдернуть шнур, нужно загадать 0 или 1");
        Scanner in = new Scanner(System.in);
        int gener = in.nextInt();
        long rand = Math.round(Math.random());
        if (gener == rand) {
            System.out.println("Компьютер выключился без происшествий");
            condition = false;
            turnOffError = false;
        } else {
            System.out.println("Ха, компьютер сгорел и вырубил пробки дома");
            turnOnError = true;
            condition = false;
            turnOffError = false;
        }
    }

    public static void main(String[] args) {
        int option;
        int type = (int) (Math.random() * 4);
        TypeProcessor t = switch (type) {
            case 0 -> TypeProcessor.RISC;
            case 1 -> TypeProcessor.CISC;
            case 2 -> TypeProcessor.MISC;
            case 3 -> TypeProcessor.VLIW;
            default -> TypeProcessor.RISC;
        };
        ComputerClassTask computer = new ComputerClassTask(t, 4000, 1000);
        boolean exit = false;
        do {
            System.out.println("1 - включить компьютер");
            System.out.println("2 - выключить компьютер");
            if (computer.turnOffError) {
                System.out.println("3 - Дернуть шнур компика");
                System.out.println("4 или другие - выйти из программы");
            } else {
                System.out.println("3 или другие - выйти из программы");
            }
            System.out.println("Введите номер опции:");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1 -> computer.turnOn();
                case 2 -> computer.turnOff();
                case 3 -> {
                    if (computer.turnOffError) {
                        computer.shiftOff();
                    } else exit = true;
                }
                default -> exit = true;
            }
        } while (!exit);
    }
}

enum TypeProcessor {
    RISC, CISC, MISC, VLIW
}
