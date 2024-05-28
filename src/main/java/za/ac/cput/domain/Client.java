package za.ac.cput.domain;



import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Client {
    @Id
    private long IDNumber;
    @Embedded
    private Name name;

    @OneToOne(mappedBy = "client") // Assuming "client" is the property name in the Account entity
    private Account account;

    public Client() {}

    public Client(Builder builder) {
        this.IDNumber = builder.IDNumber;
    }

    public long getIDNumber() { return IDNumber; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Client client = (Client) object;
        return IDNumber == client.IDNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IDNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "IDNumber: " + IDNumber +
                '}';
    }

    public static class Builder {
        private long IDNumber;

        public Builder setIDNumber(long IDNumber) {
            this.IDNumber = IDNumber;
            return this;
        }

        public Builder copy(Client client) {
            this.IDNumber = client.IDNumber;
            return this;
        }

        public Client build() { return new Client(this); }
    }
}
