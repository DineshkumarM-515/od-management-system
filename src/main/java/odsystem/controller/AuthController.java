package odsystem.controller;

import odsystem.entity.User;
import odsystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public User login(
            @RequestParam String email,
            @RequestParam String password) {

        return service.login(email, password);
    }
}