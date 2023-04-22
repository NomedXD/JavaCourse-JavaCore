package by.teachmeskills.hw21042023.paymentsystem;

import by.teachmeskills.hw21042023.paymentsystem.exeptions.BankAccountNotFoundException;
import by.teachmeskills.hw21042023.paymentsystem.exeptions.MerchantNotFoundException;
import by.teachmeskills.hw21042023.paymentsystem.exeptions.NoBankAccountsFoundException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.teachmeskills.hw21042023.paymentsystem.IFilePathes.ROOT;

public class MerchantService {
    private final List<Merchant> merchants;

    public MerchantService() {
        this.merchants = new ArrayList<>();
    }

    public void addBankAccount(Merchant merchant, BankAccount bankAccount) throws IllegalArgumentException {
        if (!validateBankAccountNumber(bankAccount.getAccountNumber()))
            throw new IllegalArgumentException("Неверные параметры нового банковского аккаунта");
        if (merchant.getBankAccounts().stream().noneMatch(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber()))) {
            merchant.getBankAccounts().add(bankAccount);
            try (FileWriter writer = new FileWriter(ROOT + "bank_account.txt", true)) {
                writer.write(bankAccount.getMerchantId() + " " + bankAccount.getStatus() + " " +
                        bankAccount.getAccountNumber() + " " + bankAccount.getCreatedAt() + "\n");
            } catch (IOException e) {
                System.out.println("Возникла файловая ошибка");
                ;
            }
        } else {
            BankAccount temp = merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).
                    findFirst().get();
            if (temp.getStatus().equals(StatusCondition.DELETED)) {
                temp.setStatus(StatusCondition.ACTIVE);
                System.out.println("Статус аккаунт изменен на активный");
                synchronizationBankAccountFileDB();
            } else {
                System.out.println("Аккаунт уже существует и является активным");
            }
        }
    }

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) throws NoBankAccountsFoundException {
        if (merchant.getBankAccounts().size() != 0) {
            return merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedAt).
                    thenComparing(BankAccount::getStatus)).collect(Collectors.toList());
        } else {
            throw new NoBankAccountsFoundException("Не найдено аккаунтов для этого мерчанта");
        }
    }

    public BankAccount updateBankAccount(Merchant merchant, String number) throws BankAccountNotFoundException {
        return merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(number)).findFirst().orElseThrow(
                () -> new BankAccountNotFoundException("Банковский аккаунт не найден"));
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        bankAccount.setStatus(StatusCondition.DELETED);
    }

    public void createMerchant(Merchant merchant) {
        merchants.add(merchant);
        try (FileWriter writer = new FileWriter(ROOT + "merchant.txt", true)) {
            writer.write(merchant.getId() + " " + merchant.getName() + " " + merchant.getCreatedAt() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public Merchant getMerchantById(String id) throws MerchantNotFoundException {
        return merchants.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow(() ->
                new MerchantNotFoundException("Мерчант не был найден по данному id\n"));
    }

    public void deleteMerchant(String id) throws MerchantNotFoundException {
        Merchant tempMerchant = merchants.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow(() ->
                new MerchantNotFoundException("Мерчант не был найден по данному id\n"));
        tempMerchant.getBankAccounts().clear();
        merchants.remove(tempMerchant);
    }

    public void synchronizationMerchantFileDB() {
        // Создание копии на основе новых данных
        try (FileWriter writer = new FileWriter(ROOT + "merchanttemp.txt")) {
            merchants.forEach(s -> {
                try {
                    writer.write(s.getId() + " " + s.getName() + " " + s.getCreatedAt() + "\n");
                } catch (IOException e) {
                    System.out.println("При обновлении базы данных произошла ошибка");
                }
            });

        } catch (IOException e) {
            System.out.println("При обновлении базы данных произошла ошибка");
        }
        // Замены старой БД новой копией и удаление старого файла
        File file1 = new File(ROOT + "merchant.txt");
        File file2 = new File(ROOT + "merchanttemp.txt");
        File file3 = new File(ROOT + "merchant.txt");
        if (file1.exists() && file1.delete() && file2.exists()) {
            System.out.println(file2.renameTo(file3) ? "Обновление merchant.txt прошло успешно" :
                    "При обновлении merchant.txt произошла ошибка");
        }
    }

    public void synchronizationBankAccountFileDB() {
        try (FileWriter writer = new FileWriter(ROOT + "bank_accountTemp.txt")) {
            for (Merchant m : merchants) {
                m.getBankAccounts().forEach(s -> {
                    try {
                        writer.write(s.getMerchantId() + " " + s.getStatus() + " " + s.getAccountNumber() + " " +
                                s.getCreatedAt() + "\n");
                    } catch (IOException e) {
                        System.out.println("При обновлении базы данных произошла ошибка");
                    }
                });

            }
        } catch (IOException e) {
            System.out.println("При обновлении базы данных произошла ошибка");
        }
        File file1 = new File(ROOT + "bank_account.txt");
        File file2 = new File(ROOT + "bank_accountTemp.txt");
        File file3 = new File(ROOT + "bank_account.txt");
        if (file1.exists() && file1.delete() && file2.exists()) {
            System.out.println(file2.renameTo(file3) ? "Обновление bank_account прошло успешно" :
                    "При обновлении merchant.txt произошла ошибка");
        }
    }

    public boolean validateBankAccountNumber(String bankAccount) throws IllegalArgumentException {
        if (bankAccount.length() == 8 && bankAccount.matches("\\d+")) {
            return true;
        } else {
            throw new IllegalArgumentException("Введен неверный номер аккаунта");
        }
    }

    public void loadData() {
        try (Stream<String> stream1 = Files.lines(Paths.get(ROOT + "merchant.txt"));
             Stream<String> stream2 = Files.lines(Paths.get(ROOT + "bank_account.txt"))){
            List<String> s1 = stream1.toList();
            List<String> s2 = stream2.toList();
            // Чтение мерчантов из файла
            s1.forEach(s -> {
                String[] readData = s.split(" ");
                merchants.add(new Merchant(readData[0], readData[1], LocalDateTime.parse(readData[2])));
            });
            // Чтение аккаунтов из файла
            for(Merchant s : merchants){
               s2.forEach(k -> {
                    String[] readData = k.split(" ");
                    if (readData[0].equals(s.getId())) {
                        StatusCondition statusCondition = (readData[1].equals(StatusCondition.ACTIVE.toString())) ?
                                StatusCondition.ACTIVE : StatusCondition.DELETED;
                        s.getBankAccounts().add(new BankAccount(readData[0], statusCondition, readData[2],
                                LocalDateTime.parse(readData[3])));
                    }
                });
            }

        } catch (IOException e) {
            System.out.println("При загрузке данных произошла ошибка");
        }
    }
}