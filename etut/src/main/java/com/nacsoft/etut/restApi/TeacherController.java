package com.nacsoft.etut.restApi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacsoft.etut.Entities.Program;
import com.nacsoft.etut.Entities.Teacher;
import com.nacsoft.etut.business.TeacherBusiness.ITeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	
	@Autowired     // sadece bir sınıf kullanıyor diye hu şekilde, yoksa ayrı sınıf ile yapılması lazım
	private ITeacherService teacherService;

	public TeacherController(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@GetMapping("/all")
	public List<Teacher> get(){
		return teacherService.getAll();
		
	}
	
	@GetMapping("/randevu-olustur")
	public List<Program> onaylanmisDersler(){
		return teacherService.onaylanmisDersler();
	}
	
	@PostMapping("/login")
	public Teacher login(@RequestBody Teacher teacher) {
		return teacherService.login(teacher);
	}

}
