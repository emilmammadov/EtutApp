package com.etut.etutapp.DataAccess;

import java.util.List;

import com.etut.etutapp.Entities.Admin;

public interface IAdminLogin {
	
	List<Admin> getAll();
	void add(Admin admin);
	void update(Admin admin);
	void delate(Admin admin);

}
