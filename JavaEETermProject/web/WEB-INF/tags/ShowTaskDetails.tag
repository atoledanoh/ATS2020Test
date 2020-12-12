<%-- 
    Document   : ShowDetails
    Created on : 15-Nov-2020, 11:27:05 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Task"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="tasks" type="com.nbcc.gex.viewmodel.TasksViewModel" %>

<%  
   Task task = tasks.getSelectedTask();
%>

<div>
    <h2><%= task.getName() %></h2>
    <h3>Description:</h3>
    <p>
        <%= task.getDescription() %>
    </p>
    <h3>Duration:</h3>
    <p>
        <%= task.getDuration() %> minutes
    </p>
    <a href="viewTasksPage" ><button>Back To List</button></a>
</div>