package by.teachmeskills.hw_12052023.paymentsystem;

import by.teachmeskills.hw_12052023.paymentsystem.exeptions.BankAccountNotFoundException;
import by.teachmeskills.hw_12052023.paymentsystem.exeptions.MerchantNotFoundException;
import by.teachmeskills.hw_12052023.paymentsystem.exeptions.NoBankAccountsFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String GET_MERCHANTS_QUERY = "SELECT * FROM merchant";
    private static final String INSERT_MERCHANT_QUERY = "INSERT INTO merchant (id, name, created_at) Values (?, ?, ?)";
    private static final String SELECT_MERCHANT_BY_ID_QUERY = "SELECT * FROM merchant WHERE id = ?";
    private static final String DELETE_MERCHANT_BY_ID_QUERY = "DELETE FROM merchant WHERE id = ?";
    private static final String COUNT_DUPLICATE_BANK_ACCOUNT = "SELECT * FROM bank_account WHERE account_number = ? AND merchant_id = ?";
    private static final String INSERT_BANK_ACCOUNT_QUERY = "INSERT INTO bank_account (id, merchant_id, status, account_number, " +
            "created_at) Values (?, ?, ?, ?, ?)";
    // Update и delete можно заменить на один запрос и поставить вайлдкарт символ
    private static final String UPDATE_ACCOUNT_STATUS = "UPDATE bank_account SET status = ACTIVE WHERE merchant_id = ? AND account_number = ?";
    private static final String GET_BANK_ACCOUNTS_QUERY = "SELECT * FROM bank_account WHERE merchant_id = ? ORDER BY status, created_at";
    private static final String DELETE_BANK_ACCOUNT_QUERY = "UPDATE bank_account SET status = DELETE WHERE merchant_id = ? AND account_number = ?";
    private static final String UPDATE_ACCOUNT_NUMBER = "UPDATE bank_account SET account_number = ? WHERE merchant_id = ? AND account_number = ?";

    private static Connection connection;

    private CRUDUtils() {
        connection = DBUtils.getConnection();
    }

    public static void addBankAccount(BankAccount bankAccount) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_BANK_ACCOUNT_QUERY);
            preparedStatement.setString(1, bankAccount.getId());
            preparedStatement.setString(2, bankAccount.getMerchantId());
            preparedStatement.setString(3, bankAccount.getStatus().toString());
            preparedStatement.setString(4, bankAccount.getAccountNumber());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(bankAccount.getCreatedAt()));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Во время добавления банковского аккаунта произошла ошибка");
        }
    }

    public static int findExistingAccount(BankAccount bankAccount) {
        PreparedStatement preparedStatement = null;
        try {
            // Пытался с помощью COUNT, но не получилось
            preparedStatement = connection.prepareStatement(COUNT_DUPLICATE_BANK_ACCOUNT);
            preparedStatement.setString(1, bankAccount.getAccountNumber());
            preparedStatement.setString(2, bankAccount.getMerchantId());
            ResultSet resultSet = preparedStatement.executeQuery();
            int size = 0;
            while (resultSet.next()) {
                size++;
            }
            return size;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static String checkForActiveStatus(BankAccount bankAccount) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(COUNT_DUPLICATE_BANK_ACCOUNT);
            preparedStatement.setString(1, bankAccount.getAccountNumber());
            preparedStatement.setString(2, bankAccount.getMerchantId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getString("status");
        } catch (SQLException e) {
            throw new IllegalArgumentException("При поиске аккаунтов произошла неизвестная ошибка");
        }
    }

    public static void updateBankAccountStatus(BankAccount bankAccount) throws IllegalArgumentException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_STATUS);
            preparedStatement.setString(1, bankAccount.getMerchantId());
            preparedStatement.setString(2, bankAccount.getAccountNumber());
            int res = preparedStatement.executeUpdate();
            if (res == 0) {
                throw new IllegalArgumentException("При поиске аккаунтов произошла неизвестная ошибка");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("При поиске аккаунтов произошла неизвестная ошибка");
        }
    }

    public static List<BankAccount> getMerchantBankAccounts(String id) throws NoBankAccountsFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BANK_ACCOUNTS_QUERY);
            preparedStatement.setString(1, id);
            ResultSet set = preparedStatement.executeQuery();
            List<BankAccount> list = new ArrayList<>();
            while (set.next()) {
                StatusCondition status = (set.getString("status").equals("ACTIVE")) ?
                        StatusCondition.ACTIVE : StatusCondition.DELETED;
                list.add(new BankAccount(set.getString("id"), set.getString("merchant_id"),
                        status, set.getString("account_number"),
                        set.getTimestamp("created_at").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            throw new NoBankAccountsFoundException("Таких аккаунтов не найдено, проверьте id мерчанта");
        }
    }

    public static void updateBankAccount(String newNumber, String merchant_id, String account_number) throws BankAccountNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_NUMBER);
            preparedStatement.setString(1, newNumber);
            preparedStatement.setString(2, merchant_id);
            preparedStatement.setString(3, account_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankAccountNotFoundException("Такой банковский аккаунт не найден");
        }
    }

    public static void deleteBankAccount(String merchantId, String accountNum) throws BankAccountNotFoundException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_BANK_ACCOUNT_QUERY);
            preparedStatement.setString(1, merchantId);
            preparedStatement.setString(2, accountNum);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankAccountNotFoundException("Ошибка удаления. Проверьте номер аккаунта");
        }
    }

    public static void createMerchant(Merchant merchant) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MERCHANT_QUERY);
            preparedStatement.setString(1, merchant.getId());
            preparedStatement.setString(2, merchant.getName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(merchant.getCreatedAt()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Во время добавления произошла неизвестная ошибка");
        }
    }

    public static List<Merchant> getMerchants() {
        try {
            ResultSet set = connection.createStatement().executeQuery(GET_MERCHANTS_QUERY);
            List<Merchant> list = new ArrayList<>();
            // Можно было и это вынести в MerchantSDervice и возвращать ResultSet. Но сделаем вид, что сервис
            // не знает что такое ResultSet :)
            while (set.next()) {
                list.add(new Merchant(set.getString("id"), set.getString("name"),
                        set.getTimestamp("created_at").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>() {
        };
    }

    public static Merchant getMerchantById(String id) throws MerchantNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MERCHANT_BY_ID_QUERY);
            preparedStatement.setString(1, id);
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            return new Merchant(set.getString("id"), set.getString("name"),
                    set.getTimestamp("created_at").toLocalDateTime());
        } catch (SQLException e) {
            throw new MerchantNotFoundException("Не найден мерчант с таким id");
        }
    }

    public static void deleteMerchant(String id) throws MerchantNotFoundException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_MERCHANT_BY_ID_QUERY);
            preparedStatement.setString(1, id);
            int res = preparedStatement.executeUpdate();
            if (res == 0) {
                throw new MerchantNotFoundException("Не найден мерчант с таким id");
            }
            System.out.println("Мерчант успешно удален");
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("При удалении произошла неизвестная ошибка");
        }

    }
}