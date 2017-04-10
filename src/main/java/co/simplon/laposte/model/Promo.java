package co.simplon.laposte.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nom")
public class Promo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom;
	
	@UpdateTimestamp
	private Timestamp derniereMaj;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promo")
	private List<Utilisateur> utilisateurs;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promo")
	private List<Session> sessions;
}
