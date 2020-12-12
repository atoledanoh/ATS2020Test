/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

import com.nbcc.gex.dataaccess.EmployeeFactory;
import com.nbcc.gex.dataaccess.ISQLEmployee;
import com.nbcc.gex.formmodels.TeamFormModel;
import com.nbcc.gex.viewmodel.TeamsViewModel;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Joe
 */
public class TeamRequestUtil {
    private static final String TEAMS_MODEL_VALUE = "TeamsModel";
    
    public static void setTeamsModel(HttpServletRequest request, TeamsViewModel model) {
        request.setAttribute(TEAMS_MODEL_VALUE, model);
    }
    
    public static TeamsViewModel getTeamsModel(HttpServletRequest request){
        Object teamsModel = request.getAttribute(TEAMS_MODEL_VALUE);
        
        if (teamsModel != null){
            return (TeamsViewModel)teamsModel;
        }
        
        return new TeamsViewModel();
    }
    
    public static TeamFormModel extractTeamFormModelFromRequest(HttpServletRequest request){
        
        String name = request.getParameter("name");
        String isOnCall = request.getParameter("isOnCall");
        String[] employees = request.getParameterValues("employees"); // Array of checked employeeID's

        TeamFormModel extractedTeam = new TeamFormModel(name, isOnCall, employees);

        return extractedTeam;
    }
}
