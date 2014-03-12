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




    <c:choose>
    <c:when test="${results.size()>0}">
    <div id="playerList">
    <h1>Players</h1>
        <table id="playerTable">
            <thead>
            <tr>
                <th>Name</th>
                <th>Team</th>
                <th>Number</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="player" items="${results}">
                <tr>
                    <td>
                        <p class="player-name">${player.name}</p>
                    </td>
                    <td>
                        <p>${player.team}</p>
                    </td>
                    <td>
                        <p>${player.number}</p>
                    </td>
                    <td>
                        <p>${player.age}</p>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </c:when>
    <c:otherwise>
        <div id="noResultsMessage">
            <h1>Your search returned no results.</h1>
        </div>
    </c:otherwise>
    </c:choose>

    <c:choose>
    <c:when test="${teamName != null}">
    <h2>Coaches</h2>
    <c:choose>
        <c:when test="${coachResults.size()>0}">
            <div id="coachList">
                <table id="coachTable">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Title</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="coach" items="${coachResults}">
                        <tr>
                            <td>
                                <p class="player-name">${coach.name}</p>
                            </td>
                            <td>
                                <p>${coach.team}</p>
                            </td>
                            <td>
                                <p>${coach.title}</p>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:when>
        <c:otherwise>
            <div id="noResultsMessage">
                <p>Your search returned no results.</p>
            </div>
        </c:otherwise>
    </c:choose>
    </c:when>
    </c:choose>

</div>


</body>
</html>

