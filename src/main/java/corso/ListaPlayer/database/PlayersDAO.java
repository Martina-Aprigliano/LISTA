package Progetto.sport.database;

import java.util.ArrayList;
import java.util.HashMap;

import corso.ListaPlayer.modelli.Player;
import corso.ListaPlayer.modelli.Team;

public class DAOplayers {
	
	private static DAOplayers instance;

	private DAOplayers() {
	}

	public static DAOplayers getInstance() {
		if(instance == null) 
			instance = new DAOplayers();
		return instance;
	}
	
	private HashMap<Integer, Player> readAll(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
		Player n = null;
		HashMap<Integer, Player> ris = new HashMap<Integer, Player>();
		for (HashMap<String, Object> record : listaMappe) {
			n = new Player();
			n.setId((int) record.get("id"));
			n.setNickname((String) record.get("nome"));
			n.setNome((String) record.get("cognome"));
			n.getTeam().setId((int) record.get("numeroMaglia"));
			n.getTeam().setId((int) record.get("idTeam"));
			n.setCognome((String) record.get("ruolo"));

			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean update(String query, String... params) {
		return Database.getInstance().eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Players> read() {
		String query = "select P.id, P.nome, cognome, cognome, T.id as id_team, T.nome as nome_team from PLAYERS P left join TEAMS T on P.id_team = T.id";
		return readAll(query);
	}

	public boolean create(HashMap<String, String> parametri) {
		String query = "insert into PLAYERS(nickname, nome, cognome, id_team) values(?,?,?,?)";
		return update(query, 
				parametri.get("nickname"), 
				parametri.get("nome"), 
				parametri.get("cognome"), 
				parametri.get("idteam"));
	}
	
	public boolean update(HashMap<String, String> parametri) {
		String query = "update PLAYERS set nickname = ?, nome = ?, cognome = ?, id_team = ? where id = ?";
		return update(query, 
				parametri.get("nickname"), 
				parametri.get("nome"), 
				parametri.get("cognome"), 
				parametri.get("idteam"), 
				parametri.get("id"));
	}
	
	public boolean delete(HashMap<String, String> parametri) {
		String query = "delete from PLAYERS where id = ?";
		return update(query, parametri.get("id"));
	}

}
