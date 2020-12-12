<%-- 
    Document   : DisplayTeams
    Created on : 18-Nov-2020, 4:39:51 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Team"%>

<%@attribute name="teams" type="com.nbcc.gex.viewmodel.TeamsViewModel" %>

<h1>Teams List:</h1>
<form action="viewTeamsPage" method="POST">
    <input type="hidden" name="action" value="showDetails" />
    <table border='0px' width="100%">
        <% for (Team team : teams.getTeams()) {%>
        <tr>
            <td><b><%= team.getName()%>:</b></td>
            <td><button type="submit" name="teamID" value="<%= team.getTeamID()%>" >Show Details</button></td>
        </tr>
        <% }%>
    </table>
</form>
<form action="viewTeamsPage" method="POST">
        <input type="hidden" name="action" value="loadCreateTeam" />
        <button type="submit" >Create Team</button>
</form>    