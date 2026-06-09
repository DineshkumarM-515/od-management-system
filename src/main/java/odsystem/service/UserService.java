package odsystem.service;

import odsystem.entity.User;
import odsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User login(String email, String password) {

        User user = repository.findByEmail(email);

        if(user != null &&
           user.getPassword().equals(password)) {

            return user;
        }

        return null;
    }
}