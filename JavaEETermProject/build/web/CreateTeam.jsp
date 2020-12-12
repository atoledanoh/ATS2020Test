<%-- 
    Document   : CreateTeam
    Created on : 18-Nov-2020, 4:38:32 PM
    Author     : Joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nbcc.gex.models.Employee"%>
<%@page import="com.nbcc.gex.models.EmployeesModel"%>
<%@page import="com.nbcc.gex.models.EmployeeRequestUtil"%>
<%@page import="java.util.ArrayList"%>

<%
    EmployeesModel employees = EmployeeRequestUtil.getEmployeesModel(request);
%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Team</title>
    </head>
    <div class="container">
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
    </div>
    <body>
        <div class="container">
            <h1>Create Team</h1>
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
                        <% for (Employee employee : employees.getEmployeesList()) {%>
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
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>
