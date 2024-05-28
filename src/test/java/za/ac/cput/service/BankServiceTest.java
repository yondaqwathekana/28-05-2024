package za.ac.cput.service;

import za.ac.cput.domain.Bank;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BankServiceTest {

    @Autowired
    private BankService bankService;

    @Test
    @Order(1)
    void createBank() {
        // Create a new bank
        Bank bank = new Bank.Builder()
                .setBankRegistrationNumber(123456789)
                .setBankName("Capitec Bank")
                .build();

        // Save the bank to the database
        Bank createdBank = bankService.create(bank);
        assertNotNull(createdBank);
        assertEquals(bank.getBankRegistrationNumber(), createdBank.getBankRegistrationNumber());
        assertEquals(bank.getBankName(), createdBank.getBankName());
    }

    @Test
    @Order(2)
    void readBank() {
        // Read the bank from the database using its registration number
        Bank foundBank = bankService.read(123456789L);
        assertNotNull(foundBank);
        assertEquals(123456789, foundBank.getBankRegistrationNumber());
        assertEquals("Test Bank", foundBank.getBankName());
    }

    @Test
    @Order(3)
    void updateBank() {
        // Read the bank from the database
        Bank foundBank = bankService.read(123456789L);
        assertNotNull(foundBank);

        // Update the bank's name


        // Save the updated bank to the database
        Bank updatedBank = bankService.update(foundBank);
        assertNotNull(updatedBank);
        assertEquals("Updated Bank Name", updatedBank.getBankName());
    }

    @Test
    @Order(4)
    void deleteBank() {
        // Delete the bank from the database
        Bank deletedBank = bankService.delete(Long.valueOf(123456789));
        assertNotNull(deletedBank);
        assertEquals(123456789, deletedBank.getBankRegistrationNumber());

        // Ensure the bank is no longer in the database
        assertThrows(Exception.class, () -> bankService.read(123456789L));
    }

    @Test
    @Order(5)
    void getAllBanks() {
        // Retrieve all banks from the database
        Set<Bank> allBanks = bankService.getAll();
        assertNotNull(allBanks);
        assertTrue(allBanks.size() > 0);
    }
}
