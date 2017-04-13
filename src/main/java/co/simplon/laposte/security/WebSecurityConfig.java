package co.simplon.laposte.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String loginUrl = "/login.html";
		String indexUrl = "/index.html";
		http.authorizeRequests()
				.antMatchers(loginUrl).permitAll()
				.antMatchers("/**").authenticated()
			.and()
			.csrf()
				.disable()
				.authorizeRequests()
			.and()
			.formLogin()
				.loginPage(loginUrl)
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl(indexUrl)
				.failureUrl(loginUrl)
			.and()
			.logout()
//				.clearAuthentication(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl(loginUrl)
				.deleteCookies("JSESSIONID")
//				.invalidateHttpSession(false)
//			.and()
			
//			.authorizeRequests()
//				.antMatchers(loginUrl).permitAll()
//				.antMatchers(indexUrl).denyAll()
//				.antMatchers("/admin/**").hasRole("ADMIN")
//			.anyRequest()
//				.authenticated()
				;
	}	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/styles/**")
						.antMatchers("/scripts/**")
						.antMatchers("/webjars/**");
	}
	
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
