<%-- 
    Document   : DisplayTasks
    Created on : 15-Nov-2020, 11:17:48 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Task"%>

<%@attribute name="tasks" type="com.nbcc.gex.viewmodel.TasksViewModel" %>

<h1>Task List:</h1>
<ul>
    <% for (String error : tasks.getErrors()) { %>
        <li style="color: #FF0000;"><%= error %></li>
    <% } %>
</ul>
<form action="viewTasksPage" method="POST">
    <input type="hidden" name="action" value="showDetails" />
    <table class="table-striped" border='0px' width="100%">
        <% for (Task task : tasks.getTasks()) {%>
        <tr>
            <td><b><%= task.getName()%>:</b></td>
            <td><button type="submit" name="showTaskID" value="<%= task.getTaskID()%>" >Show Details</button></td>
            <td><button type="submit" name="deleteTaskID" value="<%= task.getTaskID()%>" >Delete</button></td>
        </tr>
        <tr>
            <td colspan="2"><%= task.getDescription()%></td>
        </tr>
        <% }%>
    </table>
</form>
<form action="viewTasksPage" method="POST">
    <input type="hidden" name="action" value="loadCreateTask" />
    <button type="submit" >Create Task</button>
</form>