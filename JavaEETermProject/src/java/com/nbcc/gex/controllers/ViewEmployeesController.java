/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.controllers;

import com.nbcc.gex.Utilities.EmployeeValidator;
import com.nbcc.gex.dataaccess.EmployeeFactory;
import com.nbcc.gex.dataaccess.ISQLEmployee;
import com.nbcc.gex.formmodels.EmployeeFormModel;
import com.nbcc.gex.models.Employee;
import com.nbcc.gex.models.EmployeeRequestUtil;
import com.nbcc.gex.models.EmployeesModel;
import com.nbcc.gex.viewmodel.EmployeesViewModel;
import com.nbcc.gex.viewmodel.Utility.UIState;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joe
 */
public class ViewEmployeesController extends HttpServlet {

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get employees from database
        ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
        EmployeesModel employees = employeeRepo.getEmployees();

        // load view Employees model
        EmployeesViewModel viewModel = new EmployeesViewModel();
        loadViewModel(viewModel, employees.getEmployeesList(), UIState.LIST, null, null);

        // send ViewEmployeesModel
        EmployeeRequestUtil.setEmployeesModel(request, viewModel);

        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewEmployees.jsp");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
        EmployeesModel employees = employeeRepo.getEmployees();
        EmployeesViewModel viewModel = new EmployeesViewModel();

        if ("showDetails".equals(action)) {
            // get data from sender
            String showEmployeeID = request.getParameter("employeeID");
            String deleteEmployeeID = request.getParameter("deleteEmployeeID");

            if (showEmployeeID != null) {
                // load view employee model
                loadViewModel(viewModel, employees.getEmployeesList(),
                        UIState.SHOW_DETAILS, null, employees.getEmployee(Integer.parseInt(showEmployeeID)));

            } else if (deleteEmployeeID != null) {
                int employeeID = Integer.parseInt(deleteEmployeeID);
                String employeeName = employees.getEmployee(employeeID).getLastName() + ", " + employees.getEmployee(employeeID).getFirstName();

                // call storedproc to delete employee
                int rowsAffected = employeeRepo.deleteEmployee(employeeID);

                if (rowsAffected > 0) {
                    viewModel.getErrors().add("Deleted employee: " + employeeName);
                } else {
                    viewModel.getErrors().add("Unable to delete employee: " + employeeName);
                }

                // load view employee model
                employees = employeeRepo.getEmployees();
                loadViewModel(viewModel, employees.getEmployeesList(),
                        UIState.LIST, null, null);
            }

            
        } else if ("createEmployee".equals(action)) {
            // get data from sender
            EmployeeFormModel employeeForm = EmployeeRequestUtil.extractEmployeeFromRequest(request);

            // Get Validated Employee (or empty Employee or new Employee if invalid inputs)
            // Side effect - loads errors arraylist if invalid data
            Employee employeeToCreate = EmployeeValidator.validateEmployee(employeeForm, viewModel.getErrors());

            if (viewModel.getErrors().isEmpty()) { // validate the employee
                // Clear errors
                viewModel.getErrors().clear();

                // send employee to database
                employeeRepo.addEmployee(employeeToCreate);

                // load view tasks model
                employees = employeeRepo.getEmployees();
                loadViewModel(viewModel, employees.getEmployeesList(), UIState.LIST, null, null);

            } else { // not valid

                // load view tasks model
                loadViewModel(viewModel, employees.getEmployeesList(), UIState.CREATE, null, null);
            }

        } else if ("loadCreateEmployee".equals(action)) {

            // load view tasks model
            loadViewModel(viewModel, employees.getEmployeesList(), UIState.CREATE, null, null);
        }

        // send view employees model
        EmployeeRequestUtil.setEmployeesModel(request, viewModel);

        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewEmployees.jsp");

    }

    private void loadViewModel(
            EmployeesViewModel viewModel,
            ArrayList<Employee> employees,
            UIState state,
            ArrayList<String> errors,
            Employee selectedEmployee) {
        viewModel.setState(state);
        viewModel.setSelectedEmployee(selectedEmployee);

        if (employees != null) {
            viewModel.setEmployees(employees);
        }

        if (errors != null) {
            viewModel.setErrors(errors);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
