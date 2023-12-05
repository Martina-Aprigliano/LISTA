class PLayer {
    constructor(nickname, nome, cognome, team) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.team = team;
    }

    listItem() {
        return "<li onclick=\"renderDettPlayer('" + this.nickname + "')\">" + this.nickname + "</li>";
    }

    dettPlayer() {
        return "<p>Nickname: " + this.nickname + "</p>" +
            "<p>Nome: " + this.nome + "</p>" +
            "<p>Cognome: " + this.cognome + "</p>" +
            "<p>Team: " + this.team + "</p>";
    }
}





function renderDettPlayer(player) {
    document.getElementById('modal-dett-player').style.display = 'block';
    document.getElementById('mod-id').value = player.getAttribute('data-id');
    document.getElementById('mod-nickname').value = player.getAttribute('data-nickname');
    document.getElementById('mod-nome').value = player.getAttribute('data-nome');
    document.getElementById('mod-cognome').value = player.getAttribute('data-cognome');
    document.getElementById('mod-id-team').value = player.getAttribute('data-team-id');
}


function pulisciNewPlayer() {
    for (let input of document.querySelectorAll("#modal-new-player > .modal-content > input")) {
        input.value = "";
    }
    document.querySelector("#modal-new-player > .modal-content > select").value = "";
}

function pulisciModPlayer() {
    for (let input of document.querySelectorAll("#modal-dett-player > .modal-content > input")) {
        input.value = "";
    }
    document.querySelector("#modal-dett-player > .modal-content > select").value = "";
}

function pulisciNewTeam() {
    document.querySelector("#modal-new-team > .modal-content > input").value = "";
}


function addNewTeam() {
    teams.push(document.getElementById("new-nome-team").value.toUpperCase());
    renderTeamList();
    pulisciNewTeam();
    document.getElementById("modal-new-team").style.display = "none";
}

function init() {
    document.getElementById("btn-new-player").onclick = function () {
        document.getElementById('modal-new-player').style.display = 'block';
    }
    document.getElementById("btn-new-team").onclick = function () {
        document.getElementById('modal-new-team').style.display = 'block';
    }

    document.getElementById("close-modal-new").onclick = function () {
        document.getElementById("modal-new-player").style.display = "none";
    }

    document.getElementById("close-modal-dett").onclick = function () {
        document.getElementById("modal-dett-player").style.display = "none";
    }
    document.getElementById("close-modal-new-team").onclick = function () {
        document.getElementById("modal-new-team").style.display = "none";
    }

    renderListPlayers();
    renderTeamList()
}

