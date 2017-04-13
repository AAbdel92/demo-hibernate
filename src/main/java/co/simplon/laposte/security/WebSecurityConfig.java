package co.simplon.laposte.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	
	@Autowired
	private RESTAuthenticationEntryPoint authEntryPoint;
	@Autowired
	private RESTAuthenticationSuccessHandler authSuccessHandler;
	@Autowired
	private RESTAuthenticationFailureHandler authFailHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeRequests().antMatchers("/api/**").authenticated();
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(authEntryPoint);
		http.formLogin().successHandler(authSuccessHandler);
        http.formLogin().failureHandler(authFailHandler);
			
	}	
	
	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/styles/**")
//						.antMatchers("/scripts/**")
//						.antMatchers("/webjars/**");
//	}
	
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
	
}
