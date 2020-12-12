/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import com.nbcc.gex.models.Employee;
import com.nbcc.gex.models.EmployeesModel;
import com.nbcc.gex.models.Team;
import com.nbcc.gex.models.TeamsModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joe
 */
public class SQLTeam implements ISQLTeam{
    
    public TeamsModel getTeams(){

        TeamsModel teams = new TeamsModel();
        
        String sql = "{CALL spTeam_ListAllTeams()}";
        
        try (Connection conn = DataAccess.getConnection();){
            
            CallableStatement statement = conn.prepareCall(sql);
            
            ResultSet rs = DataAccess.getResultSet(statement);

            while (rs.next()){
                // Get record Variables
                int id = rs.getInt("TeamID");
                String name = rs.getString("TeamName");
                boolean isOnCall = rs.getBoolean("IsOnCallTeam");
                boolean isDeleted = rs.getBoolean("IsDeleted");
                
                ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
                EmployeesModel members = employeeRepo.getEmployeesOnTeam(id);
                
                // Create a task from those variables
                Team team = new Team(name, isOnCall, isDeleted, members);
                team.setTeamID(id);
                
                // Load task into list
                teams.add(team);
            }
        } catch (SQLException sqle){}

        return teams;
    }
    
    public Team getTeam(int teamID){
        
        Team team = new Team();
        
        String sql = "{CALL spTeam_GetTeam(?)}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);
            statement.setInt(1, teamID);

            ResultSet rs = DataAccess.getResultSet(statement);

            if (rs.next()) {

                // Get record Variables
                int id = rs.getInt("TeamID");
                String name = rs.getString("TaskName");
                boolean isOnCall = rs.getBoolean("IsOnCall");
                boolean isDeleted = rs.getBoolean("IsDeleted");
                
                ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
                EmployeesModel members = employeeRepo.getEmployeesOnTeam(id);
                
                // Create a task from those variables
                team = new Team(name, isOnCall, isDeleted, members);
                team.setTeamID(id);

            }
        } catch (SQLException sqle) {}
        
        return team;
    }
    
    public int addTeam(Team team){
        int rowCount = 0;
        
        String sqlTeam = "{CALL spTeam_AddTeam(?, ?, ?)}";
        String sqlEmployee = "{CALL spTeamEmployee_AddEmployeeToTeam(?, ?)}";
        
        try (Connection conn = DataAccess.getConnection()){
            
            // Create record in the Team table
            CallableStatement statementTeam = conn.prepareCall(sqlTeam);
            
            statementTeam.setString(1, team.getName());
            statementTeam.setBoolean(2, team.getIsOnCall());
            statementTeam.setBoolean(3, team.getIsDeleted());
            
            rowCount = DataAccess.update(statementTeam);
            
            // Add records in the Team_Employee table
            EmployeesModel members = team.getMembers();
            int teamID = getTeams().size(); // Not good.. relies on first team in db being id#1.. cant garuntee! (delete teams will wreck)
            
            for (Employee member : members.getEmployeesList()){
                CallableStatement statementEmployee = conn.prepareCall(sqlEmployee);
                statementEmployee.setInt(1, member.getEmployeeID());
                statementEmployee.setInt(2, teamID);
                
                DataAccess.update(statementEmployee);
            }
            
        } catch (SQLException sqle){}
        
        return rowCount;
    }
}
