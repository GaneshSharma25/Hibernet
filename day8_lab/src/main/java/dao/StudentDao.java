package dao;

import pojos.Student;

public interface StudentDao {
//add new student details
	String registerNewStudent(Student student);
	String loginStudent(String email,String password);
}
