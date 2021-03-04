package com.airiline.tickets.repository;

import com.airiline.tickets.domain.ATSUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ATSUserRepository extends JpaRepository<ATSUser, Long> {
    Optional<ATSUser> findByUsername(String username);
}
