package co.simplon.laposte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.laposte.model.Session;
import co.simplon.laposte.service.SessionService;

@RestController
@RequestMapping(value = "api/sessions")
public class SessionController {
	
	@Autowired
	private SessionService service;
	
	@GetMapping(value = "listeSessions")
	public Iterable<Session> findAll() {
		return service.findAll();
	}

}
