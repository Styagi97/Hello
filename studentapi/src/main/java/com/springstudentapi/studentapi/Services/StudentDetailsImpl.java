/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springstudentapi.studentapi.Services;

import com.springstudentapi.studentapi.Data.StudentData;
import com.springstudentapi.studentapi.Entity.StudentDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class StudentDetailsImpl implements StudentServices {

    @Autowired
    private StudentData studentdata;

    @Override
    public List<StudentDetails> getStudentDetails() {
        return studentdata.findAll();
    }

    @Override
    public StudentDetails getStudentDetails(Long id) {
        return studentdata.getReferenceById(id);
        
    }
    

    @Override
    public StudentDetails addStudent(StudentDetails StudentDetails) {
       return studentdata.save(StudentDetails);
       
         
    }

    @Override
    public StudentDetails updateStudent(StudentDetails StudentDetails) {
        return  studentdata.save(StudentDetails);
      
    }

    @Override
    public void deleteStudentDetails(Long id) {
        StudentDetails Entity = studentdata.getReferenceById(id);
        studentdata.delete(Entity);
    }

 
}
