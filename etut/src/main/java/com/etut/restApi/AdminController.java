package com.etut.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etut.Entities.Admin;
import com.etut.Entities.Student;
import com.etut.Entities.Teacher;
import com.etut.business.AdminBusiness.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	private IAdminService adminService;
	
	@Autowired     // sadece bir sınıf kullanıyor diye hu şekilde, yoksa ayrı sınıf ile yapılması lazım
	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/adminlerilistele")
	public List<Admin> get(){
		return adminService.getAll();
		
	}
	
	@PostMapping("/login")
	public Admin login(@RequestBody Admin admin) {
		return adminService.login(admin);
	}
	
	@PostMapping("/ogrenciekle")
	public void ogrenciEkle(@RequestBody Student ogrenci) {
		adminService.addStudent(ogrenci);
	}
	
	@PostMapping("/ogrencisil")
	public void ogrenciSil(@RequestBody Student ogrenci) {
		adminService.delateStudent(ogrenci);
	}
	
	@PostMapping("/ogretmenekle")
	public void ogretmenEkle(@RequestBody Teacher ogretmen) {
		adminService.addTeacher(ogretmen);
	}
	
	@PostMapping("/ogretmensil")
	public void ogretmenSil(@RequestBody Teacher ogretmen) {
		adminService.delateTeacher(ogretmen);
	}
	
	@GetMapping("/adminlerilistele/{id}")
	public Admin getById(@PathVariable int id){
		return adminService.getById(id);
		
	}
	

}
