package co.simplon.laposte.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.laposte.dao.UtilisateurDAO;
import co.simplon.laposte.model.Utilisateur;

@Service
@Transactional
public class UtilisateurService {

	@Autowired
	private UtilisateurDAO dao;	

	public Map<Long, String> findAll() {
		Iterable<Utilisateur> resultat = dao.findAll();
		Map<Long, String> map = new HashMap<>();
		for (Utilisateur utilisateur : resultat) {
			map.put(utilisateur.getId(), utilisateur.getPseudo());			
		}
		return map;
	}
	
	public List<String> findAllPseudo() {
		List<String> resultat = new ArrayList<>();
		Utilisateur user = new Utilisateur();
		Iterable<Utilisateur> select = dao.findAll();
		for (Utilisateur utilisateur : select) {
			user.setPseudo(utilisateur.getPseudo());
			resultat.add(user.getPseudo());
		}
		return resultat;
	}
	
	public List<String> findPseudo() {		
		return dao.findPseudo();
	}
	
	public Utilisateur findById(long id) {
		return dao.findById(id);
	}
	
	public Utilisateur save(Utilisateur utilisateur) {
		return dao.save(utilisateur);
	}
	
	public void deleteByPseudo(Utilisateur utilisateur) {
		dao.deleteByPseudo(utilisateur.getPseudo());
	}
	
	public Utilisateur ajouterRole(Utilisateur utilisateur) {
		Utilisateur temp = dao.findByPseudo(utilisateur.getPseudo());
		temp.getRoles().add(utilisateur.getRoles().get(0));
		return dao.save(temp);
	}
	
	public Map<Long, String> selectByRole(long id) {
		Iterable<Utilisateur> resultat = dao.findByRolesId(id);
		Map<Long, String> map = new HashMap<>();
		for (Utilisateur utilisateur : resultat) {
			map.put(utilisateur.getId(), utilisateur.getPseudo());
		}
		return map;
	}
	
	public Utilisateur seConnecter(String pseudo, String motDePasse) {
		Utilisateur resultat = dao.findByPseudoAndMotDePasse(pseudo, motDePasse);
		return resultat;
	}
	
	
}
