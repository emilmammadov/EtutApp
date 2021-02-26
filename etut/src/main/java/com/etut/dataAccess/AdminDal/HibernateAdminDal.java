package com.etut.dataAccess.AdminDal;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.etut.Entities.Admin;
import com.etut.Entities.Student;
import com.etut.Entities.Teacher;

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
	public void addTeacher(Teacher ogretmen) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ogretmen);
		
	}
	
	@Override
	public void addStudent(Student ogrenci) {
		Session session = entityManager.unwrap(Session.class);
		session.save(ogrenci);
		
	}
	
	@Override
	public void delateTeacher(Teacher ogretmen) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(ogretmen);
		
	}


	@Override
	public void delateStudent(Student ogrenci) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(ogrenci);
		
	}

	

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public Admin getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Admin admin = session.get(Admin.class, id);
		return admin;
	}


	@Override
	public Admin login(Admin admin) {
		Session session = entityManager.unwrap(Session.class);
		Admin admin2 = session.createQuery(
				"from Admin where username='" + admin.getUsername() + 
				"' and password='"+ admin.getPassword() +"'", Admin.class).uniqueResult();
		return admin2;
	}

}
