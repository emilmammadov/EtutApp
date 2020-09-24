package com.nacsoft.etut.dataAccess.TeacherDal;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nacsoft.etut.Entities.Program;
import com.nacsoft.etut.Entities.Teacher;

@Component
public class HibernateTeacherDal implements ITeacherDal {

	private EntityManager entityManager;
	
	
	@Autowired                 // otomatik olarak hibernate injection gerçekleştirecek
	public HibernateTeacherDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional      // AOP başında ve sonunda sessionu açar ve kapatır
	public List<Program> onaylanmisDersler() {
		Session session = entityManager.unwrap(Session.class);   // bir hibernate sessionu ver diyoruz
		List<Program> onaylanmisDersler = session.createQuery("from Program  p where p.onayDurumu=true", Program.class).getResultList();
		return onaylanmisDersler;
	}

	@Override
	@Transactional      // AOP başında ve sonunda sessionu açar ve kapatır
	public List<Program> bekleyenDersler() {
		Session session = entityManager.unwrap(Session.class);   // bir hibernate sessionu ver diyoruz
		List<Program> bekleyenDersler = session.createQuery("from Program p where p.onayDurumu=false", Program.class).getResultList();
		return bekleyenDersler;
	}

	@Override
	public void add(Program program) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Program program) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delate(Program program) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Teacher login(Teacher teacher) {
		Session session = entityManager.unwrap(Session.class);
		Teacher teacher2 = session.createQuery(
				"from Teacher where username='" + teacher.getUsername() + 
				"' and password='"+ teacher.getPassword() +"'", Teacher.class).uniqueResult();
		return teacher2;
	}

}
