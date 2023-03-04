package by.teachmeskills.homeworks.hw_10032023.Task2;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.println("Введите количество учеников");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        System.out.println("Введите время года");
        University university = new University();
        switch (in.nextLine()) {
            case "Зима", "зима":
                university.setSeason(University.Season.WINTER);
                university.setStudentsCount(count);
                break;
            case "Лето", "лето":
                university.setSeason(University.Season.SUMMER);
                university.setStudentsCount(count);
                break;
            case "Весна", "весна":
                university.setSeason(University.Season.SPRING);
                university.setStudentsCount(count);
                break;
            case "Осень", "осень":
                university.setSeason(University.Season.AUTUMN);
                university.setStudentsCount(count);
                break;
        }
        university.printAll();
    }
}
