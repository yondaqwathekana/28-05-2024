package za.ac.cput.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.ac.cput.domain.Bank;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {
}