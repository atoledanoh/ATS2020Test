<%-- 
    Document   : CreateEmployee
    Created on : 27-Nov-2020, 10:07:47 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="employees" type="com.nbcc.gex.viewmodel.EmployeesViewModel" %>

<div class="container">
    <h1>Create Employee - in the tag</h1>
    <ul>
    <% for (String error : employees.getErrors()) { %>
        <li style="color: #FF0000;"><%= error %></li>
    <% } %>
    </ul>
    <form action="viewEmployeesPage" method="POST">
        <div class="form-group">
            <input type="hidden" name="action" value="createEmployee" />
        </div>
        <div class="form-group">
            <label for="firstName">Employee First Name:</label>
            <input class="form-control" type="text" id="firstName" name="firstName" /><br />
        </div>
        <div class="form-group">
            <label for="lastName">Employee Last Name:</label>
            <input class="form-control" type="text" id="lastName" name="lastName" /><br />
        </div>
        <div class="form-group">
            <label for="SIN">Employee SIN:</label>
            <input class="form-control" type="text" id="SIN" name="SIN" /><br />
        </div>
        <div class="form-group">
            <label for="payRate">Employee Pay Rate:</label>
            <input class="form-control" type="text" id="payRate" name="payRate" /><br />
        </div>
        <div class="form-group">
            <button type="submit"class="btn btn-primary">Create Employee</button>
        </div>
    </form>
</div>