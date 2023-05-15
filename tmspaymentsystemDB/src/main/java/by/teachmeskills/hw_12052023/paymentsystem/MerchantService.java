package by.teachmeskills.hw_12052023.paymentsystem;

import by.teachmeskills.hw_12052023.paymentsystem.exeptions.BankAccountNotFoundException;
import by.teachmeskills.hw_12052023.paymentsystem.exeptions.MerchantNotFoundException;
import by.teachmeskills.hw_12052023.paymentsystem.exeptions.NoBankAccountsFoundException;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class MerchantService {
    public MerchantService() {

    }

    public void addMerchantOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя мерчанта");
        String name = in.nextLine();
        String id = java.util.UUID.randomUUID().toString();
        System.out.println("Вашему мерчанту присвоен универсальный уникальный идентификатор(UUID) : " + id);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Дата добавления вашего мерчанта в систему : " + localDateTime + "\n");
        CRUDUtils.createMerchant(new Merchant(id, name, localDateTime));
        System.out.println("Мерчант успешно добавлен");
    }

    public void showMerchantsOption() {
        Objects.requireNonNull(CRUDUtils.getMerchants()).forEach(s -> {
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    s.getId(), s.getName(), s.getCreatedAt());
        });
        System.out.println();
    }

    public void getByIdOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для поиска");
        try {
            Merchant temp = CRUDUtils.getMerchantById(in.nextLine());
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    temp.getId(), temp.getName(), temp.getCreatedAt());
        } catch (MerchantNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void deleteMerchantOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для удаления");
        try {
            CRUDUtils.deleteMerchant(in.nextLine());
        } catch (MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBankAccountMerchant() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для добавления ему банкоского аккаунта");
        try {
            Merchant temp = CRUDUtils.getMerchantById(in.nextLine());
            System.out.println("Введите желаемый номер нового аккаунта");
            String id = java.util.UUID.randomUUID().toString();
            String num = in.nextLine();
            BankAccount bankAccount = new BankAccount
                    (id, temp.getId(), StatusCondition.ACTIVE, num, LocalDateTime.now());
            if (validateBankAccountNumber(num)) {

                switch (CRUDUtils.findExistingAccount(bankAccount)) {
                    case 0 -> {
                        CRUDUtils.addBankAccount(bankAccount);
                        System.out.println("Ваш аккаунт добавлен, ему присвоен универсальный " +
                                "уникальный идентификатор(UUID) : " + id);
                    }
                    case 1 -> {
                        if (Objects.equals(CRUDUtils.checkForActiveStatus(bankAccount), "DELETED")) {
                            CRUDUtils.updateBankAccountStatus(bankAccount);
                            System.out.println("Ваш аккаунт восстановлен");
                        } else {
                            System.out.println("Такой активный аккаунт уже имеется");
                        }
                    }
                }

            }
        } catch (IllegalArgumentException | MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showBankAccountsOption() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите id мерчанта, аккаунты которого нужно вывести");
            Objects.requireNonNull(CRUDUtils.getMerchantBankAccounts(in.nextLine())).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
        } catch (NoBankAccountsFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void updateAccountOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого обновляется аккаунт");
        try {
            String merchantId = in.nextLine();
            Merchant temp = CRUDUtils.getMerchantById(merchantId);
            Objects.requireNonNull(CRUDUtils.getMerchantBankAccounts(temp.getId())).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
            System.out.println("Введите номер аккаунта, который требуется изменить");
            String accountNum = in.nextLine();
            if (validateBankAccountNumber(accountNum)) {
                System.out.println("Введите новый номер аккаунта");
                String newNumber = in.nextLine();
                CRUDUtils.updateBankAccount(newNumber, merchantId, accountNum);
            }
        } catch (MerchantNotFoundException | NoBankAccountsFoundException |
                 BankAccountNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void deleteAccountOption() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого требуется удалить аккаунт");
        try {
            String merchantId = in.nextLine();
            Merchant temp = CRUDUtils.getMerchantById(merchantId);
            Objects.requireNonNull(CRUDUtils.getMerchantBankAccounts(temp.getId())).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
            System.out.println("Введите номер аккаунта, который требуется удалить");
            String accountNum = in.nextLine();
            if (validateBankAccountNumber(accountNum)) {
                CRUDUtils.deleteBankAccount(merchantId, accountNum);
                System.out.println("Банковский аккаунт удален");
            }
        } catch (MerchantNotFoundException | NoBankAccountsFoundException |
                 BankAccountNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    private static boolean validateBankAccountNumber(String bankAccount) throws IllegalArgumentException {
        if (bankAccount.length() == 8 && bankAccount.matches("\\d+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Введен неверный номер аккаунта");
        }
    }


}

