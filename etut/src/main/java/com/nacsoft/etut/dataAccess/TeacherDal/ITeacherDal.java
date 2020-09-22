package com.nacsoft.etut.dataAccess.TeacherDal;

import java.util.List;
import com.nacsoft.etut.Entities.Program;

public interface ITeacherDal {
	
	List<Program> getAll();
	void add(Program program);
	void update(Program program);
	void delate(Program program);
	Program getByStatus(String statu);

}
