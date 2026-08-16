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

        System.out.println("=================================");
        System.out.println("Email entered: " + email);
        System.out.println("Password entered: " + password);
    
        User user = repository.findByEmail(email);
    
        if (user == null) {
            System.out.println("User NOT FOUND");
            return null;
        }
    
        System.out.println("Database Email: " + user.getEmail());
        System.out.println("Database Password: " + user.getPassword());
    
        if (user.getPassword().equals(password)) {
            System.out.println("LOGIN SUCCESS");
            return user;
        }
    
        System.out.println("PASSWORD MISMATCH");
        return null;
    }
}