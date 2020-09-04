package com.etut.etutapp.Business;

import java.util.List;

import com.etut.etutapp.Entities.Admin;

public interface IAdminService {
	
	List<Admin> getAll();
	void add(Admin admin);
	void update(Admin admin);
	void delate(Admin admin);

}
