/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

import java.util.ArrayList;

/**
 *
 * @author AlejandroT
 */
public class EmployeesModel {

    private ArrayList<Employee> employees;

    public EmployeesModel() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployeesList() {
        return employees;
    }

    public Employee getEmployee(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    public int size() {
        return employees.size();
    }

    public boolean isEmpty() {
        return employees.isEmpty();
    }
}
