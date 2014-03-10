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

<div id="menu">
    <ul>
        <li>
            <a href="<c:url value='/' />">
                List Players</a>
        </li>
        <li>
            <a href="<c:url value="/search" />">Search</a>
        </li>
    </ul>

</div>

<div id="contents">
    <img id="banner-image" src="<c:url value='/images/banner.png'/>"/>

    <div id="banner">
        <p>${banner}</p>
    </div>

    <div id="playerList">
        <table id="playerTable">
            <thead><b>Players</b></thead>
        <tbody>

        <c:forEach var="player" items="${players}">
            <tr>
                <td>
                    <p>${player.name}</p>
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
</div>
</body>
</html>
