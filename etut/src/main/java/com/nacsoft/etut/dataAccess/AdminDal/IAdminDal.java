package com.nacsoft.etut.dataAccess.AdminDal;

import java.util.List;
import com.nacsoft.etut.Entities.*;

public interface IAdminDal {
	
	List<Admin> getAll();
	void addTeacher(Ogretmen ogretmen);
	void addStudent(Ogrenci ogrenci);
	void delateTeacher(Ogretmen ogretmen);
	void delateStudent(Ogrenci ogrenci);
	void update(Admin admin);	
	Admin getById(int id);

}

