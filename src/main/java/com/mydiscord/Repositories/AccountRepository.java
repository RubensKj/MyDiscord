package com.mydiscord.Repositories;

import com.mydiscord.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    boolean existsById(Long id);
}
