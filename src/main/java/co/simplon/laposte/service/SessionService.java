package co.simplon.laposte.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.laposte.dao.SessionDAO;
import co.simplon.laposte.model.Session;

@Service
@Transactional
public class SessionService {
	
	@Autowired
	private SessionDAO dao;
	
	public Iterable<Session> findAll() {
		return dao.findAll();
	}

}
