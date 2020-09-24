package com.nacsoft.etut.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nacsoft.etut.Entities.Student;
import com.nacsoft.etut.business.StudentBusiness.IStudentService;


@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired     // sadece bir sınıf kullanıyor diye hu şekilde, yoksa ayrı sınıf ile yapılması lazım
	private IStudentService studentService;
	
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	
	@PostMapping("/login")
	public Student login(@RequestBody Student student) {
		return studentService.login(student); 
	}
	
	

}
