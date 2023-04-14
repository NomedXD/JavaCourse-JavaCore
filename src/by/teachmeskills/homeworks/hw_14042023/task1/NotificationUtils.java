package by.teachmeskills.homeworks.hw_14042023.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationUtils {
    public static final DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");

    private NotificationUtils() {

    }

    private static Map<String, String> initializeMap(String[] readData) {
        Map<String, String> tempMap = new HashMap<>();
        tempMap.put("name", readData[0] + " " + readData[1] + " " + readData[2]);
        tempMap.put("date", readData[4]);
        tempMap.put("phone", readData[3]);
        return tempMap;
    }

    private static void checkBeforeDate(LocalDate currentDate, LocalDate beforeBD, LocalDate clientDate,
                                        Map<String, String> userData, List<String> shop) {
        if (currentDate.equals(beforeBD)) {
            System.out.print("Уважаемый(-мая)" + userData.get("name"));
            System.out.print(",магазин ГачиШоп в Ваш День рождения дарит Вам скидку в 15% на " +
                    "следующие товары " + shop);
            System.out.print(".Скидка действует с " + clientDate.format(FORMATTER2) + " до "
                    + clientDate.plusDays(7).format(FORMATTER2) +
                    " Будем рады видеть в нашем магазине");
        }
    }

    private static void checkCurrentDate(LocalDate currentDate, LocalDate clientDate, Map<String, String> userData,
                                         List<String> shop) {
        if (currentDate.equals(clientDate)) {
            System.out.print("Уважаемый(-мая)" + userData.get("name"));
            System.out.print("! Магазин ГачиШоп поздравляет Вас с Днем рождения и дарит Вам скидку в 15% на " +
                    "следующие товары " + shop);
            System.out.print(".Скидка действует с " + clientDate.format(FORMATTER2) + " до "
                    + clientDate.plusDays(7).format(FORMATTER2) +
                    " Будем рады видеть в нашем магазине");
        }
    }

    private static void checkDayBeforeDate(LocalDate currentDate, LocalDate clientDate, LocalDate dayBefore,
                                           Map<String, String> userData, List<String> shop) {
        if (currentDate.equals(dayBefore)) {
            System.out.print("Уважаемый(-мая)" + userData.get("name"));
            System.out.print(",магазин ГачиШоп напоминает Вам про скидку в 15% на " +
                    "следующие товары " + shop);
            System.out.print(".Скидка действует с " + clientDate.format(FORMATTER2) + " до "
                    + clientDate.plusDays(7).format(FORMATTER2) +
                    " Будем рады видеть в нашем магазине");
        }
    }

    public static void sendNotification(String filePath) {
        List<String> shop = Arrays.asList("маска Van", "leather gloves", "boy next door");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String user = br.readLine();
            LocalDate currentDate = LocalDate.now();
            while (user != null) {
                String[] readData = user.split(" ");
                Map<String, String> userData = initializeMap(readData);
                LocalDate clientDate = LocalDate.parse(userData.get("date"), FORMATTER1);
                clientDate = clientDate.plusYears(currentDate.getYear() - clientDate.getYear());
                LocalDate beforeBD = clientDate.minusDays(7);
                LocalDate dayBefore = clientDate.plusDays(6);
                checkBeforeDate(currentDate, beforeBD, clientDate, userData, shop);
                checkCurrentDate(currentDate, clientDate, userData, shop);
                checkDayBeforeDate(currentDate, clientDate, dayBefore, userData, shop);
                user = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("File error while sending notification");
        }
    }
}
