package com.nacsoft.etut.business.AdminBusiness;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nacsoft.etut.Entities.Admin;
import com.nacsoft.etut.Entities.Ogrenci;
import com.nacsoft.etut.Entities.Ogretmen;
import com.nacsoft.etut.dataAccess.AdminDal.IAdminDal;

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
	public void addTeacher(Ogretmen ogretmen) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.addTeacher(ogretmen);
		
	}

	@Override
	@Transactional
	public void addStudent(Ogrenci ogrenci) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.addStudent(ogrenci);
		
	}

	@Override
	@Transactional
	public void delateTeacher(Ogretmen ogretmen) {
		// iş kuralları yazılacak, if kontrolleri falan
		this.adminDal.delateTeacher(ogretmen);
		
	}

	@Override
	@Transactional
	public void delateStudent(Ogrenci ogrenci) {
		
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

}
