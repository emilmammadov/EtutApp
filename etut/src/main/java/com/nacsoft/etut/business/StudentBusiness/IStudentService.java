package com.nacsoft.etut.business.StudentBusiness;

import java.util.List;

import com.nacsoft.etut.Entities.Student;

public interface IStudentService {
	Student login(Student student);
	List<Student> getAll();
	
}
