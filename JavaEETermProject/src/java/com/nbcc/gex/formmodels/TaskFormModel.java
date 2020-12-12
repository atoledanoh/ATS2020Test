/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.formmodels;

/**
 *
 * @author Joe
 */
public class TaskFormModel {
    
    private String name;
    private String description;
    private String duration;
    
    public TaskFormModel(){
        this("", "", "");
    }
    
    public TaskFormModel(String name, String description, String duration){
        this.name = name;
        this.description = description;
        this.duration = duration;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
}
