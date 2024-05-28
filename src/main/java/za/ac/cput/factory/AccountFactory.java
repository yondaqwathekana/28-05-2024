package za.ac.cput.factory;

import za.ac.cput.domain.Account;
import java.time.LocalDateTime;
public class AccountFactory {

    public static Account createAccount(long accountNumber, String accountName, LocalDateTime dateOpened) {
        return new Account.Builder()
                .setAccountNumber(accountNumber)
                .setAccountName(accountName)
                .setDateOpened(dateOpened)
                .build();
    }
}
