package co.simplon.laposte.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.laposte.model.Utilisateur;
import co.simplon.laposte.service.UtilisateurService;

@RestController
@RequestMapping(value="api/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService service;	
	
	@GetMapping(value="listeUtilisateur")
	public ResponseEntity<?> findAll() {
		Map<Long, String> resultat;
		resultat = service.findAll();
		return ResponseEntity.ok(resultat);
	}
	
	@GetMapping(value="test")
	public ResponseEntity<?> findAllPseudo() {
		List<String> resultat;
		resultat = service.findAllPseudo();
		return ResponseEntity.ok(resultat);
	}
	
	@GetMapping(value="test1")
	public ResponseEntity<?> findPseudo() {
		List<String> resultat;
		resultat = service.findPseudo();
		return ResponseEntity.ok(resultat);
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
	public ResponseEntity<?> save(@RequestBody Utilisateur utilisateur) {			
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
	public ResponseEntity<?> ajouterRole(@RequestBody Utilisateur utilisateur) {
		Utilisateur resultat;
		resultat = service.ajouterRole(utilisateur);
		return ResponseEntity.ok(resultat
									.getRoles().get(resultat.getRoles().size()-1).getNom()
									+ "ajouté à " + resultat.getPseudo());
	}
	
	@GetMapping(value="chercherUtilisateur/{id}")
	public ResponseEntity<?> getUtilisateur(@PathVariable long id) {		
		Map<Long, String> resultat = service.selectByRole(id);
		return ResponseEntity.ok(resultat);
	}
}
 