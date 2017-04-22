package co.simplon.laposte.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nom")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotEmpty(message = "Le champ 'nom' ne peut pas être vide")	
	private String nom;
	
	@UpdateTimestamp
	private Timestamp derniereMaj;
	
	//@JsonBackReference
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<Utilisateur> utilisateurs;	
//	
	public Role() {
		
	}

	public Role(String nom) {
		super();
		this.nom = nom;
	}	
}
