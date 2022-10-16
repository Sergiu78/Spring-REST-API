package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пльзователь уже существует");
        }
        return userRepo.save(user);
    }
}
