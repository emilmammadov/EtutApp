package com.etut.business.StudentBusiness;

import java.util.List;

import com.etut.Entities.Student;

public interface IStudentService {
	Student login(Student student);
	List<Student> getAll();
	
}
