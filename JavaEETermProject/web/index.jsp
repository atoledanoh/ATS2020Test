<%-- 
    Document   : index
    Created on : 10-Nov-2020, 9:41:08 PM
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
        <title>Index JSP</title>
    </head>
    <div class="container">
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
    </div>
    <body>
        <div class="container">

            <h1>Welcome to Advanced Technology Systems job booking software.</h1>
            <p>
                From here you can <a href="">create a job</a>, <a href="">View a list of employees</a>, <a href="">Set skills/tasks for employees</a>, 
            </p>
            <h3>Other Options Available include:</h3>
            <ul>
                <li>Taking Over the world</li>
                <li>Eradicating the human species</li>
                <li>Auto-correcting gentle to genital</li>
            </ul>
            <h3>Options Not Included:</h3>
            <ul>
                <li>Toasting two consecutive slices of bread to the same darkness</li>
            </ul>
            <img src="https://static01.nyt.com/images/2018/05/15/arts/01hal-voice1/merlin_135847308_098289a6-90ee-461b-88e2-20920469f96a-jumbo.jpg?quality=90&auto=webp" style="width:30%">
            <p> This mission is too important for me to allow you to jeopardize it.</p>
        </div>
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>
