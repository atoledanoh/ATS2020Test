/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

/**
 *
 * @author Joe
 */
public class Team {

    private int teamID;
    private String name;
    private boolean isOnCall;
    private boolean isDeleted;
    private EmployeesModel members;
    
    public Team() {
        this("", false, false, null);
    }
    
    public Team(String name, boolean isOnCall, boolean isDeleted, EmployeesModel members) {
        this.name = name;
        this.isOnCall = isOnCall;
        this.isDeleted = isDeleted;
        this.members = members;
    }
    
    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsOnCall() {
        return isOnCall;
    }

    public void setIsOnCall(boolean isOnCall) {
        this.isOnCall = isOnCall;
    }
    
    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public EmployeesModel getMembers() {
        return members;
    }

    public void setMembers(EmployeesModel members) {
        this.members = members;
    }
        
}
