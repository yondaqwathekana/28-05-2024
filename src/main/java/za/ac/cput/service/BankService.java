package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bank;
import za.ac.cput.repository.BankRepository;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.HashSet;

@Service
public class BankService implements IService<Bank, Long> {

    private final BankRepository repository;

    @Autowired
    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bank create(Bank bank) {
        return repository.save(bank);
    }

    @Override
    public Bank read(Long bankRegistrationNumber) {
        return repository.findById(String.valueOf(bankRegistrationNumber))
                .orElseThrow(() -> new NoSuchElementException("Bank with registration number " + bankRegistrationNumber + " does not exist"));
    }

    @Override
    public Bank update(Bank bank) {
        return repository.save(bank);
    }

    @Override
    public Bank delete(Long bankRegistrationNumber) {
        Bank bankToDelete = read(bankRegistrationNumber);
        repository.delete(bankToDelete);
        return bankToDelete;
    }

    @Override
    public Set<Bank> getAll() {
        return new HashSet<>(repository.findAll());
    }
}
