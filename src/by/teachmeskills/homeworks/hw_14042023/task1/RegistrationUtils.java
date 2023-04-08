package by.teachmeskills.homeworks.hw_14042023.task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationUtils {
    public static final String ROOT = "src\\by\\teachmeskills\\homeworks\\hw_14042023\\task1\\files\\";

    private RegistrationUtils() {

    }

    private record Client(String name, LocalDate date, String phone) {
    }

    private static void readUserData(List<Client> users) {
        System.out.println("Введите Фамилия Имя Отчество");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Введите дату рождения в формате yyyy-MM-dd");
        String date = in.nextLine();
        System.out.println("Введите номер телефона в формате +375xxyyyyyyy");
        String phone = in.nextLine();
        if (validateData(name, date, phone)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            users.add(new Client(name, LocalDate.parse(date, formatter), phone));
        } else {
            System.out.println("Клиент не добавлен по вышеуказанной причине");
        }
    }

    private static boolean validateData(String name, String date, String phone) {
        // Парсинг ФИО
        if (!name.matches("[A-Za-z ]*")) {
            System.out.println("В имени содержаться неверные символы");
            return false;
        } else {
            long spaceCount = name.chars().filter(c -> c == (int) ' ').count();
            if (spaceCount != 2) {
                System.out.println("Введены лишнее пробелы");
                return false;
            }
        }
        // Парсинг даты
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, format);
        } catch (DateTimeParseException e) {
            System.out.println("Введена дата неверного формата");
            return false;
        }
        // Парсинг номера телефона
        if (!(phone.startsWith("+37529") || phone.startsWith("+37544") || phone.startsWith("+37525") ||
                phone.startsWith("+37533"))) {
            System.out.println("Введен неверный код страны или оператора");
            return false;
        } else {
            if (!phone.matches("[+0-9]+")) {
                System.out.println("Номер телефона содержит неверные символы");
                return false;
            } else {
                if (phone.length() != 13) {
                    System.out.println("Неверная длина номера");
                    return false;
                }
            }
        }
        return true;
    }

    public static void createUserFile() {
        boolean exitFlag = true;
        Scanner in = new Scanner(System.in);
        List<Client> users = new ArrayList<>();
        while (exitFlag) {
            System.out.println("""
                    Введите доступную опцию:
                    1 - Зарегистрировать новую карту покупателя
                    2 - Выход из системы регистрации""");
            if (in.nextLine().equals("1")) {
                readUserData(users);
            } else {
                exitFlag = false;
            }
        }
        if (!users.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RegistrationUtils.ROOT + "users.txt"))) {
                for (Client c : users) {
                    bw.write(c.name + " " + c.phone + " " + c.date.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("File error");
            }
        }
    }
}
