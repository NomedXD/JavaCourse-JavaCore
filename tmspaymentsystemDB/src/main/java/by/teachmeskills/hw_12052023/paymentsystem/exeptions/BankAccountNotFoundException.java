package by.teachmeskills.hw_12052023.paymentsystem.exeptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
