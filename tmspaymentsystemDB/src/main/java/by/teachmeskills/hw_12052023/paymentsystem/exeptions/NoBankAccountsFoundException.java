package by.teachmeskills.hw_12052023.paymentsystem.exeptions;

public class NoBankAccountsFoundException extends Exception{
    public NoBankAccountsFoundException(String message){
        super(message);
    }
}
