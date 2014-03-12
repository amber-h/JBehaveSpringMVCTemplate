<div id="teamList">
    <h1>Teams</h1>
    <table id="playerTable">
        <thead>
        <tr>
            <th>Team Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="team" items="${teams}">

            <tr>
                <td>
                    <p class="player-name">${team.name}</p>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
