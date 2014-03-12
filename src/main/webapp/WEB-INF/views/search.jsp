<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/scripts/css/style.css' />" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='/scripts/css/search.css' />" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,500italic,700,700italic'
          rel='stylesheet' type='text/css'>
    <title id="pageTitle">Football Manager</title>
</head>
<body>
<%@ include file="snippets/menuSnippet.jsp" %>

<div id="contents">

    <img id="banner-image" src="<c:url value='/images/banner.png'/>"/>

    <span id="searchBy">
        <h1>Search By</h1>
    </span>
    <div id="searchContainer">
        <table>
            <thead></thead>
            <tbody>
                <tr>
                <form action="search" method="post">
                    <td class="searchDescription">Team Name:</td>
                    <td><input type="text" name="teamName" class="searchField"></td>
                    <td><input type="submit" value="Submit"></td>
                </form>
                </tr>
                <tr>
                <form action="search" method="post">
                    <td class="searchDescription">Find Players Older Than:</td>
                    <td><input type="text" name="age" class="searchField"></td>
                    <td><input type="submit" value="Submit"></td>
                </form>
                </tr>

                <form action="search" method="post">
                    <tr>
                        <td class="searchDescription">Player Name:</td>
                        <td><input type="text" name="name" class="searchField"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="searchDescription">Number:</td>
                        <td><input type="text" name="number" class="searchField"></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </form>
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
