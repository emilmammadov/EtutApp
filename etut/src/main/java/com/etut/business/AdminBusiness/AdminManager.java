package com.etut.business.AdminBusiness;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etut.Entities.Admin;
import com.etut.Entities.Student;
import com.etut.Entities.Teacher;
import com.etut.dataAccess.AdminDal.IAdminDal;

@Service
public class AdminManager implements IAdminService {
	
	private IAdminDal adminDal;

	@Autowired
	public AdminManager(IAdminDal adminDal) {
		this.adminDal = adminDal;
	}

	@Override
	@Transactional
	public List<Admin> getAll() {
		// iş kuralları yazılacak, if kontrolleri falan
		return this.adminDal.getAll();
	}

	@Override
	@Transactional
	public void addTeacher(Teacher ogretmen) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.addTeacher(ogretmen);
		
	}

	@Override
	@Transactional
	public void addStudent(Student ogrenci) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.addStudent(ogrenci);
		
	}

	@Override
	@Transactional
	public void delateTeacher(Teacher ogretmen) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.delateTeacher(ogretmen);
		
	}

	@Override
	@Transactional
	public void delateStudent(Student ogrenci) {
		
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.delateStudent(ogrenci);
		
	}
	
	@Override
	@Transactional
	public void update(Admin admin) {
		// TODO Auto-generated method stub

	}
	
	@Override
	@Transactional
	public Admin getById(int id) {
		// iş kuralları yazılacak, if kontrolleri falan
		return this.adminDal.getById(id);
	}

	@Override
	public Admin login(Admin admin) {
		return this.adminDal.login(admin);
	}

}
