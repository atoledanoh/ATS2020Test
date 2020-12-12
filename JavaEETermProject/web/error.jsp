<%-- 
    Document   : error
    Created on : 10-Nov-2020, 11:23:31 PM
    Author     : Joe/Alejandro
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <div class="container">
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
    </div>
    <body>
        <div class="container">
            <H1>ERROR PAGE</H1>
            <!-- This displays the fully-qualified name of the exception and its message--> 
            <%= exception.toString()%> 
            <br> 
            <!-- This displays the exception's descriptive message --> 
            <%= exception.getMessage()%><br />
            <a href="IndexPage">Home</a>
        </div>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </body>
</html>
