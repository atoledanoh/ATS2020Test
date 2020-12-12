/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.formmodels;

/**
 *
 * @author Joe
 */
public class EmployeeFormModel {

    private String firstName;
    private String lastName;
    private String SIN;
    private String payRate;
    
    public EmployeeFormModel(){
        this("", "", "", "");
    }
    
    public EmployeeFormModel(String firstName, String lastName, String SIN, String payRate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.SIN = SIN;
        this.payRate = payRate;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }
    
}
