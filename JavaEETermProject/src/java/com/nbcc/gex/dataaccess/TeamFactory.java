/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

/**
 *
 * @author Joe
 */
public class TeamFactory {
    
    public static ISQLTeam createTeam(){
        return new SQLTeam();
    }
}
