/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.services.UserServices.services;

import com.user.services.UserServices.Entity.User;
import com.user.services.UserServices.exceptions.ResourcesNotFoundException;
import com.user.services.UserServices.repositories.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String ramdomUserId = UUID.randomUUID().toString();
        user.setUserId(ramdomUserId);
        return userRepository.save(user);
    }
 

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("user given id is not found on server!!"+ id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

}
