/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springstudentapi.studentapi.Services;

import com.springstudentapi.studentapi.Entity.StudentDetails;
import java.util.List;

/**
 *
 * @author admin
 */
public interface StudentServices {

    public List<StudentDetails> getStudentDetails();

    public StudentDetails getStudentDetails(Long id);

    public StudentDetails addStudent(StudentDetails StudentDetails);

    public StudentDetails updateStudent(StudentDetails StudentDetails);

    void deleteStudentDetails(Long id);

}
