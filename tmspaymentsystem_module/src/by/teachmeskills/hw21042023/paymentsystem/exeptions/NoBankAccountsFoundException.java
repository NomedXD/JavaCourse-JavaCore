package by.teachmeskills.hw21042023.paymentsystem.exeptions;

public class NoBankAccountsFoundException extends Exception{
    public NoBankAccountsFoundException(String message){
        super(message);
    }
}
