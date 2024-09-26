/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.readexcel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
 
public class Root {
    private List<Sheet1> sheet1 = new ArrayList<>();

    public Root() {
    }
    
    public List<Sheet1> getSheet1() {
        return sheet1;
    }
    public void setSheet1(List<Sheet1> sheet1) {
        this.sheet1 = sheet1;
    }
} 