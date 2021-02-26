package com.etut.dataAccess.TeacherDal;

import java.util.List;

import com.etut.Entities.Program;
import com.etut.Entities.Teacher;

public interface ITeacherDal {
	
	List<Program> onaylanmisDersler();
	List<Program> bekleyenDersler();
	void add(Program program);
	void update(Program program);
	void delate(Program program);
	Teacher login(Teacher teacher);
	List<Teacher> getAll();

}
