package za.ac.cput.factory;

import za.ac.cput.domain.Bank;

public class BankFactory {

    public static Bank createBank(long bankRegistrationNumber, String bankName) {
        return new Bank.Builder()
                .setBankRegistrationNumber(bankRegistrationNumber)
                .setBankName(bankName)
                .build();
    }
}
