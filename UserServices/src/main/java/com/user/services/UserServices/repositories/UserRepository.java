/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.user.services.UserServices.repositories;

import com.user.services.UserServices.Entity.User;
import com.user.services.UserServices.services.UserServicesImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{

    public User save(UserServicesImpl aThis);
    
    
}
