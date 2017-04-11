//package co.simplon.laposte.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import co.simplon.laposte.dao.UtilisateurDAO;
//import co.simplon.laposte.model.Utilisateur;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	private UtilisateurDAO dao;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		Iterable<Utilisateur> resultat = dao.findAll();
//		for (Utilisateur utilisateur : resultat) {
//			auth.inMemoryAuthentication()
//					.withUser(utilisateur.getPseudo())
//					.password(utilisateur.getMotDePasse());
//		}
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");
//	}
//	
//}
