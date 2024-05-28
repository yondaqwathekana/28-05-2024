package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Account {
    @Id
    private long accountNumber;
    private String accountName;
    private LocalDateTime dateOpened;
    @OneToOne
    @JoinColumn(name = "IDNumber")

    private Client client;
    public Account() {

    }

    private Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountName = builder.accountName;
        this.dateOpened = builder.dateOpened;
    }

    // Getters
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber &&
                Objects.equals(accountName, account.accountName) &&
                Objects.equals(dateOpened, account.dateOpened);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountName, dateOpened);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", dateOpened=" + dateOpened +
                '}';
    }

    public static class Builder {
        private long accountNumber;
        private String accountName;
        private LocalDateTime dateOpened;

        public Builder setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder setDateOpened(LocalDateTime dateOpened) {
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder copy(Account account) {
            this.accountNumber = account.accountNumber;
            this.accountName = account.accountName;
            this.dateOpened = account.dateOpened;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
