package com.example.outbox.Reposiroties;

import com.example.outbox.DTOs.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}