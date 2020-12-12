/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

/**
 *
 * @author AlejandroT
 */
public class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private int SIN; //canadian format
    private float payRate;

    public Employee() {
        setFirstName("");
        setLastName("");
        setSIN(0);
        setPayRate(0);
    }

    public Employee(String firstName, String lastName, int SIN, float payRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SIN = SIN;
        this.payRate = payRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

}
