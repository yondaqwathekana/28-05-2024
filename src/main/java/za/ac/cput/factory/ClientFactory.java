package za.ac.cput.factory;


import za.ac.cput.domain.Client;

public class ClientFactory {

    public static Client createClient(long IDNumber) {
        return new Client.Builder()
                .setIDNumber(IDNumber)
                .build();
    }
}
