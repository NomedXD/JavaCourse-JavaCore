package by.teachmeskills.homeworks.hw_14042023.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class NotificationUtils {
    private NotificationUtils() {

    }

    public static void sendNotification(String filePath) {
        List<String> shop = Arrays.asList("маска Van", "leather gloves", "boy next door");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String user = br.readLine();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
            while (user != null) {
                String[] userArray = user.split(" ");
                LocalDate clientDate = LocalDate.parse(userArray[4], formatter);
                clientDate = clientDate.plusYears(currentDate.getYear() - clientDate.getYear());
                LocalDate beforeBD = clientDate.minusDays(7);
                LocalDate dayBefore = clientDate.plusDays(6);
                if (currentDate.equals(beforeBD)) {
                    System.out.print("Уважаемый(-мая)" + userArray[0] + " " + userArray[1] + " " + userArray[2]);
                    System.out.print(",магазин ГачиШоп в Ваш День рождения дарит Вам скидку в 15% на " +
                            "следующие товары " + shop);
                    System.out.print(".Скидка действует с " + clientDate.format(formatter1) + " до "
                            + clientDate.plusDays(7).format(formatter1) +
                            " Будем рады видеть в нашем магазине");
                } else {
                    if (currentDate.equals(clientDate)) {
                        System.out.print("Уважаемый(-мая)" + userArray[0] + " " + userArray[1] + " " + userArray[2]);
                        System.out.print("! Магазин ГачиШоп поздравляет Вас с Днем рождения и дарит Вам скидку в 15% на " +
                                "следующие товары " + shop);
                        System.out.print(".Скидка действует с " + clientDate.format(formatter1) + " до "
                                + clientDate.plusDays(7).format(formatter1) +
                                " Будем рады видеть в нашем магазине");
                    } else {
                        if (currentDate.equals(dayBefore)) {
                            System.out.print("Уважаемый(-мая)" + userArray[0] + " " + userArray[1] + " " + userArray[2]);
                            System.out.print(",магазин ГачиШоп напоминает Вам про скидку в 15% на " +
                                    "следующие товары " + shop);
                            System.out.print(".Скидка действует с " + clientDate.format(formatter1) + " до "
                                    + clientDate.plusDays(7).format(formatter1) +
                                    " Будем рады видеть в нашем магазине");
                        }
                    }
                }
                user = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("File error while sending notification");
        }
    }
}
