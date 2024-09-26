/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.services.UserServices.services;

import com.user.services.UserServices.Entity.User; 
import java.util.List; 
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
 
public interface UserServices {  

    //create user
    User saveUser(User user);

//get All user 
    List<User> getAllUser();

    //get user by id
    User getUserById(String id);
}
