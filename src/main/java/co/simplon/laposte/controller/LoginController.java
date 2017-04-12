//package co.simplon.laposte.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import co.simplon.laposte.model.Utilisateur;
//import co.simplon.laposte.service.UtilisateurService;
//
//@RestController
//@RequestMapping(value = "/login")
//public class LoginController {
//	
//	@Autowired
//	private UtilisateurService service;
//	
//	
//	@PostMapping
//	public String seConnecter(@RequestParam(name="username") String pseudo, @RequestParam(name="password") String motDePasse) {
//		Utilisateur resultat = service.seConnecter(pseudo, motDePasse);
//		return resultat.getPseudo() + " connecté.";
//	}
//
//}
