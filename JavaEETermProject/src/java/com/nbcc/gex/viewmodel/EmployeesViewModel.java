/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.viewmodel;

import com.nbcc.gex.models.Employee;
import com.nbcc.gex.viewmodel.Utility.UIState;
import java.util.ArrayList;

/**
 *
 * @author Joe
 */
public class EmployeesViewModel {
    
    private ArrayList<Employee> employees;
    private UIState state;
    private ArrayList<String> errors;
    private Employee selectedEmployee;
    
    public EmployeesViewModel(){
        employees = new ArrayList<>();
        state = UIState.LIST;
        errors = new ArrayList<>();
        selectedEmployee = null;
    }
    
    public ArrayList<Employee> getEmployees(){
        return employees;
    }
    
    public void setEmployees(ArrayList<Employee> employees){
        this.employees = employees;
    }
    
    public UIState getState() {
        return state;
    }

    public void setState(UIState state) {
        this.state = state;
    }
    
    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
}
