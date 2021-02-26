package com.etut.dataAccess.StudentDal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etut.Entities.Student;

@Component
public class HibernateStudentDal implements IStudentDal {
	
	private EntityManager entityManager; 
	
	@Autowired
	public HibernateStudentDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> getAll() {
		Session session = entityManager.unwrap(Session.class);   // bir hibernate sessionu ver diyoruz
		List<Student> students = session.createQuery("from Student", Student.class).getResultList();
		return students;
	}

	@Override
	public void add(Student ogrenci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student ogrenci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delate(Student ogrenci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student login(Student student) {
		Session session = entityManager.unwrap(Session.class);
		Student student2 = session.createQuery(
				"from Student where username='" + student.getUsername() + 
				"' and password='"+ student.getPassword() +"'", Student.class).uniqueResult();
		return student2;
	}

}
