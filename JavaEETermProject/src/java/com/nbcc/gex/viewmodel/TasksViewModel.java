/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.viewmodel;

import com.nbcc.gex.models.Task;
import com.nbcc.gex.viewmodel.Utility.UIState;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class TasksViewModel {
    
    private ArrayList<Task> tasks;
    private UIState state;
    private ArrayList<String> errors;
    private Task selectedTask;        // TaskID
    
    public TasksViewModel(){
        tasks = new ArrayList<>();
        state = UIState.LIST;
        errors = new ArrayList<>();
        selectedTask = null;
    }
    
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    
    public void setTasks(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public UIState getState() {
        return state;
    }

    public void setState(UIState state) {
        this.state = state;
    }
    
    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
    
}
