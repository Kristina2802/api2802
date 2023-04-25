package com.example.hw3.Repository;

import com.example.hw3.Data.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    public ArrayList<User> users;

    public void userRepository() {
        users = new ArrayList<>();
        users.add(new User(0L,"Kate2288", "Kate", "Petrova", 25));
        users.add(new User(1L,"Star2465", "Ivan", "Ivanov", 12));
        users.add(new User(2L,"Masha", "Maria", "Ustinova", 20));
    }
}
