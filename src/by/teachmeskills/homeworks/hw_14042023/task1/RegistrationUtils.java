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
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
            users.add(new Client(name, LocalDate.parse(date, FORMATTER), phone));
        } else {
            System.out.println("Клиент не добавлен по вышеуказанной причине");
        }
    }

    private static boolean validateData(String name, String date, String phone) {
        // Парсинг ФИО
        if (!name.matches("[A-Za-z ]*")) {
            System.out.println("В имени содержаться неверные символы");
            return false;
        }
        // Парсинг даты
        try {
            LocalDate.parse(date, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Введена дата неверного формата");
            return false;
        }
        // Парсинг номера телефона
        if (!(phone.startsWith("+37529") || phone.startsWith("+37544") || phone.startsWith("+37525") ||
                phone.startsWith("+37533")) && !phone.matches("[+0-9]+")) {
            System.out.println("Введен неверный код страны, оператора или введены неверные символы");
            return false;
        } else {
            if (phone.length() != 13) {
                System.out.println("Неверная длина номера");
                return false;
            }
        }
        return true;
    }

    public static void createUserFile() {
        boolean exitFlag = false;
        Scanner in = new Scanner(System.in);
        List<Client> users = new ArrayList<>();
        while (!exitFlag) {
            System.out.println("""
                    Введите доступную опцию:
                    1 - Зарегистрировать новую карту покупателя
                    2 - Выход из системы регистрации""");
            if (in.nextLine().equals("1")) {
                readUserData(users);
            } else {
                exitFlag = true;
            }
        }
        if (!users.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(IFilePathes.ROOT + "users.txt"))) {
                for (Client c : users) {
                    bw.write(c.name.trim().replaceAll(" +", " ") + " "
                            + c.phone + " " + c.date.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("File error");
            }
        }
    }
}
