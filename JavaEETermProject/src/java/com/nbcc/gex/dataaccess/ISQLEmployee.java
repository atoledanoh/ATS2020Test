/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.dataaccess;

import com.nbcc.gex.models.Employee;
import com.nbcc.gex.models.EmployeesModel;

/**
 *
 * @author AlejandroT
 */
public interface ISQLEmployee {
    
    
    public EmployeesModel getEmployees();
    
    public EmployeesModel getEmployeesOnTeam(int teamID);
    
    public EmployeesModel getUnassignedEmployees();
    
    public Employee getEmployee(int employeeID);

    public int addEmployee(Employee employee);
}
