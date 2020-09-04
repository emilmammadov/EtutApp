package com.etut.etutapp.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etut.etutapp.Entities.Admin;
import lombok.AllArgsConstructor;

@Component
public class HibernateCityDal implements IAdminLogin {

	private EntityManager entityManager;
	
	@Autowired   // otomatik olarak hibernate injection gerçekleştirecek
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	@Transactional      // AOP başında ve sonunda sessionu açar ve kapatır
	public List<Admin> getAll() {
		Session session = entityManager.unwrap(Session.class);   // bir hibernate sessionu ver diyoruz
		List<Admin> admins = session.createQuery("from Admin", Admin.class).getResultList();
		return admins;
	}

	@Override
	public void add(Admin admin) {
		

	}

	@Override
	public void update(Admin admin) {
		

	}

	@Override
	public void delate(Admin admin) {
		

	}

}
