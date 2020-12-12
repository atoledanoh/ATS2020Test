<%-- 
    Document   : ViewTasks
    Created on : 14-Nov-2020, 9:37:36 PM
    Author     : Joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nbcc.gex.models.Task"%>
<%@page import="com.nbcc.gex.viewmodel.TasksViewModel"%>
<%@page import="com.nbcc.gex.viewmodel.Utility.UIState"%>
<%@page import="com.nbcc.gex.models.TaskRequestUtil"%>
<%@page import="java.util.ArrayList"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="ATS"%>

<%
    TasksViewModel tasks = TaskRequestUtil.getTasksModel(request);
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task List</title>
    </head>
    <body>
        <header>
            <div class="container">
                <%@include file="/WEB-INF/jspf/navigation.jspf" %>
            </div>
        </header>
        <div class="container">
            <% switch (tasks.getState()) {
                case SHOW_DETAILS: %>
                    <ATS:ShowTaskDetails tasks="<%= tasks %>" />
                    <% break;
                    case CREATE:%>
                    <ATS:CreateTask tasks="<%= tasks %>" />
                    <% break;
                    case LIST:
                    default: %>
                    <ATS:DisplayTasks tasks="<%= tasks %>" />
            <% } %>
        </div>
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>
