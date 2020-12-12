/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import com.nbcc.gex.models.Task;
import com.nbcc.gex.models.TasksModel;

/**
 *
 * @author Joe
 */
public interface ISQLTask {
    
    TasksModel getTasks();
    
    Task getTask(int taskID);
    
    int addTask(Task task);
    
    int deleteTask(int taskID);
}
