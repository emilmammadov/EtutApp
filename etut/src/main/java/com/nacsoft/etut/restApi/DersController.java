package com.nacsoft.etut.restApi;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacsoft.etut.Entities.Dersler;

@RestController
@RequestMapping("/ders")
@CrossOrigin(origins = "http://localhost:4200")
@Component
public class DersController {
	
	private EntityManager entityManager;
	
	@Autowired
	public DersController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@GetMapping("/all")
	public List<Dersler> getAll() {
		Session session = entityManager.unwrap(Session.class);   // bir hibernate sessionu ver diyoruz
		List<Dersler> dersler = session.createQuery("from Dersler", Dersler.class).getResultList();
		return dersler;
	}
	
}
