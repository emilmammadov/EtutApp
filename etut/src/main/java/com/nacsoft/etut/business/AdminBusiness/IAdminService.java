package com.nacsoft.etut.business.AdminBusiness;

import java.util.List;

import com.nacsoft.etut.Entities.Admin;
import com.nacsoft.etut.Entities.Ogrenci;
import com.nacsoft.etut.Entities.Ogretmen;

public interface IAdminService {
	
	List<Admin> getAll();
	void addTeacher(Ogretmen ogretmen);
	void addStudent(Ogrenci ogrenci);
	void delateTeacher(Ogretmen ogretmen);
	void delateStudent(Ogrenci ogrenci);
	void update(Admin admin);	
	Admin getById(int id);

}
