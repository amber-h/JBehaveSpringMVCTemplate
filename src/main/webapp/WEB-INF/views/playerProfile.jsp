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
        <c:when test="${player==null}">
            <div>
                <p>404</p>
            </div>
        </c:when>
        <c:otherwise>
            <div>
                <p>This is the profile page for: ${player.name}</p>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
