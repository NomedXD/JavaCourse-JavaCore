package by.teachmeskills.hw_21042023.clientpackege;

import by.teachmeskills.hw21042023.paymentsystem.BankAccount;
import by.teachmeskills.hw21042023.paymentsystem.Merchant;
import by.teachmeskills.hw21042023.paymentsystem.MerchantService;
import by.teachmeskills.hw21042023.paymentsystem.StatusCondition;
import by.teachmeskills.hw21042023.paymentsystem.exeptions.BankAccountNotFoundException;
import by.teachmeskills.hw21042023.paymentsystem.exeptions.MerchantNotFoundException;
import by.teachmeskills.hw21042023.paymentsystem.exeptions.NoBankAccountsFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class OperationHandlerUtil {
    private OperationHandlerUtil() {

    }

    private static void addMerchantOption(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя мерчанта");
        String name = in.nextLine();
        String id = java.util.UUID.randomUUID().toString();
        System.out.println("Вашему мерчанту присвоен универсальный уникальный идентификатор(UUID) : " + id);
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Дата добавления вашего мерчанта в систему : " + date + "\n");
        merchantService.createMerchant(new Merchant(id, name, date));
    }

    private static void showMerchantsOption(MerchantService merchantService) {
        merchantService.getMerchants().forEach(s -> {
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    s.getId(), s.getName(), s.getCreatedAt());
        });
        System.out.println();
    }

    private static void getByIdOption(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для поиска");
        try {
            Merchant temp = merchantService.getMerchantById(in.nextLine());
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    temp.getId(), temp.getName(), temp.getCreatedAt());
        } catch (MerchantNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static void deleteMerchantOption(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для удаления");
        try {
            merchantService.deleteMerchant(in.nextLine());
        } catch (MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // Обновление файла merchant.txt
        merchantService.synchronizationMerchantFileDB();
        merchantService.synchronizationBankAccountFileDB();
    }

    private static void addBankAccountMerchant(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для добавления ему банкоского аккаунта");
        try {
            Merchant temp = merchantService.getMerchantById(in.nextLine());
            System.out.println("Введите желаемый номер нового аккаунта");
            merchantService.addBankAccount(temp, new BankAccount
                    (temp.getId(), StatusCondition.ACTIVE, in.nextLine(), LocalDateTime.now()));
        } catch (IllegalArgumentException | MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void showBankAccountsOption(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для поиска его банковских аккаунтов");
        try {
            Merchant tempMerchant = merchantService.getMerchantById(in.nextLine());
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    tempMerchant.getId(), tempMerchant.getName(), tempMerchant.getCreatedAt());
            List<BankAccount> tempBankList = merchantService.getMerchantBankAccounts(tempMerchant);
            tempBankList.forEach(s -> System.out.printf("Аккаунт: статус - %s, номер - %s, дата создания - %s\n",
                    s.getStatus(), s.getAccountNumber(), s.getCreatedAt()));
        } catch (MerchantNotFoundException | NoBankAccountsFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static void updateAccountOption(MerchantService merchantService) throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого обновляется аккаунт");
        try {
            Merchant tempMerchant = merchantService.getMerchantById(in.nextLine());
            List<BankAccount> tempBankList = merchantService.getMerchantBankAccounts(tempMerchant);
            tempBankList.forEach(s -> System.out.printf("Аккаунт: статус - %s, номер - %s, дата создания - %s\n",
                    s.getStatus(), s.getAccountNumber(), s.getCreatedAt()));
            System.out.println("Введите номер аккаунта, который требуется изменить");
            BankAccount temp = merchantService.updateBankAccount(tempMerchant, in.nextLine());
            System.out.println("Введите новый номер аккаунта");
            String newNumber = in.nextLine();
            merchantService.validateBankAccountNumber(newNumber);
            temp.setAccountNumber(newNumber);
            merchantService.synchronizationBankAccountFileDB();
        } catch (MerchantNotFoundException | NoBankAccountsFoundException | BankAccountNotFoundException |
                 IllegalArgumentException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static void deleteAccountOption(MerchantService merchantService) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого требуется удалить аккаунт");
        try {
            Merchant tempMerchant = merchantService.getMerchantById(in.nextLine());
            List<BankAccount> tempBankList = merchantService.getMerchantBankAccounts(tempMerchant);
            tempBankList.forEach(s -> System.out.printf("Аккаунт: статус - %s, номер - %s, дата создания - %s\n",
                    s.getStatus(), s.getAccountNumber(), s.getCreatedAt()));
            System.out.println("Введите номер аккаунта, который требуется удалить");
            String number = in.nextLine();
            merchantService.validateBankAccountNumber(number);
            BankAccount temp = tempBankList.stream().filter(s -> s.getAccountNumber().equals(number)).findFirst().
                    orElseThrow(() -> new BankAccountNotFoundException("Банковский аккаунт не найден"));
            merchantService.deleteBankAccount(temp);
            merchantService.synchronizationBankAccountFileDB();
        } catch (MerchantNotFoundException | NoBankAccountsFoundException | IllegalArgumentException |
                 BankAccountNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }


    public static void runMenu() {
        boolean exitOption = false;
        Scanner in = new Scanner(System.in);
        MerchantService merchantService = new MerchantService();
        merchantService.loadData();
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
                    addMerchantOption(merchantService);
                }
                case "2" -> {
                    showMerchantsOption(merchantService);
                }
                case "3" -> {
                    getByIdOption(merchantService);
                }
                case "4" -> {
                    deleteMerchantOption(merchantService);
                }
                case "5" -> {
                    addBankAccountMerchant(merchantService);
                }
                case "6" -> {
                    showBankAccountsOption(merchantService);
                }
                case "7" -> {
                    updateAccountOption(merchantService);
                }
                case "8" -> {
                    deleteAccountOption(merchantService);
                }
                case "9" -> {
                    exitOption = true;
                }
            }
        }
    }
}
