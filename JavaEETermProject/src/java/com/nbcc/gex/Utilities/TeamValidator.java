/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.Utilities;

import com.nbcc.gex.dataaccess.EmployeeFactory;
import com.nbcc.gex.dataaccess.ISQLEmployee;
import com.nbcc.gex.formmodels.TeamFormModel;
import com.nbcc.gex.models.Employee;
import com.nbcc.gex.models.EmployeesModel;
import com.nbcc.gex.models.Team;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class TeamValidator {
    
    
    public static Team validateTeam(TeamFormModel teamForm, ArrayList<String> errors){
        
        Team team = new Team();
        errors.clear();
        
        String name = teamForm.getName();
        String isOnCallString = teamForm.getIsOnCall();
        String[] employeesStrings = teamForm.getEmployees();

        // Check team name not empty
        if ("".equals(name))
            errors.add("Name field must not be empty");
        else
            team.setName(name);

        // set booleans
        boolean isOnCall = "true".equals(isOnCallString);
        boolean isDeleted = false;

        team.setIsOnCall(isOnCall);
        team.setIsDeleted(isDeleted);

        // Check 2 team members chosen
        try {
             
            EmployeesModel members = new EmployeesModel();
            ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();

            for(String employee : employeesStrings){
                int employeeID = Integer.parseInt(employee);

                Employee tmp = employeeRepo.getEmployee(employeeID);
                members.add(tmp);
            }

            if (members.size() != 2)
                errors.add("Must select exactly 2 employees for team.");
            else
                team.setMembers(members);

        } catch (NullPointerException npe){
            errors.add("Must select 2 employees");
        }
       

        // Return team if valid. new team if not
        if (errors.size() > 0)
            return new Team();
        else
            return team;
    }
}
