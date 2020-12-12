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
public class TeamFormModel {
    
    private String name;
    private String isOnCall;
    private String[] employees;
    
    public TeamFormModel(){
        this("", "", null);
    }
    
    public TeamFormModel(String name, String isOnCall, String[] employees){
        this.name = name;
        this.isOnCall = isOnCall;
        this.employees = employees;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOnCall() {
        return isOnCall;
    }

    public void setIsOnCall(String isOnCall) {
        this.isOnCall = isOnCall;
    }

    public String[] getEmployees() {
        return employees;
    }

    public void setEmployees(String[] employees) {
        this.employees = employees;
    }
    
}
