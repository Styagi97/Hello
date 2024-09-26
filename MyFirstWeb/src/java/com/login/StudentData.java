/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class StudentData {
  
    String id;
    String FirstName;
    String LastName;
    String EmailID;
    String Password;
    String MobileNo;
    String PanCard;
    String DOB;
    String address;
    String PinCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPanCard() {
        return PanCard;
    }

    public void setPanCard(String PanCard) {
        this.PanCard = PanCard;
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

    public StudentData() {
    }

    public StudentData(String id, String FirstName, String LastName, String EmailID, String Password, String MobileNo, String PanCard, String DOB, String address, String PinCode) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmailID = EmailID;
        this.Password = Password;
        this.MobileNo = MobileNo;
        this.PanCard = PanCard;
        this.DOB = DOB;
        this.address = address;
        this.PinCode = PinCode;
    }

    @Override
    public String toString() {
        return "StudentData{" + "id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", EmailID=" + EmailID + ", Password=" + Password + ", MobileNo=" + MobileNo + ", PanCard=" + PanCard + ", DOB=" + DOB + ", address=" + address + ", PinCode=" + PinCode + '}';
    }

}
