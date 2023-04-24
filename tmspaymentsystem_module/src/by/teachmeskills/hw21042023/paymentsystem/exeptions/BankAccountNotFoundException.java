package by.teachmeskills.hw21042023.paymentsystem.exeptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
