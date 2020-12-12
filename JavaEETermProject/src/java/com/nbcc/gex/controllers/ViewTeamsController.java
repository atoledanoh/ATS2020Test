/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc.gex.controllers;

import com.nbcc.gex.Utilities.TeamValidator;
import com.nbcc.gex.dataaccess.EmployeeFactory;
import com.nbcc.gex.dataaccess.ISQLEmployee;
import com.nbcc.gex.dataaccess.ISQLTeam;
import com.nbcc.gex.dataaccess.TeamFactory;
import com.nbcc.gex.formmodels.TeamFormModel;
import com.nbcc.gex.models.EmployeesModel;
import com.nbcc.gex.models.Team;
import com.nbcc.gex.models.TeamRequestUtil;
import com.nbcc.gex.models.TeamsModel;
import com.nbcc.gex.viewmodel.TeamsViewModel;
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
public class ViewTeamsController extends HttpServlet {

   
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
        
        // Get Teams from database
        ISQLTeam teamRepo = TeamFactory.createTeam();
        TeamsModel teams = teamRepo.getTeams();
        
        // load view tasks model
        TeamsViewModel viewModel = new TeamsViewModel();
        loadViewModel(viewModel, teams.getTeamsList(), UIState.LIST, null, null);

        // send ViewTasksModel
        TeamRequestUtil.setTeamsModel(request, viewModel);
        
        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewTeams.jsp");
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
        
        ISQLTeam teamRepo = TeamFactory.createTeam();
        TeamsModel teams = teamRepo.getTeams();
        TeamsViewModel viewModel = new TeamsViewModel();

        if ("showDetails".equals(action))
        {
            // get data from sender
            String teamID = request.getParameter("teamID");

            // load view tasks model
            loadViewModel(viewModel, teams.getTeamsList(),
                    UIState.SHOW_DETAILS, null, teams.getTeam(Integer.parseInt(teamID)));

        }
        else if ("createTeam".equals(action))
        {
            // get data from sender
            TeamFormModel teamForm = TeamRequestUtil.extractTeamFormModelFromRequest(request);
            
            // Get Validated Team (or empty Team or new Team if invalid inputs)
            // Side effect - loads errors arraylist if invalid data
            Team teamToCreate = TeamValidator.validateTeam(teamForm, viewModel.getErrors());
            
            if (viewModel.getErrors().isEmpty()){ // Validate the team
                // Clear errors
                viewModel.getErrors().clear();
                
                // send team to database
                teamRepo.addTeam(teamToCreate);
                
                // load view teams model
                teams = teamRepo.getTeams();
                loadViewModel(viewModel, teams.getTeamsList(), UIState.LIST, null, null);

            } else { // not valid
   
                // Load available employees into view model
                ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
                EmployeesModel availableEmployees = employeeRepo.getUnassignedEmployees();
                viewModel.setAvailableEmployees(availableEmployees);
                
                // load view tasks model
                loadViewModel(viewModel, teams.getTeamsList(), UIState.CREATE, null, null);
            }

        }
        else if ("loadCreateTeam".equals(action))
        {
            // Load available employees into view model
            ISQLEmployee employeeRepo = EmployeeFactory.createEmployee();
            EmployeesModel availableEmployees = employeeRepo.getUnassignedEmployees();
            viewModel.setAvailableEmployees(availableEmployees);
            
            // load view tasks model
            loadViewModel(viewModel, teams.getTeamsList(), UIState.CREATE, null, null);
        }
        
        // send ViewTasksModel
        TeamRequestUtil.setTeamsModel(request, viewModel);

        // forward
        ControllerUtility.forwardToPage(this, request, response, "/ViewTeams.jsp");

    }
    
    private void loadViewModel(
            TeamsViewModel viewModel,
            ArrayList<Team> teams,
            UIState state,
            ArrayList<String> errors,
            Team selectedTeam)
    {
        viewModel.setState(state);
        viewModel.setSelectedTeam(selectedTeam);
        
        if (teams != null){
            viewModel.setTeams(teams);
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
