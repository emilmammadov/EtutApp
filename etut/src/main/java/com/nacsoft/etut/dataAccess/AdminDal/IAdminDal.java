package com.nacsoft.etut.dataAccess.AdminDal;

import java.util.List;
import com.nacsoft.etut.Entities.Admin;

public interface IAdminDal {
	
	List<Admin> getAll();
	void add(Admin admin);
	void update(Admin admin);
	void delate(Admin admin);
	Admin getByUsername(String username);

}

