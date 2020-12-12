<%-- 
    Document   : ViewEmployees
    Created on : 17-Nov-2020, 11:58:51 AM
    Author     : AlejandroT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nbcc.gex.models.Employee"%>
<%@page import="com.nbcc.gex.viewmodel.EmployeesViewModel"%>
<%@page import="com.nbcc.gex.viewmodel.Utility.UIState"%>
<%@page import="com.nbcc.gex.models.EmployeeRequestUtil"%>
<%@page import="java.util.ArrayList"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="ATS"%>

<%
    EmployeesViewModel employees = EmployeeRequestUtil.getEmployeesModel(request);
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
        <header>
            <div class="container">
                <%@include file="/WEB-INF/jspf/navigation.jspf" %>
            </div>
        </header>
        <div class="container">
            <% switch (employees.getState()) {
                case SHOW_DETAILS: %>
                    <ATS:ShowEmployeeDetails employees="<%= employees %>" />
                    <% break;
                    case CREATE:%>
                    <ATS:CreateEmployee employees="<%= employees %>" />
                    <% break;
                    case LIST:
                    default: %>
                    <ATS:DisplayEmployees employees="<%= employees %>" />
            <% } %>
        </div>
        <footer>
            <div class="container">
                <%@include file="/WEB-INF/jspf/footer.jspf" %>
            </div>
        </footer>
    </body>
</html>
