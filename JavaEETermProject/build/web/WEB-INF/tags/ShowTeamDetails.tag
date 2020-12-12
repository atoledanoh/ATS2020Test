<%-- 
    Document   : ShowTeamDetails
    Created on : 18-Nov-2020, 4:40:09 PM
    Author     : Joe
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="com.nbcc.gex.models.Team"%>
<%@tag import="com.nbcc.gex.models.Employee"%>

<%@attribute name="teams" type="com.nbcc.gex.viewmodel.TeamsViewModel" %>

<%  
   Team team = teams.getSelectedTeam();
%>

<div>
    <h2><%= team.getName() %></h2>
    <h3>Is On Call?: </h3><%= team.getIsOnCall() ? "On Call" : "NOT On Call"%><br />
    
    <h3>Is Team Deleted?: </h3><%= team.getIsDeleted() ? "Deleted" : "NOT Deleted"%><br />
    
    <h3>Team Members: </h3>
    <table border='0px' width="100%">
    <% for (Employee member : team.getMembers().getEmployeesList()) {%>
        <tr>
            <td><b><%= member.getFirstName()%> <%= member.getLastName()%></td>
        </tr>
    <% }%>
    </table>
    <br />
    <a href="viewTeamsPage" ><button>Back To List</button></a>
</div>