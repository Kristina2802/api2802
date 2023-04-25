package com.example.hw3.Service;

import com.example.hw3.Data.User;
import com.example.hw3.Data.UserResponse;
import com.example.hw3.Repository.UserRepository;
import com.example.hw3.Requests.RequestV1;
import com.example.hw3.Requests.RequestV4;
import com.example.hw3.Requests.RequestV5;
import com.example.hw3.Resposnses.ResponseV1;
import com.example.hw3.Resposnses.ResponseV2;
import com.example.hw3.Resposnses.ResponseV3;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ResponseService {

    UserRepository userRepository;
    public static String likeToRegexp(String expression) {
        expression = expression.toLowerCase();
        expression = expression.replace(".", "\\.");
        expression = expression.replace("?", ".");
        expression = expression.replace("%", ".*");
        return expression;
    }

    public ResponseV1 getResponseV1(RequestV1 request) {
        String regexpString = ResponseService.likeToRegexp(request.getLikeString());
        ResponseV1 response = new ResponseV1();
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexpString)) {
                response.getLogin().add(user.getLogin());
            }
        }
        return response;
    }

    public ResponseV2 getResponseV2(RequestV1 request) {
        String regexpString = ResponseService.likeToRegexp(request.getLikeString());
        ResponseV2 response = new ResponseV2();
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexpString)) {
                response.getLogin().add(user.getLogin());
            }
        }
        response.setCount((long) userRepository.users.size());
        return response;
    }

    public ResponseV3 getResponseV3(RequestV1 request) {
        String regexpString = ResponseService.likeToRegexp(request.getLikeString());
        ResponseV3 response = new ResponseV3();
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexpString)) {
                response.getLogin().add(user.getLogin());
                UserResponse addUser = new UserResponse(user.getLogin(), user.getName(), user.getSurname());
                response.getUsers().add(addUser);
            }
        }
        response.setCount((long) userRepository.users.size());
        return response;
    }

    public ResponseV3 getResponseV4(RequestV4 request) {
        String regexpString = ResponseService.likeToRegexp(request.getLikeString());
        ResponseV3 response = new ResponseV3();
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexpString)) {
                response.getLogin().add(user.getLogin());
                UserResponse addUser = new UserResponse(user.getLogin(), user.getName(), user.getSurname());
                response.getUsers().add(addUser);
            }
        }
        response.setCount((long) userRepository.users.size());
        return response;
    }

    public ResponseV3 getResponseV5(RequestV5 request) {
        String regexpString = ResponseService.likeToRegexp(request.getLikeString());
        ResponseV3 response = new ResponseV3();
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexpString) && (request.getSurname() == null ||
                    Objects.equals(user.getSurname(), request.getSurname())) &&
                    (request.getLowAge() == null || user.getAge() >= request.getLowAge()) &&
                    (request.getUpAge() == null || user.getAge() <= request.getUpAge())) {
                response.getLogin().add(user.getLogin());
                UserResponse addUser = new UserResponse(user.getLogin(), user.getName(), user.getSurname());
                response.getUsers().add(addUser);
            }
        }
        response.setCount((long) userRepository.users.size());
        return response;
    }
}
