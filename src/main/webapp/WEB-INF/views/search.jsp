<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/scripts/css/style.css' />" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,500italic,700,700italic'
          rel='stylesheet' type='text/css'>
    <title id="pageTitle">Football Manager</title>
</head>
<body>
<%@ include file="snippets/menuSnippet.jsp" %>

<div id="contents">
    <img id="banner-image" src="<c:url value='/images/banner.png'/>"/>

    <form action="search" method="post">
        Player Name: <input type="text" name="name"><br>
        <input type="submit" value="Submit">
    </form>

    <form action="search" method="post" >
        Number: <input type="text" name="number"><br>
        <input type="submit" value="Submit">
    </form>

    <form action="search" method="post">
        Team Name: <input type ="text" name="teamName"><br>
        <input type="submit" value="Submit">
    </form>

    <form action="search" method="post">
        Find Players Older Than: <input type ="text" name="age"><br>
        <input type="submit" value="Submit">
    </form>
</div>



</body>
</html>
