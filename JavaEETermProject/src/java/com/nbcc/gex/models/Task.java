/*
 * Author:      Joseph Roy-Plommer
 * Date:        2020-11-05
 * File:        Task.java
 * Description: Represents a workers task and acts as a model in MVC.
 */
package com.nbcc.gex.models;

/**
 *
 * @author Joseph Roy-Plommer
 */
public class Task {
    
    private int taskID;
    private String name;
    private String description;
    private int duration; // Duration in minutes (min 30)
    
    public Task() {
        this("", "", 0);
    }
    
    public Task(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
    
    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public boolean isValidTask(){
        return !"".equals(name) && !"".equals(description);
    }
}
