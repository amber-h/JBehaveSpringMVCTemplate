<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/scripts/css/style.css' />" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,500italic,700,700italic'
          rel='stylesheet' type='text/css'>
    <title>Football Manager</title>
</head>
<body>
<%@ include file="snippets/menuSnippet.jsp" %>

<div id="contents">
    <img id="banner-image" src="<c:url value='/images/banner.png'/>"/>

    <div id="listContainer">
        <div id="teamRecords">
            <h1>Teams</h1>
            <table id="playerTable">
                <thead>
                <tr>
                    <th>Team Name</th>
                    <th>Wins</th>
                    <th>Losses</th>
                    <th>Ties</th>
                    <th>Win %</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="team" items="${teams}">

                    <tr>
                        <td><p class="player-name">${team.name}</p></td>
                        <td><p>${team.wins}</p></td>
                        <td><p>${team.losses}</p></td>
                        <td><p>${team.ties}</p></td>
                        <td><p>${team.winPercentage}%</p></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
