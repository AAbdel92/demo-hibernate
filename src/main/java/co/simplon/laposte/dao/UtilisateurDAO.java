package co.simplon.laposte.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.laposte.model.Utilisateur;

@Repository
public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long>{

	public Utilisateur findById(long id);
	public Utilisateur findByPseudo(String pseudo);
	public void deleteByPseudo(String pseudo);
	@Query("select pseudo from Utilisateur")
	public List<String> findPseudo();
	public Utilisateur roles(Utilisateur utilisateur);
	public Iterable<Utilisateur> findByRolesId(long id);
	
	public Utilisateur findByPseudoAndMotDePasse(String pseudo, String motDePasse);
}
