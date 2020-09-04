package com.etut.etutapp.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etut.etutapp.DataAccess.IAdminLogin;
import com.etut.etutapp.Entities.Admin;

@Service      // bu bir iş katmanıdır demek için
public class AdminMenager implements IAdminService {
	
	private IAdminLogin adminLogin;
	
	
	@Autowired
	public AdminMenager(IAdminLogin adminLogin) {
		this.adminLogin = adminLogin;
	}

	@Override
	@Transactional
	public List<Admin> getAll() {
		return this.adminLogin.getAll();
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

}
