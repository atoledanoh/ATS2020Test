/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class TeamsModel {

    private ArrayList<Team> teams;
    
    public TeamsModel(){
        teams = new ArrayList<>();
    }
    
    public void add(Team team){
        teams.add(team);
    }
    
    public ArrayList<Team> getTeamsList() {
        return teams;
    }
    
    public Team getTeam(int teamID){
        for (Team team : teams){
            if (team.getTeamID() == teamID){
                return team;
            }
        }
        return null;
    }
    
    public int size(){
        return teams.size();
    }
    
    public boolean isEmpty(){
        return teams.isEmpty();
    }
    
}
