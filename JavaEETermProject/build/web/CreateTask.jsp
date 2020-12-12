<%-- 
    Document   : CreateTask
    Created on : 14-Nov-2020, 11:21:20 PM
    Author     : Joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Task</title>
    </head>
    <div class="container">
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
    </div>
    <body>
        <div class="container">
            <h1>Create Task</h1>
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
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>
