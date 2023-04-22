package paymentsystem;

import java.time.LocalDateTime;

public class BankAccount {
    private String merchantId;
    private StatusCondition status;
    private String accountNumber;
    private LocalDateTime createdAt;

    public BankAccount(String merchantId, StatusCondition status, String accountNumber, LocalDateTime createdAt) {
        this.merchantId = merchantId;
        this.status = status;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
