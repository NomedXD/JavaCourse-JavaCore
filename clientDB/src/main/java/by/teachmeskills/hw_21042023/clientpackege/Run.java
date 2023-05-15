package by.teachmeskills.hw_21042023.clientpackege;

import by.teachmeskills.hw_12052023.paymentsystem.DBUtils;
import by.teachmeskills.hw_12052023.paymentsystem.MerchantService;

import java.sql.Connection;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        boolean exitOption = false;
        Scanner in = new Scanner(System.in);
        MerchantService merchantService = new MerchantService();
        while (!exitOption) {
            System.out.println("Введите опцию для работы в системе TMS Finance");
            System.out.println("1 - Создать нового мерчанта в платежной системе");
            System.out.println("2 - Вывести всех мерчантов платежной системы");
            System.out.println("3 - Найти мерчанта по id");
            System.out.println("4 - Удалить мерчанта из списка");
            System.out.println("5 - Добавить банковский аккаунт мерчанту");
            System.out.println("6 - Отобразить банковские акканты мерчанта");
            System.out.println("7 - Редактировать банковский аккаунт мерчанта");
            System.out.println("8 - Удалить банковский аккаунт мерчанта");
            System.out.println("9 - Выход");
            switch (in.nextLine()) {
                case "1" -> {
                    merchantService.addMerchantOption();
                }
                case "2" -> {
                    merchantService.showMerchantsOption();
                }
                case "3" -> {
                    merchantService.getByIdOption();
                }
                case "4" -> {
                    merchantService.deleteMerchantOption();
                }
                case "5" -> {
                    merchantService.addBankAccountMerchant();
                }
                case "6" -> {
                    merchantService.showBankAccountsOption();
                }
                case "7" -> {
                    merchantService.updateAccountOption();
                }
                case "8" -> {
                    merchantService.deleteAccountOption();
                }
                case "9" -> {
                    exitOption = true;
                }
            }
        }
    }
}
