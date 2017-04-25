package co.simplon.laposte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.laposte.dao.UtilisateurDAO;
import co.simplon.laposte.model.Role;
import co.simplon.laposte.model.Utilisateur;

@Service
@Transactional
public class UtilisateurService {

	@Autowired
	private UtilisateurDAO dao;	

	public List<Utilisateur> findAll() {
		Iterable<Utilisateur> requete = dao.findAll();
		List<Utilisateur> resultat = new ArrayList<>();		
		for (Utilisateur utilisateur : requete) {
			Utilisateur temp = new Utilisateur();
			temp.setId(utilisateur.getId());
			temp.setPseudo(utilisateur.getPseudo());
			temp.setRoles(new ArrayList<>());
			for (Role role : utilisateur.getRoles()) {
				Role tempRole = new Role();
				tempRole.setId(role.getId());
				tempRole.setNom(role.getNom());
				temp.getRoles().add(tempRole);
			}			
			resultat.add(temp);
		}
		return resultat;
	}	
	
	public Utilisateur getUser(String pseudo) {
		return dao.findByPseudo(pseudo);
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
	
	public List<Utilisateur> selectByRole(long id) {
		Iterable<Utilisateur> requete = dao.findByRolesId(id);
		List<Utilisateur> resultat = new ArrayList<>();
		for (Utilisateur utilisateur : requete) {
			Utilisateur temp = new Utilisateur();
			temp.setId(utilisateur.getId());
			temp.setPseudo(utilisateur.getPseudo());
			resultat.add(temp);
		}
		return resultat;
	}	
	
	public Utilisateur login(String pseudo, String motDePasse) {
		return dao.findByPseudoAndMotDePasse(pseudo, motDePasse);
	}
}
