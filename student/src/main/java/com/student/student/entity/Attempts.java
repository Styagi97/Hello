/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student.student.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author admin
 */

@Entity 
public class Attempts implements Serializable { 
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   
   private int id;
   private String username; 
   private int attempts;
    
   public int getId() { 
      return id; 
   }   
   public void setId(int id) {         
      this.id = id; 
   }   
   public String getUsername() { 
      return username; 
   } 
   public void setUsername(String username) { 
      this.username = username; 
   }  
   public int getAttempts() { 
      return attempts; 
   }  
   public void setAttempts(int attempts) { 
      this.attempts = attempts; 
   } 
}