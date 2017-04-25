package co.simplon.laposte.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.laposte.model.Utilisateur;
import co.simplon.laposte.service.UtilisateurService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="api/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService service;	
	
	@GetMapping(value="listeUtilisateur")
	public List<Utilisateur> findAll() {				
		return service.findAll();
	}	
	
	@GetMapping(value="test1")
	public ResponseEntity<?> findPseudo() {
		List<String> resultat;
		resultat = service.findPseudo();
		return ResponseEntity.ok(resultat);
	}
	
	@GetMapping(value="getUser")
	public Utilisateur getUser(@RequestParam String pseudo) {
		return service.getUser(pseudo);
	}
	
	@GetMapping(value="listeUtilisateur/{id}")
	public ResponseEntity<?> findbyId(@PathVariable long id) {
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value="/creerUtilisateur")	
	public ResponseEntity<?> save(@Valid @RequestBody Utilisateur utilisateur) {			
		Utilisateur resultat;
		resultat = service.save(utilisateur);
		return ResponseEntity.ok(resultat);
	}
	
	@DeleteMapping(value="supprimerUtilisateur")
	public ResponseEntity<?> delete(@RequestBody Utilisateur utilisateur) {		
		service.deleteByPseudo(utilisateur);
		return ResponseEntity.ok(utilisateur.getPseudo() + " supprimé.");
	}
	
	@PostMapping(value="ajoutRole")
	public Utilisateur ajouterRole(@RequestBody Utilisateur utilisateur) {		
		return service.ajouterRole(utilisateur);
	}
	
	@GetMapping(value="chercherUtilisateur/{id}")
	public List<Utilisateur> getUtilisateur(@PathVariable long id) {		
		return service.selectByRole(id);
	}
	
	@PostMapping(value="login")
	public String login(@RequestParam(value="username") String pseudo, @RequestParam(value="password") String motDePasse) {
		Utilisateur temp = service.login(pseudo, motDePasse);
		String reponse;
		if (temp!=null) {
			reponse = "login réussi !";			
		} else {
			reponse = "login raté !";
		}
		return reponse;
	}
}
 