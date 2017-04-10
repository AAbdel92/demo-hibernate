package co.simplon.laposte.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.laposte.dao.PromoDAO;
import co.simplon.laposte.model.Promo;

@Service
@Transactional
public class PromoService {
	
	@Autowired
	private PromoDAO dao;
	
	public Map<Long, String> findAll() {
		Iterable<Promo> resultat = dao.findAll();
		Map<Long, String> map = new HashMap<>();
		for (Promo promo : resultat) {
			map.put(promo.getId(), promo.getNom());			
		}
		return map;
	}
	
	public Promo save(Promo promo) {
		return dao.save(promo);
	}
	
	public void delete(long id) {
		dao.delete(id);
	}
	
	public Promo findByNom(String nom) {
		return dao.findByNom(nom);
	}

}
