package com.example.hw3.Repository;

import com.example.hw3.Data.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    public ArrayList<User> users;

    public void userRepository() {
        users = new ArrayList<>();
        users.add(new User(0L,"Kate289", "Kate", "Ivanova", 24));
        users.add(new User(1L,"Star84", "Ivan", "Alexseev", 36));
    }
}
