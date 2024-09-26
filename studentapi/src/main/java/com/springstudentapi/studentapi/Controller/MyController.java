/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springstudentapi.studentapi.Controller;

import com.springstudentapi.studentapi.Data.StudentData;
import com.springstudentapi.studentapi.Entity.StudentDetails;
import com.springstudentapi.studentapi.Services.StudentDetailsImpl;
import com.springstudentapi.studentapi.Services.StudentServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
public class MyController {

    @Autowired
    private final StudentData studentdata;

    public MyController(StudentData studentdata) {

        this.studentdata = studentdata;
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome the Student Details";
    }

    @GetMapping("/StudentDetails")
    public List<StudentDetails> getStudentDetails() {
        System.out.println("StudentDetails is successfully accessed");
        return studentdata.findAll();

    }

    @GetMapping("/StudentDetails/{id}")
    public Optional<StudentDetails> getStudentDetails(@PathVariable Long id) {
        System.out.println("StudentDetails is successfully accessed through id");
        return studentdata.findById(id);

    }

//    @GetMapping("/StudentDetails/{id}")
//    public List<Object[]> getUserFullNameById(@PathVariable String id) {
//        return studentdata.getUserFullNameById(id);
//    }
    @PostMapping("/StudentDetails")
    public StudentDetails addStudent(@RequestBody StudentDetails StudentDetails) {
        System.out.println("New StudentDetails is successfully addedd");
        return studentdata.save(StudentDetails);

    }

    @PutMapping("/StudentDetails/{id}")
    public StudentDetails updateStudent(@RequestBody StudentDetails StudentDetails) {
        System.out.println("StudentDetails is successfully updated");
        return studentdata.save(StudentDetails);
    }

    @DeleteMapping("/StudentDetails/{id}")
    void deleteStudentDetails(@PathVariable Long id) {
        System.out.println("StudentDetails is successfully Deleted");
        studentdata.deleteById(id);
    }

}
