package co.simplon.laposte.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.laposte.model.Role;
import co.simplon.laposte.service.RoleService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
		
	@GetMapping(value="listeRole")
	public ResponseEntity<?> findAll() {
		Map<Long, String> resultat;
		resultat = service.findAll();
		return ResponseEntity.ok(resultat);
	}
	
	@GetMapping(value="listeRole/{id}")
	public ResponseEntity<?> findbyId(@PathVariable long id) {
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value="/creerRole")	
	public ResponseEntity<?> save(@RequestBody Role role) {			
		Role resultat;
		resultat = service.save(role);
		return ResponseEntity.ok(resultat);
	}
}
