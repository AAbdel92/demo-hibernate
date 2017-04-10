package co.simplon.laposte.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom;
	
	@UpdateTimestamp
	private Timestamp derniereMaj;
	
	@ManyToOne
	@JoinColumn(name = "promo_id")
	private Promo promo;

}
