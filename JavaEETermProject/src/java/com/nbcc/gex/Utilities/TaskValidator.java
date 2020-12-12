/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.Utilities;

import com.nbcc.gex.formmodels.TaskFormModel;
import com.nbcc.gex.models.Task;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class TaskValidator {
    // functions for validating Task input parameters and bussiness rules.
    //When these fail, error strings can be added to the TasksModel.
    
    public static Task validateTask(TaskFormModel taskForm, ArrayList<String> errors){
        
        Task task = new Task();
        errors.clear();
        
        String name = taskForm.getName();
        String description = taskForm.getDescription();
        String duration = taskForm.getDuration();
        
        try {
            // Check task name not empty
            if ("".equals(name))
                errors.add("Name field must not be empty");
            else
                task.setName(name);
            
            // Check duration not empty
            if ("".equals(duration))
                errors.add("duration field must not be empty");
            
            //check duration is a number
            int dur = Integer.parseInt(taskForm.getDuration());
            
            // check duration is not less than 30 minutes
            if (dur < 30)
                errors.add("duration must be 30 minutes or more");
            else
            {
                task.setDescription(description);
                task.setDuration(dur);
            }
        
        } catch (NumberFormatException nfe){
            errors.add("Duration must be a number");
        }
        
        if (errors.size() > 0)
            return new Task();
        else
            return task;
    }
}
