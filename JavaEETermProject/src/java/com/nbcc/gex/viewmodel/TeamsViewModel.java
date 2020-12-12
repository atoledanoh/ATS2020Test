/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.viewmodel;

import com.nbcc.gex.models.EmployeesModel;
import com.nbcc.gex.models.Team;
import com.nbcc.gex.viewmodel.Utility.UIState;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class TeamsViewModel {
    
    private ArrayList<Team> teams;
    private UIState state;
    private ArrayList<String> errors;
    private Team selectedTeam;
    private EmployeesModel availableEmployees;
    
    public TeamsViewModel(){
        teams = new ArrayList<>();
        state = UIState.LIST;
        errors = new ArrayList<>();
        selectedTeam = null;
    }
    
    public ArrayList<Team> getTeams(){
        return teams;
    }
    
    public void setTeams(ArrayList<Team> teams){
        this.teams = teams;
    }
    
    public UIState getState() {
        return state;
    }

    public void setState(UIState state) {
        this.state = state;
    }
    
    public Team getSelectedTeam() {
        return selectedTeam;
    }

    public void setSelectedTeam(Team selectedTeam) {
        this.selectedTeam = selectedTeam;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
    
    public EmployeesModel getAvailableEmployees() {
        return availableEmployees;
    }

    public void setAvailableEmployees(EmployeesModel availableEmployees) {
        this.availableEmployees = availableEmployees;
    }
}
