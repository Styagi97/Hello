/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springstudentapi.studentapi.Entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "student")
public class StudentDetails implements Serializable {

    private @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
 
    private String FirstName;
    private String LastName;
    private String EmailID;
    private String Password;
    private String MobileNo;
    private String Pancard;
    private String DOB;
    private String address;
    private String PinCode;

    @Override
    public String toString() {
        return String.format(
                "StudentDetails{" + "id=" + this.id + ", FirstName='" + this.FirstName + '\'' + ", LastName='" + this.LastName
                + "EmailID=" + this.EmailID + ", Password='" + this.Password + '\'' + ", MobileNo='" + this.MobileNo
                + "Pancard=" + this.Pancard + ", DOB='" + this.DOB + '\'' + ", address='" + this.address + ", PinCode='"
                + this.PinCode + '\'' + '}');
        //   return super.toString(); 
    }

    public long getStudentId() {
        return id;
    }

    public void setStudentId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String EmailID) {
        this.EmailID = EmailID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public String getPancard() {
        return Pancard;
    }

    public void setPancard(String Pancard) {
        this.Pancard = Pancard;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String PinCode) {
        this.PinCode = PinCode;
    }

    public StudentDetails() {
    }

    public StudentDetails(String FirstName, String LastName, String EmailID, String Password, String MobileNo, String Pancard, String DOB, String address, String PinCode) {

        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailID = EmailID;
        this.Password = Password;
        this.MobileNo = MobileNo;
        this.Pancard = Pancard;
        this.DOB = DOB;
        this.address = address;
        this.PinCode = PinCode;
    }
}

