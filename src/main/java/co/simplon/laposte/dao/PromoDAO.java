package co.simplon.laposte.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.laposte.model.Promo;

@Repository
public interface PromoDAO extends CrudRepository<Promo, Long> {
	public Promo findByNom(String nom);
}
