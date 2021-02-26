package com.etut.restApi;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etut.Entities.Program;

@RestController
@RequestMapping("/program")
@CrossOrigin(origins = "http://localhost:4200")
@Component
public class ProgramController {
	
	private EntityManager entityManager;
	
	@Autowired
	public ProgramController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public boolean isExist(int ogretmenId, Timestamp start, Timestamp end) {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Program> query = session.createQuery(
			"from Program where ogretmenId = "+ogretmenId+" AND "
		  + "((randevuStart >= :start AND randevuStart <= :end) OR "
		  + "(randevuEnd >= :start AND randevuEnd <= :end) OR "
		  + "(randevuStart <= :start AND randevuEnd >= :end))"
				, Program.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		List<Program> programs = query.getResultList();
		if (programs.size() > 0) return true;
		else return false;
	}
	
	@PostMapping("/add")
	public boolean addProgram(@RequestBody Program program) {
		Session session = entityManager.unwrap(Session.class);
		boolean isExist = isExist(program.getOgretmenId(), program.getRandevuStart(), program.getRandevuEnd());
		if (isExist) return false;
		else {
			session.save(program);
			return true;
		}
	}
	
	@PostMapping("/student-approved")
	public List<Program> getStudentApproved(@RequestBody int ogrenciId) {
		Session session = entityManager.unwrap(Session.class);
		List<Program> programs = session.createQuery("from Program where status=1 AND ogrenciId="+ogrenciId, Program.class).getResultList();
		return programs;
	}
	
	@PostMapping("/teacher-wait")
	public List<Program> getTeacherWait(@RequestBody int teacherId) {
		Session session = entityManager.unwrap(Session.class);
		List<Program> programs = session.createQuery("from Program where status=0 AND ogretmenId="+teacherId, Program.class).getResultList();
		return programs;
	}
	
	@PostMapping("/teacher-approved")
	public List<Program> getTeacherApproved(@RequestBody int teacherId) {
		Session session = entityManager.unwrap(Session.class);
		List<Program> programs = session.createQuery("from Program where status=1 AND ogretmenId="+teacherId, Program.class).getResultList();
		return programs;
	}
	
	@Transactional
	@PostMapping("/delete")
	public void deleteProgram(@RequestBody int id) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("DELETE from Program where programId="+id).executeUpdate();
	}
	
	@Transactional
	@PostMapping("/approve")
	public void approveProgram(@RequestBody int id) {
		Session session = entityManager.unwrap(Session.class);
		session.createQuery("UPDATE Program SET status=1 where programId="+id).executeUpdate();
	}
	
	
}
