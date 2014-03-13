<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/scripts/css/style.css' />" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,500italic,700,700italic'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <title>Football Manager</title>
</head>
<body>

    <%@ include file="snippets/menuSnippet.jsp" %>

<div id="contents">
    <img id="banner-image" src="<c:url value='/images/banner.png'/>"/>
    <div id ="directions">
        <p>${directions}</p>
    </div>
    <div>
        <form action="/trade" method="GET">
            <div id="listContainer">
                <%@include file="snippets/playerListSnippet.jsp"%>

                <div id="teamList">
                    <h1>Teams</h1>
                    <table id="teamTable">
                        <thead>
                        <tr>
                            <th>Team</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="team" items="${teams}">
                            <tr>
                                <td>
                                    <p class="team-name">${team.name}</p>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </form>
    </div>
</div>

</body>

<script>
    $(function() {
        $( ".player-name" ).draggable({
            cursor: 'move',
            revert: true
        });
        $( ".team-name" ).droppable({
            drop: function( event, ui ) {
                $( this )
                        .addClass( "ui-state-highlight" )
                        .find( "p" )
                        .html( "Dropped!" );

                var droppedItem = $(ui.draggable);
                droppedItem.addClass("ui-state-highlight")
                droppedItem.team = 'Test'

            }
        });
    });

</script>
</html>
