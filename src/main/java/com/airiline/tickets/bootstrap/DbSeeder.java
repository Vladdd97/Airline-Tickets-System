package com.airiline.tickets.bootstrap;

import com.airiline.tickets.domain.ATSUser;
import com.airiline.tickets.domain.common.UserRole;
import com.airiline.tickets.repository.ATSUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// TODO remove when migration will be added
@Slf4j
@Component
@RequiredArgsConstructor
public class DbSeeder implements CommandLineRunner {

    private final ATSUserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.findByUsername("admin")
                .ifPresentOrElse(u -> log.info("admin user [{}] is already present in DB", u.getUsername()),
                        () -> userRepository.save(getAdminUser()));
    }

    private ATSUser getAdminUser() {
        return ATSUser.builder()
                .username("admin")
                .password("$2a$10$7XFFaC8ovG41LvxpLkCniuEk.myYOxDyCroN4CcwRMybrJdKPGMFK")
                .email("test-admin@gmail.com")
                .enabled(true)
                .role(UserRole.ROLE_ADMIN)
                .build();
    }
}
