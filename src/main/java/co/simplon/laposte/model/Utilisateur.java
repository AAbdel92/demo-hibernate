package co.simplon.laposte.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.access.prepost.PreAuthorize;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pseudo")

public class Utilisateur {
	
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Le champ 'pseudo' ne peut pas être vide")
	private String pseudo;
	
	@NotEmpty(message = "Le champ 'mot de passe' ne peut pas être vide")
	private String motDePasse;
	
	@NotEmpty(message = "Le champ 'email' ne peut pas être vide")
	private String email;
	
	@UpdateTimestamp
	private Timestamp derniereMaj;
	
	@ManyToOne
	@JoinColumn(name = "promo_id")
	private Promo promo;
	
	//@JsonManagedReference
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="utilisateur_role", joinColumns = {
			@JoinColumn(name = "utilisateur_id")},inverseJoinColumns = {@JoinColumn(name ="role_id")
			})
	private List<Role> roles;	
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String identifiant, String motDePasse, String email) {
		super();
		this.pseudo = identifiant;
		this.motDePasse = motDePasse;
		this.email = email;		
	}		
}
