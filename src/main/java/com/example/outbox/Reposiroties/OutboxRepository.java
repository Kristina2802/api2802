package com.example.outbox.Reposiroties;

import com.example.outbox.DTOs.Outbox;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name="jakarta.persistence.lock.timeout", value = "SKIP_LOCKED" + "")})
    List<Outbox> findAll();
}
