package com.etut.dataAccess.AdminDal;

import java.util.List;

import com.etut.Entities.*;

public interface IAdminDal {
	
	List<Admin> getAll();
	void addTeacher(Teacher ogretmen);
	void addStudent(Student ogrenci);
	void delateTeacher(Teacher ogretmen);
	void delateStudent(Student ogrenci);
	void update(Admin admin);	
	Admin getById(int id);
	Admin login(Admin admin);

}

