package co.simplon.laposte.security;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.simplon.laposte.dao.UtilisateurDAO;
import co.simplon.laposte.model.Role;
import co.simplon.laposte.model.Utilisateur;

@Configuration
public class GlobalWebSecurityConfig extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	private UtilisateurDAO dao;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());		
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			@Transactional
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Utilisateur utilisateur = dao.findByPseudo(username);				
				if (utilisateur != null) {
					String[] listeRole = listerNomRole(utilisateur.getRoles());

					return new User(utilisateur.getPseudo(),
									utilisateur.getMotDePasse(),
									true, true, true, true, 
									AuthorityUtils.createAuthorityList(Arrays.toString(listeRole).split("")));
				} else {
					throw new UsernameNotFoundException(username + " non trouvé.");
				}
			}
		};
	}
	
	private String[] listerNomRole(List<Role> listeRole) {
		String[] resultat = new String[listeRole.size()];
		
		for (Role role : listeRole) {
			resultat[listeRole.indexOf(role)] = role.getNom();
		}
		return resultat;
	}	
}
