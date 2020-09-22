package com.nacsoft.etut.business.AdminBusiness;

import java.util.List;

import com.nacsoft.etut.Entities.Admin;

public interface IAdminService {
	
	List<Admin> getAll();
	void add(Admin admin);
	void update(Admin admin);
	void delate(Admin admin);
	Admin getById(int id);

}
