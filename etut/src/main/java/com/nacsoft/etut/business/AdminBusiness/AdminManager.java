package com.nacsoft.etut.business.AdminBusiness;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nacsoft.etut.Entities.Admin;
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
		return this.adminDal.getAll();
	}

	@Override
	@Transactional
	public void add(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void delate(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
