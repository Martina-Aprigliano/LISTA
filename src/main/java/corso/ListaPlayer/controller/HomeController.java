package corso.ListaPlayer.controller;

import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import corso.ListaPlayer.database.PlayersDAO;
import corso.ListaPlayer.modelli.Player;

/*
 * Front Controller - Design Pattern
 * questi tipi di classe serviranno a gestire
 * REQUEST - richieste 
 * RESPONSE - risposte
 * quindi parliamo di architettura client server
 * ed andremo ad utilizzare il protocollo HTTP
 * HTTP ha dei VERBI o METODI - Get e Post
 * 
 * nel front controller andremo a preparare le possibili
 * request a cui il server dovra' rispondere.
 * 
 */

@Controller
public class HomeController {

	/*
	 * Sto creando un primo metodo home() che apre la pagina home.html
	 * per far in modo che il nostro server riponda ingaggiando questo metodo
	 * facciamo in modo che la request debba essere "/home" oltre a questo 
	 * diciamo al metodo che deve rispondere nel caso in cui il metodo con 
	 * cui e' arrivata la request sia un metodo GET
	 * 
	 * GET e' un metodo che serve per richiedere dati; 
	 * e' meno sicuro essendo che i dati vengono inviati come parametri nell'URL.
	 * POST e' un metodo che serve ad inviare i  dati; 
	 * e' piu' sicuro perche' i dati non saranno visibili nell'URL 
	 * perche' verranno inviati direttamente nel corpo della richista.
	 * 
	 */
	
	//localhost:8080/
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String home() {
		return "home.html";
	}
	
	//localhost:8080/players
	@RequestMapping(path="/players", method = RequestMethod.GET)
	public String players(Model model) {
		model.addAttribute("listaPlayers", PlayersDAO.getInstance().read());
		return "players.html";
	}
	
	//localhost:8080/addPlayers?nickname=pippo&nome=Mario&cognome=Rossi
	@RequestMapping(path = "/addPlayer", method = RequestMethod.POST)
	public String addPlayer(@RequestParam HashMap<String, String> parametri) {
		PlayersDAO.getInstance().create(parametri);
		return "redirect:/players";
	}
	
	@RequestMapping(path = "/modPlayer", method = RequestMethod.POST)
	public String modPlayer(@RequestParam HashMap<String, String> parametri) {
		PlayersDAO.getInstance().update(parametri);
		return "redirect:/players";
	}
	
	@RequestMapping(path = "/delPlayer", method = RequestMethod.POST)
	public String delPlayer(@RequestParam HashMap<String, String> parametri) {
		PlayersDAO.getInstance().delete(parametri);
		return "redirect:/players";
	}
	
}









