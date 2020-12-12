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
public class TasksModel {
    
    private ArrayList<Task> tasks;

    public TasksModel(){
        tasks = new ArrayList<>();
    }
    
    public void add(Task task){
        tasks.add(task);
    }
    
    public ArrayList<Task> getTasksList(){
        return tasks;
    }
    
    public Task getTask(int taskID){
        for (Task task : tasks){
            if (task.getTaskID() == taskID){
                return task;
            }
        }
        return null;
    }
    
    public int size(){
        return tasks.size();
    }
    
    public boolean isEmpty(){
        return tasks.isEmpty();
    }
    
}
