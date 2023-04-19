package paymentsystem.exeptions;

import paymentsystem.MerchantService;

public class MerchantNotFoundException extends Exception {
    public MerchantNotFoundException(String message) {
        super(message);
    }
}
