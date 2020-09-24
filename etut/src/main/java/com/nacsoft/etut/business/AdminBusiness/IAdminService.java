package com.nacsoft.etut.business.AdminBusiness;

import java.util.List;

import com.nacsoft.etut.Entities.Admin;
import com.nacsoft.etut.Entities.Student;
import com.nacsoft.etut.Entities.Teacher;

public interface IAdminService {
	
	List<Admin> getAll();
	void addTeacher(Teacher ogretmen);
	void addStudent(Student ogrenci);
	void delateTeacher(Teacher ogretmen);
	void delateStudent(Student ogrenci);
	void update(Admin admin);	
	Admin getById(int id);
	Admin login(Admin admin);

}
