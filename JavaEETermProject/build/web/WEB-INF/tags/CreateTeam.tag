<%-- 
    Document   : CreateTeam
    Created on : 27-Nov-2020, 10:17:46 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Employee"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="teams" type="com.nbcc.gex.viewmodel.TeamsViewModel" %>

<div class="container">
    <h1>Create Team - in tag file</h1>
    <ul>
    <% for (String error : teams.getErrors()) { %>
        <li style="color: #FF0000;"><%= error %></li>
    <% } %>
    </ul>
    <form action="viewTeamsPage" method="POST">
        <div class="form-group">
            <input type="hidden" name="action" value="createTeam" />
        </div>
        <div class="form-group">
            <label for="name">Team Name:</label>
            <input class="form-control" type="text" id="name" name="name" /><br />
        </div>
        <div class="form-group">
            <label for="isOnCall">Is On Call: </label>
            <input type="checkbox" name="isOnCall" value="true" />
            <input type="hidden" name="isOnCall" value="false" />

            <br />
        </div>
        <div class="form-group">
            <label for="name">Available Employees (please select 2): </label>
            <table border='0px' width="100%">
                <% for (Employee employee : teams.getAvailableEmployees().getEmployeesList()) {%>
                <tr>
                    <td><b><%= employee.getFirstName()%></b></td>
                    <td><b><%= employee.getLastName()%></b></td>
                    <td><input type="checkbox" name="employees" value="<%= employee.getEmployeeID() %>" /></td>
                </tr>
                <% }%>
            </table>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Create Team</button>
        </div>
    </form>
</div>