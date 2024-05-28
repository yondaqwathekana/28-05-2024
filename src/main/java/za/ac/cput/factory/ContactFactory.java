package za.ac.cput.factory;

import za.ac.cput.domain.Contact;

public class ContactFactory {

    public static Contact createContact(String emailAddress, String phoneNumber) {
        return new Contact.Builder()
                .setEmailAddress(emailAddress)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
