package com.nacsoft.etut.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nacsoft.etut.Entities.Admin;
import com.nacsoft.etut.business.AdminBusiness.IAdminService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	private IAdminService adminService;
	
	@Autowired     // sadece bir sınıf kullanıyor diye hu şekilde, yoksa ayrı sınıf ile yapılması lazım
	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/admins")
	public List<Admin> get(){
		return adminService.getAll();
		
	}
	
	

}
