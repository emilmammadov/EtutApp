package com.nacsoft.etut.business.StudentBusiness;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nacsoft.etut.Entities.Student;
import com.nacsoft.etut.dataAccess.StudentDal.IStudentDal;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentManager implements IStudentService {
	
	private IStudentDal studentDal;
	
	public StudentManager(IStudentDal studentDal) {
		this.studentDal = studentDal;
	}
	
	@Override
	public Student login(Student student) {
		return this.studentDal.login(student);
	}
	
	@Override
	@Transactional
	public List<Student> getAll() {
		// iş kuralları yazılacak, if kontrolleri falan
		return this.studentDal.getAll();
	}

}
