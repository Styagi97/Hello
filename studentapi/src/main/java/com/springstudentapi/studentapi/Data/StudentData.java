/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springstudentapi.studentapi.Data;

import com.springstudentapi.studentapi.Entity.StudentDetails;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface StudentData extends JpaRepository<StudentDetails, Long> {
//select first_name, last_name from student u where u.id =id
//    @Query(value="select first_name, last_name from student u where u.id =id", nativeQuery=true)
//List<Object[]> getUserFullNameById(@Param("id") String id);

   
}

