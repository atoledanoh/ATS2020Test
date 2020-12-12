<%-- 
    Document   : ShowEmployeeDetails
    Created on : 17-Nov-2020, 3:25:14 PM
    Author     : AlejandroT
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Employee"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="employees" type="com.nbcc.gex.viewmodel.EmployeesViewModel" %>

<%
    Employee employee = employees.getSelectedEmployee();
%>

<div>
    <h2><%= employee.getFirstName() %></h2>
    <h3>SIN:</h3>
    <p>
        <%= employee.getSIN()%>
    </p>
    <h3>Pay Rate:</h3>
    <p>
        <%= employee.getPayRate() %> dollars
    </p>
    <a href="viewEmployeesPage" ><button>Back To List</button></a>
</div>