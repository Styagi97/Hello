/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.services.UserServices.exceptions;

/**
 *
 * @author admin
 */
public class ResourcesNotFoundException  extends RuntimeException{
    

    public ResourcesNotFoundException() {
        super("Resources Not Found on server !!"); 
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }
    
    
}
