package com.shutterfly.interview.controllers;


import com.shutterfly.interview.exceptions.UserAlreadyExistException;
import com.shutterfly.interview.exceptions.UserNotFoundException;
import com.shutterfly.interview.models.User;
import com.shutterfly.interview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder1;


    @GetMapping("/users/{username}")
    public User retrieveUser(@PathVariable String username) {
        Optional<User> user =  userRepository.findById(username);
        if(user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException(username);

    }
    @PostMapping("/users/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        user.setPassWord(bCryptPasswordEncoder1.encode(user.getPassword()));
        List<User> users = userRepository.findAll();
        Stream<User> doesExist = users.stream().filter(s -> s.getUsername().equals(user.getUsername()));
        if(doesExist.count()>0)
            throw new UserAlreadyExistException(user.getUsername()+"already exists");
        else
            userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(user.getUsername()).toUri();
        return ResponseEntity.created(location).build();
    }


}