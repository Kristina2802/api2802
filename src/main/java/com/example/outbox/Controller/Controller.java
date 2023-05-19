package com.example.outbox.Controller;

import com.example.outbox.Configuration.BrokerConfig;
import com.example.outbox.DTOs.Outbox;
import com.example.outbox.DTOs.User;
import com.example.outbox.Reposiroties.OutboxRepository;
import com.example.outbox.Reposiroties.UserRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@EnableScheduling
public class Controller {
    public final UserRepository userRepository;
    public final OutboxRepository outboxRepository;
    public final RabbitTemplate rabbitTemplate;

    @Autowired
    public Controller(UserRepository userRepository, OutboxRepository outboxRepository, RabbitTemplate rabbitTemplate) {
        this.outboxRepository = outboxRepository;
        this.userRepository = userRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 4000)
    @Transactional
    public void outbox() {
        List<Outbox> outboxList =  outboxRepository.findAll();
        for (Outbox outbox : outboxList) {
            rabbitTemplate.convertAndSend(BrokerConfig.QUEUE_NAME1, outbox);
        }
        outboxRepository.deleteAll(outboxList);
    }

    @PostMapping("/registerUser")
    @Transactional
    public boolean registerUser(@RequestBody User user) {
        if (user.login == null || user.password == null) {
            return false;
        }
        userRepository.save(user);
        outboxRepository.save(new Outbox(user.login));
        return true;
    }

    @GetMapping("/getUser")
    @Nullable
    public User getUser(String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user.orElse(null);
    }
}
