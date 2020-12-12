/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

import com.nbcc.gex.formmodels.TaskFormModel;
import javax.servlet.http.HttpServletRequest;
import com.nbcc.gex.viewmodel.TasksViewModel;

/**
 * @author Joseph Roy-Plommer
 * 
 * Created on : 30-Oct-2020, 9:34:34 AM
 */
public class TaskRequestUtil {
    
    private static final String TASKS_MODEL_VALUE = "TasksModel";
    
    public static void setTasksModel(HttpServletRequest request, TasksViewModel model) {
        request.setAttribute(TASKS_MODEL_VALUE, model);
    }
    
    public static TasksViewModel getTasksModel(HttpServletRequest request){
        Object tasksModel = request.getAttribute(TASKS_MODEL_VALUE);
        
        if (tasksModel != null){
            return (TasksViewModel)tasksModel;
        }
        
        return new TasksViewModel();
    }
    
    public static TaskFormModel extractTaskFormModelFromRequest(HttpServletRequest request){
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String duration = request.getParameter("duration");
        
        TaskFormModel extractedTask = new TaskFormModel(name, description, duration);

        return extractedTask;
    }
    
}
