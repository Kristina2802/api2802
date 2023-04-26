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

import java.util.ArrayList;
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
        String regexpString = ResponseService.likeToRegexp(request.likeString());
        ArrayList<String> login = new ArrayList<String>();
        for (User user : userRepository.users) {
            if (user.login().matches(regexpString)) {
                login.add(user.login());
            }
        }
        ResponseV1 response = new ResponseV1(login);
        return response;
    }

    public ResponseV2 getResponseV2(RequestV1 request) {
        String regexpString = ResponseService.likeToRegexp(request.likeString());
        ArrayList<String> login = new ArrayList<String>();
        for (User user : userRepository.users) {
            if (user.login().matches(regexpString)) {
                login.add(user.login());
            }
        }
        Long count = (long) userRepository.users.size();
        ResponseV2 response = new ResponseV2(login, count);
        return response;
    }

    public ResponseV3 getResponseV3(RequestV1 request) {
        String regexpString = ResponseService.likeToRegexp(request.likeString());
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<UserResponse> users = new ArrayList<UserResponse>();
        for (User user : userRepository.users) {
            if (user.login().matches(regexpString)) {
                login.add(user.login());
                UserResponse addUser = new UserResponse(user.login(), user.name(), user.surname());
                users.add(addUser);
            }
        }
        Long count = (long) userRepository.users.size();
        ResponseV3 response = new ResponseV3(login, count, users);
        return response;
    }

    public ResponseV3 getResponseV4(RequestV4 request) {
        String regexpString = ResponseService.likeToRegexp(request.likeString());
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<UserResponse> users = new ArrayList<UserResponse>();
        for (User user : userRepository.users) {
            if (user.login().matches(regexpString)) {
                login.add(user.login());
                UserResponse addUser = new UserResponse(user.login(), user.name(), user.surname());
                users.add(addUser);
            }
        }
        Long count = (long) userRepository.users.size();
        ResponseV3 response = new ResponseV3(login, count, users);
        return response;
    }

    public ResponseV3 getResponseV5(RequestV5 request) {
        String regexpString = ResponseService.likeToRegexp(request.likeString());
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<UserResponse> users = new ArrayList<UserResponse>();
        for (User user : userRepository.users) {
            if (user.login().matches(regexpString) && (request.surname() == null ||
                    Objects.equals(user.surname(), request.surname())) &&
                    (request.lowAge() == null || user.age() >= request.lowAge()) &&
                    (request.upAge() == null || user.age() <= request.upAge())) {
                login.add(user.login());
                UserResponse addUser = new UserResponse(user.login(), user.name(), user.surname());
                users.add(addUser);
            }
        }
        Long count = (long) userRepository.users.size();
        ResponseV3 response = new ResponseV3(login, count, users);
        return response;
    }
}
