package com.nacsoft.etut.dataAccess.StudentDal;

import java.util.List;

import com.nacsoft.etut.Entities.Ogrenci;

public interface IStudentDal {
	
	List<Ogrenci> getAll();
	void add(Ogrenci ogrenci);
	void update(Ogrenci ogrenci);
	void delate(Ogrenci ogrenci);

}


