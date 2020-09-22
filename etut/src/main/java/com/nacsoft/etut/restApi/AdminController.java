package com.nacsoft.etut.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nacsoft.etut.Entities.Admin;
import com.nacsoft.etut.Entities.Ogrenci;
import com.nacsoft.etut.Entities.Ogretmen;
import com.nacsoft.etut.business.AdminBusiness.IAdminService;

@RestController
@RequestMapping("/admin")
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
	
	@PostMapping("/ogrenciekle")
	public void ogrenciEkle(@RequestBody Ogrenci ogrenci) {
		adminService.addStudent(ogrenci);
	}
	
	@PostMapping("/ogrencisil")
	public void ogrenciSil(@RequestBody Ogrenci ogrenci) {
		adminService.delateStudent(ogrenci);
	}
	
	@PostMapping("/ogretmenekle")
	public void ogretmenEkle(@RequestBody Ogretmen ogretmen) {
		adminService.addTeacher(ogretmen);
	}
	
	@PostMapping("/ogretmensil")
	public void ogretmenSil(@RequestBody Ogretmen ogretmen) {
		adminService.delateTeacher(ogretmen);
	}
	
	@GetMapping("/adminlerilistele/{id}")
	public Admin getById(@PathVariable int id){
		return adminService.getById(id);
		
	}
	

}
