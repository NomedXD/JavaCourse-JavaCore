package by.teachmeskills.homeworks.hw_03032023.task3;

import by.teachmeskills.homeworks.hw_03032023.task2.Transport;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Animal[] arrayAnimals = new Animal[100]; // Ну раз нужно на массиве, значит ладно :(
    static int currentIndex = 0;

    private static void printOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите картинку для поиска животного");
        String temp = in.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (Objects.equals(arrayAnimals[i].picture, temp)) {
                arrayAnimals[i].printall();
                break;
            }
        }
    }

    private static void changeCharacteristics() {
        System.out.println("Введите картинку для поиска животного");
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (Objects.equals(arrayAnimals[i].picture, temp)) {
                System.out.println("Введите новую картинку");
                arrayAnimals[i].setPicture(in.nextLine());
                System.out.println("Введите голодно ли животное");
                arrayAnimals[i].setHunger(in.nextBoolean());
                in.nextLine();
                System.out.println("Введите новый тип пищи животного");
                switch (in.nextLine()) {
                    case "MILK":
                        arrayAnimals[i].setFoodType(Animal.FoodType.MILK);
                        break;
                    case "MEAT":
                        arrayAnimals[i].setFoodType(Animal.FoodType.MEAT);
                        break;
                    case "BONES":
                        arrayAnimals[i].setFoodType(Animal.FoodType.BONES);
                        break;
                    case "GRASS":
                        arrayAnimals[i].setFoodType(Animal.FoodType.GRASS);
                        break;
                }

                System.out.println("Введите новые координаты x и y");
                arrayAnimals[i].location.setX(in.nextInt());
                arrayAnimals[i].location.setY(in.nextInt());
                System.out.println("Введите новые ширину и высоту");
                arrayAnimals[i].boundaries.setWidth(in.nextInt());
                arrayAnimals[i].boundaries.setWidth(in.nextInt());
                break;
            }
        }
    }

    private static void deleteAnimal() {
        System.out.println("Введите картинку для поиска животного");
        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (Objects.equals(arrayAnimals[i].picture, temp)) {
                for (int j = i; j < currentIndex - 1; i++) {
                    arrayAnimals[j] = arrayAnimals[j + 1];
                }
                break;
            }
        }
        currentIndex--;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = true;
        int option;
        do {
            System.out.println("Выберите опцию из списка:");
            System.out.println("1 - создать животное ");
            System.out.println("2 - вывести информацию по картинке");
            System.out.println("3 - изменить характеристики животного по картинке");
            System.out.println("4 - удалить животное по картинке");
            System.out.println("5 - выход из программы\n");
            option = in.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Введите тип животного");
                    System.out.println("1 - гиппопотам");
                    System.out.println("2 - семейство кошачьих");
                    System.out.println("3 - семейство собачьих");
                    int a = in.nextInt();
                    in.nextLine();
                    switch (a) {
                        case 1: {
                            System.out.println("Введите картинку");
                            String temp = in.nextLine();
                            arrayAnimals[currentIndex] = new Hippo(temp, true, Animal.FoodType.MEAT);
                            System.out.println("Введите координаты x и y");
                            arrayAnimals[currentIndex].location = new Animal.Location(in.nextInt(), in.nextInt());
                            System.out.println("Введите ширину и высоту животного");
                            arrayAnimals[currentIndex].boundaries = new Animal.Boundaries(in.nextInt(), in.nextInt());
                            currentIndex++;
                            break;
                        }
                        case 2: {
                            System.out.println("Введите род");
                            System.out.println("1 - кошка");
                            System.out.println("2 - лев");
                            System.out.println("3 - тигр");
                            int temp = in.nextInt();
                            in.nextLine();
                            System.out.println("Введите картинку");
                            String strTemp = in.nextLine();
                            switch (temp) {
                                case 1:
                                    arrayAnimals[currentIndex] = new Cat(strTemp, false, Animal.FoodType.MILK);
                                    break;
                                case 2:
                                    arrayAnimals[currentIndex] = new Lion(strTemp, true, Animal.FoodType.MEAT);
                                    break;
                                case 3:
                                    arrayAnimals[currentIndex] = new Tiger(strTemp, true, Animal.FoodType.MEAT);
                                    break;
                            }
                            System.out.println("Введите координаты x и y");
                            arrayAnimals[currentIndex].location = new Animal.Location(in.nextInt(), in.nextInt());
                            System.out.println("Введите ширину и высоту животного");
                            arrayAnimals[currentIndex].boundaries = new Animal.Boundaries(in.nextInt(), in.nextInt());
                            currentIndex++;
                            break;

                        }
                        case 3: {
                            System.out.println("Введите род");
                            System.out.println("1 - собака");
                            System.out.println("2 - волк");
                            int temp = in.nextInt();
                            in.nextLine();
                            System.out.println("Введите картинку");
                            String strTemp = in.nextLine();
                            switch (temp) {
                                case 1:
                                    arrayAnimals[currentIndex] = new Dog(strTemp, false, Animal.FoodType.BONES);
                                    break;
                                case 2:
                                    arrayAnimals[currentIndex] = new Wolf(strTemp, true, Animal.FoodType.MEAT);
                                    break;
                            }
                            System.out.println("Введите координаты x и y");
                            arrayAnimals[currentIndex].location = new Animal.Location(in.nextInt(), in.nextInt());
                            System.out.println("Введите ширину и высоту животного");
                            arrayAnimals[currentIndex].boundaries = new Animal.Boundaries(in.nextInt(), in.nextInt());
                            currentIndex++;
                            break;
                        }
                    }
                    break;

                }
                case 2: {
                    printOption();
                    break;
                }
                case 3: {
                    changeCharacteristics();
                    break;
                }
                case 4: {
                    deleteAnimal();
                    break;
                }
                case 5:
                    exit = false;
                    break;
            }
        } while (exit);
    }
}
