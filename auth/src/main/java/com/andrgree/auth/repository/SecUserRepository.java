package com.andrgree.auth.repository;

import com.andrgree.auth.model.SecUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecUserRepository extends JpaRepository<SecUser, Long> {

    Optional<SecUser> findByUsername(final String username);
}
