package by.teachmeskills.hw_12052023.paymentsystem;

import java.time.LocalDateTime;

public class BankAccount {
    private String id;
    private String merchantId;
    private StatusCondition status;
    private String accountNumber;
    private LocalDateTime createdAt;

    public BankAccount(String id, String merchantId, StatusCondition status, String accountNumber, LocalDateTime createdAt) {
        this.id = id;
        this.merchantId = merchantId;
        this.status = status;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public StatusCondition getStatus() {
        return status;
    }

    public void setStatus(StatusCondition status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
