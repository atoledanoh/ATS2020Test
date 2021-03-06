<%-- 
    Document   : DisplayEmployees
    Created on : 17-Nov-2020, 3:24:52 PM
    Author     : AlejandroT
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Employee"%>

<%@attribute name="employees" type="com.nbcc.gex.viewmodel.EmployeesViewModel" %>

<h1>Employee List:</h1>

<ul>
    <% for (String error : employees.getErrors()) {%>
    <li style="color: #FF0000;"><%= error%></li>
        <% } %>
</ul>

<form action="viewEmployeesPage" method="POST">
    <input type="hidden" name="action" value="showDetails" />
    <table class="table-striped" border='0px' width="100%">
        <% for (Employee employee : employees.getEmployees()) {%>
        <tr>
            <td><b><%= employee.getLastName() + ", " + employee.getFirstName()%>:</b></td>
            <td><button type="submit" name="employeeID" value="<%= employee.getEmployeeID()%>" >Show Details</button></td>
            <td><button type="submit" name="deleteEmployeeID" value="<%= employee.getEmployeeID()%>" >Delete</button></td>
        </tr>
        <% }%>
    </table>
</form>
<form action="viewEmployeesPage" method="POST">
    <input type="hidden" name="action" value="loadCreateEmployee" />
    <button type="submit" >Create Employee</button>
</form>