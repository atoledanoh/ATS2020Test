<%-- 
    Document   : ViewTeams
    Created on : 18-Nov-2020, 4:41:22 PM
    Author     : Joe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nbcc.gex.models.Team"%>
<%@page import="com.nbcc.gex.viewmodel.TeamsViewModel"%>
<%@page import="com.nbcc.gex.viewmodel.Utility.UIState"%>
<%@page import="com.nbcc.gex.models.TeamRequestUtil"%>
<%@page import="java.util.ArrayList"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="ATS"%>

<%
    TeamsViewModel teams = TeamRequestUtil.getTeamsModel(request);
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teams List</title>
    </head>
    <header>
        <div class="container">
            <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        </div>
    </header>
    <body>
        <div class="container">
            <% switch (teams.getState()) {
                case SHOW_DETAILS: %>
                    <ATS:ShowTeamDetails teams="<%= teams %>" />
                    <% break;
                    case CREATE:%>
                    <ATS:CreateTeam teams="<%= teams %>" />
                    <% break;
                    case LIST:
                    default: %>
                    <ATS:DisplayTeams teams="<%= teams %>" />
            <% } %>
        </div>
    </body>
    <footer>
        <div class="container">
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
        </div>
    </footer>
</html>