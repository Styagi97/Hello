/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.services.UserServices.controller;

import com.user.services.UserServices.Entity.User;
import com.user.services.UserServices.repositories.UserRepository;
import com.user.services.UserServices.services.UserServices; 
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/users")
public class MyController {
    
     @Autowired
    private UserRepository services;
    
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User u){
        
        User user1= services.save(u);
         return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    
     @GetMapping("/{userId}")
    public ResponseEntity.BodyBuilder getSingleUser(@PathVariable String userId){
        
         Optional<User> user1= services.findById(userId);
         return (ResponseEntity.BodyBuilder) ResponseEntity.ok(user1);
    }
         @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
         List<User> allUser = services.findAll();
         return ResponseEntity.ok(allUser);
    }
}
