/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import com.nbcc.gex.models.Task;
import com.nbcc.gex.models.TasksModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joe
 */
public class SQLTask implements ISQLTask{
    
    
    @Override
    public TasksModel getTasks(){
        TasksModel tasks = new TasksModel();
        
        String sql = "{CALL spTask_ListAllTasks()}";
        
        try (Connection conn = DataAccess.getConnection();){
            
            CallableStatement statement = conn.prepareCall(sql);
            
            ResultSet rs = DataAccess.getResultSet(statement);

            while (rs.next()){

                // Get record Variables
                int id = rs.getInt("TaskID");
                String name = rs.getString("TaskName");
                String description = rs.getString("Description");
                int completionTime = rs.getInt("TimeToComplete");
                
                // Create a task from those variables
                Task task = new Task(name, description, completionTime);
                task.setTaskID(id);
                
                // Load task into list
                tasks.add(task);
            }
        } catch (SQLException sqle){}

        return tasks;
    }
    
    @Override
    public Task getTask(int taskID){
        
        Task task = new Task();
        
        String sql = "{CALL spTask_GetTask(?)}";

        try (Connection conn = DataAccess.getConnection();) {

            CallableStatement statement = conn.prepareCall(sql);
            statement.setInt(1, taskID);

            ResultSet rs = DataAccess.getResultSet(statement);

            if (rs.next()) {

                // Get record Variables
                int id = rs.getInt("TaskID");
                String name = rs.getString("TaskName");
                String description = rs.getString("Description");
                int completionTime = rs.getInt("TimeToComplete");
                
                // Create a task from those variables
                task = new Task(name, description, completionTime);
                task.setTaskID(id);

            }
        } catch (SQLException sqle) {}
        
        return task;
    }
    
    @Override
    public int addTask(Task task){
        int rowCount = 0;
        
        String sql = "{CALL spTask_AddTask(?, ?, ?)}";
        
        try (Connection conn = DataAccess.getConnection();){
            CallableStatement statement = conn.prepareCall(sql);
            
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getDuration());
            
            rowCount = DataAccess.update(statement);
            
        } catch (SQLException sqle){}
        
        return rowCount;
    }
    
    @Override
    public int deleteTask(int taskID){
        int rowCount = 0;
        
        String sql = "{CALL spTask_DeleteTask(?)}";
        
        try (Connection conn = DataAccess.getConnection();){
            CallableStatement statement = conn.prepareCall(sql);
            
            statement.setInt(1, taskID);
            
            rowCount = DataAccess.update(statement);
            
        } catch (SQLException sqle){}
        
        return rowCount;
    }
}
