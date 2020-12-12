/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.Utilities;

import com.nbcc.gex.formmodels.EmployeeFormModel;
import com.nbcc.gex.models.Employee;
import java.util.ArrayList;

/**
 *
 * @author AlejandroT
 */

public class EmployeeValidator {
    
    public static Employee validateEmployee(EmployeeFormModel employeeForm, ArrayList<String> errors){
        
        Employee employee = new Employee();
        errors.clear();
        
        String firstName = employeeForm.getFirstName();
        String lastName = employeeForm.getLastName();
        String payRateString = employeeForm.getPayRate();
        String SINString = employeeForm.getSIN();
        
        try {
            // Check employee first name not empty
            if ("".equals(firstName))
                errors.add("First name field must not be empty");
            else
                employee.setFirstName(firstName);
            
            // Check employee last name not empty
            if ("".equals(lastName))
                errors.add("Last name field must not be empty");
            else
                employee.setLastName(lastName);
            
            //check SIN is an integer
            int SIN = Integer.parseInt(SINString);
            
            //check pay rate is a float
            float payRate = Float.parseFloat(payRateString);
            
            employee.setSIN(SIN);
            employee.setPayRate(payRate);
            
        } catch (NumberFormatException nfe){
            errors.add("SIN and Pay Rate must be numbers");
        }
        
        if (errors.size() > 0)
            return new Employee();
        else
            return employee;
    }
}
