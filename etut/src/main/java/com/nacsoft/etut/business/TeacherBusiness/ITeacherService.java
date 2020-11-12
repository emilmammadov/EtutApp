package com.nacsoft.etut.business.TeacherBusiness;

import java.util.List;
import com.nacsoft.etut.Entities.Program;
import com.nacsoft.etut.Entities.Teacher;

public interface ITeacherService {
	
	List<Program> onaylanmisDersler();
	List<Program> bekleyenDersler();
	void add(Program program);
	void update(Program program);
	void delate(Program program);
	Teacher login(Teacher teacher);
	List<Teacher> getAll();

}
