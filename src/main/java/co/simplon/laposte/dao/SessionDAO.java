package co.simplon.laposte.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.laposte.model.Session;

@Repository
public interface SessionDAO extends CrudRepository<Session, Long> {

}
