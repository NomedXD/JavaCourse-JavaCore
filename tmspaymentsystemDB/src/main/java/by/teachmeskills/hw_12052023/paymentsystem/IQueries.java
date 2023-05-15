package by.teachmeskills.hw_12052023.paymentsystem;

public interface IQueries {
    String GET_MERCHANTS_QUERY = "SELECT * FROM merchant";
    String INSERT_MERCHANT_QUERY = "INSERT INTO merchant (id, name, created_at) Values (?, ?, ?)";
    String SELECT_MERCHANT_BY_ID_QUERY = "SELECT * FROM merchant WHERE id = ?";
    String DELETE_MERCHANT_BY_ID_QUERY = "DELETE FROM merchant WHERE id = ?";
    String COUNT_DUPLICATE_BANK_ACCOUNT = "SELECT * FROM bank_account WHERE account_number = ? AND merchant_id = ?";
    String INSERT_BANK_ACCOUNT_QUERY = "INSERT INTO bank_account (id, merchant_id, status, account_number, " +
            "created_at) Values (?, ?, ?, ?, ?)";
    // Update и delete можно заменить на один запрос и поставить вайлдкарт символ
    String UPDATE_ACCOUNT_STATUS = "UPDATE bank_account SET status = ACTIVE WHERE merchant_id = ? AND account_number = ?";
    String GET_BANK_ACCOUNTS_QUERY = "SELECT * FROM bank_account WHERE merchant_id = ? ORDER BY status, created_at";
    String DELETE_BANK_ACCOUNT_QUERY = "UPDATE bank_account SET status = DELETE WHERE merchant_id = ? AND account_number = ?";
    String UPDATE_ACCOUNT_NUMBER = "UPDATE bank_account SET account_number = ? WHERE merchant_id = ? AND account_number = ?";

}
