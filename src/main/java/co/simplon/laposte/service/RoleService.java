package co.simplon.laposte.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.laposte.dao.RoleDAO;
import co.simplon.laposte.model.Role;

@Service
@Transactional
public class RoleService {
	
	@Autowired 
	private RoleDAO dao;
	
	public Map<Long, String> findAll() {
		Iterable<Role> resultat = dao.findAll();
		Map<Long, String> map = new HashMap<>();
		for (Role role : resultat) {
			map.put(role.getId(), role.getNom());			
		}
		return map;
	}
	
	public Role findById(long id) {
		return dao.findById(id);
	}
	
	public Role save(Role role) {
		return dao.save(role);
	}

}
