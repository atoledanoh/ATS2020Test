<%-- 
    Document   : CreateEmployee
    Created on : 17-Nov-2020, 11:58:24 AM
    Author     : AlejandroT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Employee</title>
    </head>
    <div class="container">
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
    </div>
    <body>
        <div class="container">
            <h1>Create Employee</h1>
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
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>
