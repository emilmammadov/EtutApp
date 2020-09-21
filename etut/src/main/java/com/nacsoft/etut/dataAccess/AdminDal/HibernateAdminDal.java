package com.nacsoft.etut.dataAccess.AdminDal;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.nacsoft.etut.Entities.Admin;

@Component
public class HibernateAdminDal implements IAdminDal {

private EntityManager entityManager;
	
	@Autowired                 // otomatik olarak hibernate injection gerçekleştirecek
	public HibernateAdminDal(EntityManager entityManager) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delate(Admin admin) {
		// TODO Auto-generated method stub

	}

}
