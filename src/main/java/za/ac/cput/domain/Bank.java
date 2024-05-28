package za.ac.cput.domain;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Bank {
    @Id
    private long bankRegistrationNumber;
    private String bankName;

    public Bank() {}

    public Bank(Builder builder) {
        this.bankRegistrationNumber = builder.bankRegistrationNumber;
        this.bankName = builder.bankName;
    }

    public long getBankRegistrationNumber() { return bankRegistrationNumber; }
    public String getBankName() { return bankName; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bank bank = (Bank) object;
        return bankRegistrationNumber == bank.bankRegistrationNumber &&
                Objects.equals(bankName, bank.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankRegistrationNumber, bankName);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankRegistrationNumber: " + bankRegistrationNumber +
                ", bankName: '" + bankName + '\'' +
                '}';
    }

    public static class Builder {
        private long bankRegistrationNumber;
        private String bankName;

        public Builder setBankRegistrationNumber(long bankRegistrationNumber) {
            this.bankRegistrationNumber = bankRegistrationNumber;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder copy(Bank bank) {
            this.bankRegistrationNumber = bank.bankRegistrationNumber;
            this.bankName = bank.bankName;
            return this;
        }

        public Bank build() { return new Bank(this); }
    }
}
