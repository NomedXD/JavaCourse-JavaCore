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

import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.COUNT_DUPLICATE_BANK_ACCOUNT;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.DELETE_BANK_ACCOUNT_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.DELETE_MERCHANT_BY_ID_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.GET_BANK_ACCOUNTS_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.INSERT_BANK_ACCOUNT_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.INSERT_MERCHANT_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.GET_MERCHANTS_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.SELECT_MERCHANT_BY_ID_QUERY;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.UPDATE_ACCOUNT_NUMBER;
import static by.teachmeskills.hw_12052023.paymentsystem.IQueries.UPDATE_ACCOUNT_STATUS;

public class CRUIDUtils {

    private CRUIDUtils() {

    }

    public static void addBankAccount(BankAccount bankAccount, Connection connection) {
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

    public static int findExistingAccount(BankAccount bankAccount, Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            // Пытался с помощью COUNT, но не получилось
            preparedStatement = connection.prepareStatement(COUNT_DUPLICATE_BANK_ACCOUNT);
            preparedStatement.setString(1, bankAccount.getAccountNumber());
            preparedStatement.setString(2, bankAccount.getMerchantId());
            ResultSet resultSet = preparedStatement.executeQuery();
            int size = 0;
            while (resultSet.next()){
                size++;
            }
            return size;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static String checkForActiveStatus(BankAccount bankAccount, Connection connection) {
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

    public static void updateBankAccountStatus(BankAccount bankAccount, Connection connection) throws IllegalArgumentException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_STATUS);
            preparedStatement.setString(1, bankAccount.getMerchantId());
            preparedStatement.setString(2, bankAccount.getAccountNumber());
            int res = preparedStatement.executeUpdate();
            if (res == 0){
                throw new IllegalArgumentException("При поиске аккаунтов произошла неизвестная ошибка");
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("При поиске аккаунтов произошла неизвестная ошибка");
        }
    }

    public static List<BankAccount> getMerchantBankAccounts(String id, Connection connection) throws NoBankAccountsFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BANK_ACCOUNTS_QUERY);
            preparedStatement.setString(1,id);
            ResultSet set = preparedStatement.executeQuery();
            List<BankAccount> list = new ArrayList<>();
            while (set.next()) {
                StatusCondition status = (set.getString("status").equals("ACTIVE"))?
                        StatusCondition.ACTIVE: StatusCondition.DELETED;
                list.add(new BankAccount(set.getString("id"), set.getString("merchant_id"),
                        status, set.getString("account_number"),
                        set.getTimestamp("created_at").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            throw new NoBankAccountsFoundException("Таких аккаунтов не найдено, проверьте id мерчанта");
        }
    }

    public static void updateBankAccount(String newNumber, String merchant_id, String account_number,
                                         Connection connection) throws BankAccountNotFoundException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_NUMBER);
            preparedStatement.setString(1,newNumber);
            preparedStatement.setString(2,merchant_id);
            preparedStatement.setString(3,account_number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankAccountNotFoundException("Такой банковский аккаунт не найден");
        }
    }

    public static void deleteBankAccount(String merchantId, String accountNum, Connection connection) throws BankAccountNotFoundException {
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

    public static void createMerchant(Merchant merchant, Connection connection) {
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

    public static List<Merchant> getMerchants(Connection connection) {
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
        return null;
    }

    public static Merchant getMerchantById(String id, Connection connection) throws MerchantNotFoundException {
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

    public static void deleteMerchant(String id, Connection connection) throws MerchantNotFoundException {
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