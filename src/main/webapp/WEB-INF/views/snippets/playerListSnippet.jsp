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
        <c:forEach var="player" items="${players}">

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
