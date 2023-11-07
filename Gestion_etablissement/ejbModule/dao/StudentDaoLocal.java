package dao;

import java.util.List;

import entities.Student;
import jakarta.ejb.Local;
@Local
public interface StudentDaoLocal extends IDaoLocal<Student>{
	public List<Student> findByFiliere(String name);
}
