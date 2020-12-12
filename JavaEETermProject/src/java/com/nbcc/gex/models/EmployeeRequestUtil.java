/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.models;

import com.nbcc.gex.formmodels.EmployeeFormModel;
import com.nbcc.gex.viewmodel.EmployeesViewModel;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AlejandroT
 */
public class EmployeeRequestUtil {

    private static final String EMPLOYEE_MODEL_VALUE = "EmployeesModel";

    public static void setEmployeesModel(HttpServletRequest request, EmployeesViewModel model) {
        request.setAttribute(EMPLOYEE_MODEL_VALUE, model);
    }

    public static EmployeesViewModel getEmployeesModel(HttpServletRequest request) {
        Object employeesModel = request.getAttribute(EMPLOYEE_MODEL_VALUE);

        if (employeesModel != null) {
            return (EmployeesViewModel) employeesModel;
        }

        return new EmployeesViewModel();
    }

    public static EmployeeFormModel extractEmployeeFromRequest(HttpServletRequest request) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String SIN = request.getParameter("SIN");
        String payRate = request.getParameter("payRate");

        EmployeeFormModel extractedEmployee = new EmployeeFormModel(firstName, lastName, SIN, payRate);
        
        return extractedEmployee;
    }

}
