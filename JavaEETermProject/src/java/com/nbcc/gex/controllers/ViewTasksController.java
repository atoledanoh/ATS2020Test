/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.controllers;

import com.nbcc.gex.Utilities.TaskValidator;
import com.nbcc.gex.dataaccess.ISQLTask;
import com.nbcc.gex.dataaccess.TaskFactory;
import com.nbcc.gex.formmodels.TaskFormModel;
import com.nbcc.gex.models.Task;
import com.nbcc.gex.models.TaskRequestUtil;
import com.nbcc.gex.models.TasksModel;
import com.nbcc.gex.viewmodel.TasksViewModel;
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
public class ViewTasksController extends HttpServlet {

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

        // Get Tasks from database
        ISQLTask taskRepo = TaskFactory.createTask();
        TasksModel tasks = taskRepo.getTasks();

        // load view tasks model
        TasksViewModel viewModel = new TasksViewModel();
        loadViewModel(viewModel, tasks.getTasksList(), UIState.LIST, null, null);

        // send ViewTasksModel
        TaskRequestUtil.setTasksModel(request, viewModel);

        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewTasks.jsp");
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
        
        ISQLTask taskRepo = TaskFactory.createTask();
        TasksModel tasks = taskRepo.getTasks();
        TasksViewModel viewModel = new TasksViewModel();

        if ("showDetails".equals(action)) {
            // get data from sender
            String showTaskID = request.getParameter("showTaskID");
            String deleteTaskID = request.getParameter("deleteTaskID");
            
            if (showTaskID != null){ 
                // load view tasks model
                loadViewModel(viewModel, tasks.getTasksList(),
                    UIState.SHOW_DETAILS, null, tasks.getTask(Integer.parseInt(showTaskID)));
                
            } else if (deleteTaskID != null){
                int taskID = Integer.parseInt(deleteTaskID);
                String taskName = tasks.getTask(taskID).getName();
                
                // call storedproc to delete task
                int rowsAffected = taskRepo.deleteTask(taskID);
                
                if (rowsAffected > 0)
                    viewModel.getErrors().add("Deleted task: " + taskName);
                else
                    viewModel.getErrors().add("Unable to delete task: " + taskName);
                
                // load view tasks model
                tasks = taskRepo.getTasks();
                loadViewModel(viewModel, tasks.getTasksList(),
                    UIState.LIST, null, null);
            }
            
            
            
        } else if ("createTask".equals(action)) {
            // get data from sender
            TaskFormModel taskForm = TaskRequestUtil.extractTaskFormModelFromRequest(request);
            
            // Get Validated Task (or empty Task or new Task if invalid inputs)
            // Side effect - loads errors arraylist if invalid data
            Task taskToCreate = TaskValidator.validateTask(taskForm, viewModel.getErrors());

            if (viewModel.getErrors().isEmpty()){ // Validate the task
                // Clear errors
                viewModel.getErrors().clear();
                
                // send task to database
                taskRepo.addTask(taskToCreate);
                
                // load view tasks model
                tasks = taskRepo.getTasks();
                loadViewModel(viewModel, tasks.getTasksList(), UIState.LIST, null, null);

            } else { // not valid
                
                // load view tasks model
                loadViewModel(viewModel, tasks.getTasksList(), UIState.CREATE, null, null);
            }

        } else if ("loadCreateTask".equals(action)){
            
            // load view tasks model
            loadViewModel(viewModel, tasks.getTasksList(), UIState.CREATE, null, null);
        }
        
        // send ViewTasksModel
        TaskRequestUtil.setTasksModel(request, viewModel);

        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewTasks.jsp");

    }

    private void loadViewModel(
            TasksViewModel viewModel,
            ArrayList<Task> tasks,
            UIState state,
            ArrayList<String> errors,
            Task selectedTask)
    {
        viewModel.setState(state);
        viewModel.setSelectedTask(selectedTask);
        
        if (tasks != null){
            viewModel.setTasks(tasks);
        }
        
        if (errors != null){
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
