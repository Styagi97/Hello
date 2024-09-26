/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.student.student.Repository;

import com.student.student.entity.Attempts;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Long>{
    Optional<Attempts> findAttemptsByUsername(String username); 
    
}
