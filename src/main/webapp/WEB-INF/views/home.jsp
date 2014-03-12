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

    <div id="banner">
        <p>${banner}</p>
    </div>

    <div id="listContainer">
    <%@include file="snippets/playerListSnippet.jsp"%>

    <div id="coachList">
        <h1>Coaches</h1>
        <table id="coachTable">
            <thead>
            <tr>
                <th>Name</th>
                <th>Team</th>
                <th>Title</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="coach" items="${coaches}">
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
    </div>
</div>
</body>
</html>
