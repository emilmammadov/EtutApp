package com.nacsoft.etut.business.StudentBusiness;

import org.springframework.stereotype.Service;

import com.nacsoft.etut.Entities.Student;
import com.nacsoft.etut.dataAccess.StudentDal.IStudentDal;

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

}
