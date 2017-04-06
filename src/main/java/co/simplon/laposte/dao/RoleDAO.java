package co.simplon.laposte.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.simplon.laposte.model.Role;
@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
	
	public Role findById(long id);

}
