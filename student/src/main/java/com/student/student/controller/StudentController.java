/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
public class StudentController {
    @RequestMapping({"/hellouser"})
	public String helloUser(){
		return "Hello User";
	}
	
	@RequestMapping({"/helloadmin"})
	public String helloAdmin(){
		return "Hello Admin";
	}

}
