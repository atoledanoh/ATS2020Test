<%-- 
    Document   : CreateTask
    Created on : 25-Nov-2020, 11:07:21 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="tasks" type="com.nbcc.gex.viewmodel.TasksViewModel" %>

<div class="container">
    <h1>Create Task</h1>
    <ul>
    <% for (String error : tasks.getErrors()) { %>
        <li style="color: #FF0000;"><%= error %></li>
    <% } %>
    </ul>
    <form action="viewTasksPage" method="POST">
        <div class="form-group">
            <input type="hidden" name="action" value="createTask" />
        </div>
        <div class="form-group">
            <label for="name">Task Name:</label>
            <input class="form-control" type="text" id="name" name="name" /><br />
        </div>
        <div class="form-group">
            <label for="name">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="10" cols="30"></textarea><br />
        </div>
        <div class="form-group">
            <label for="name">Duration:</label>
            <input class="form-control" type="text" id="duration" name="duration" /><br />
        </div>
        <div class="form-group">
            <button type="submit"class="btn btn-primary">Create Task</button>
        </div>
    </form>
</div>