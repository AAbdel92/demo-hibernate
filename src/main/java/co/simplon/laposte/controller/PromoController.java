package co.simplon.laposte.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.laposte.model.Promo;
import co.simplon.laposte.service.PromoService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value = "api/promo")
public class PromoController {
	
	@Autowired
	private PromoService service;
	
	@GetMapping(value = "listePromos")
	public Map<Long, String> findAll() {
		return service.findAll();
	}
	
	@PostMapping(value = "creerPromo")
	@ResponseBody
	private Promo save(@RequestBody Promo promo) {
		return service.save(promo);
	}
	
	@DeleteMapping(value = "supprimerPromo")
	private String delete(@RequestBody Promo promo) {
		Promo resultat = service.findByNom(promo.getNom());
		service.delete(resultat.getId());
		return promo.getNom() + " supprimée";
	}
	
}
