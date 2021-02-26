package com.etut.dataAccess.StudentDal;

import java.util.List;

import com.etut.Entities.Student;

public interface IStudentDal {
	
	List<Student> getAll();
	void add(Student ogrenci);
	void update(Student ogrenci);
	void delate(Student ogrenci);
	Student login(Student teacher);

}


