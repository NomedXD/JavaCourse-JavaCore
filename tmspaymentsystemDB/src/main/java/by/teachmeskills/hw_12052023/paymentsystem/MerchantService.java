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

    public void addMerchantOption(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя мерчанта");
        String name = in.nextLine();
        String id = java.util.UUID.randomUUID().toString();
        System.out.println("Вашему мерчанту присвоен универсальный уникальный идентификатор(UUID) : " + id);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Дата добавления вашего мерчанта в систему : " + localDateTime + "\n");
        CRUIDUtils.createMerchant(new Merchant(id, name, localDateTime), connection);
        System.out.println("Мерчант успешно добавлен");
    }

    public void showMerchantsOption(Connection connection) {
        Objects.requireNonNull(CRUIDUtils.getMerchants(connection)).forEach(s -> {
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    s.getId(), s.getName(), s.getCreatedAt());
        });
        System.out.println();
    }

    public void getByIdOption(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для поиска");
        try {
            Merchant temp = CRUIDUtils.getMerchantById(in.nextLine(), connection);
            System.out.printf("Мерчант: UUID - %s, имя - %s, дата добавления в систему - %s \n",
                    temp.getId(), temp.getName(), temp.getCreatedAt());
        } catch (MerchantNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void deleteMerchantOption(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для удаления");
        try {
            CRUIDUtils.deleteMerchant(in.nextLine(), connection);
        } catch (MerchantNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBankAccountMerchant(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта для добавления ему банкоского аккаунта");
        try {
            Merchant temp = CRUIDUtils.getMerchantById(in.nextLine(), connection);
            System.out.println("Введите желаемый номер нового аккаунта");
            String id = java.util.UUID.randomUUID().toString();
            String num = in.nextLine();
            BankAccount bankAccount = new BankAccount
                    (id, temp.getId(), StatusCondition.ACTIVE, num, LocalDateTime.now());
            if (validateBankAccountNumber(num)) {

                switch (CRUIDUtils.findExistingAccount(bankAccount, connection)) {
                    case 0 -> {
                        CRUIDUtils.addBankAccount(bankAccount, connection);
                        System.out.println("Ваш аккаунт добавлен, ему присвоен универсальный " +
                                "уникальный идентификатор(UUID) : " + id);
                    }
                    case 1 -> {
                        if (Objects.equals(CRUIDUtils.checkForActiveStatus(bankAccount, connection), "DELETED")) {
                            CRUIDUtils.updateBankAccountStatus(bankAccount, connection);
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

    public void showBankAccountsOption(Connection connection) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите id мерчанта, аккаунты которого нужно вывести");
            Objects.requireNonNull(CRUIDUtils.getMerchantBankAccounts(in.nextLine(), connection)).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
        } catch (NoBankAccountsFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    public void updateAccountOption(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого обновляется аккаунт");
        try {
            String merchantId = in.nextLine();
            Merchant temp = CRUIDUtils.getMerchantById(merchantId, connection);
            Objects.requireNonNull(CRUIDUtils.getMerchantBankAccounts(temp.getId(), connection)).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
            System.out.println("Введите номер аккаунта, который требуется изменить");
            String accountNum = in.nextLine();
            if (validateBankAccountNumber(accountNum)) {
                System.out.println("Введите новый номер аккаунта");
                String newNumber = in.nextLine();
                CRUIDUtils.updateBankAccount(newNumber, merchantId, accountNum, connection);
            }
        } catch (MerchantNotFoundException | NoBankAccountsFoundException |
                 BankAccountNotFoundException e) {
            System.out.printf(e.getMessage());
        }
    }

    public void deleteAccountOption(Connection connection) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id мерчанта, у которого требуется удалить аккаунт");
        try {
            String merchantId = in.nextLine();
            Merchant temp = CRUIDUtils.getMerchantById(merchantId, connection);
            Objects.requireNonNull(CRUIDUtils.getMerchantBankAccounts(temp.getId(), connection)).forEach(s -> {
                System.out.printf("UUID - %s, мерчант UUID - %s, статус - %s, номер аккаунта - %s, " +
                                " добавления в систему - %s \n",
                        s.getId(), s.getMerchantId(), s.getStatus(), s.getAccountNumber(), s.getCreatedAt());
            });
            System.out.println("Введите номер аккаунта, который требуется удалить");
            String accountNum = in.nextLine();
            if (validateBankAccountNumber(accountNum)) {
                CRUIDUtils.deleteBankAccount(merchantId, accountNum, connection);
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

