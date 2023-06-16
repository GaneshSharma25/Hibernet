package dao;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerNewStudent(Student student) {
		String mesg = "Registering student failed!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(student);
			tx.commit();
			mesg = "Student registered successfully with id=" + id;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String loginStudent(String email, String password) {
		Student std = null;
		String jpql = "select s from Student s where email = :em and password = :pass";
		// getSession from SessionFactory..
		Session session = getFactory().getCurrentSession();

		// begin a transaction...
		Transaction tx = session.beginTransaction();

		try {
			std = session.createQuery(jpql, Student.class).setParameter("em", email).setParameter("pass", password)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return std.toString();
	}
	
//	3. Get all students from a specific course
//	i/p : course name
//	Display list of students from the course
//	Hint : jpql ,createQuery , setParam: 1, getResultList
	
	
	
	public List<Student> getStudentsByCourse(Course course){
		
		List<Student> students = null;
		String jpql = "select s from Student s where enrolledCourse = :course";
		//get Session 
		Session session = getFactory().getCurrentSession();	
		//start transaction	
		Transaction tx = session.beginTransaction();
		
		try {
			students = session.createQuery(jpql, Student.class).setParameter("course", course).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		
		return students;
	}
	
//	4. Change course
//	i/p : student id(int) , course name
//	o/p : in case of invalid id --error mesg
//	in case of success : course updation message
//	Hint : session.get(...) -->null chking --not null --> persistent student
//	set new course
	
	
	public String updateCourse(int studentId, Course courseName) {
		
		String message = "Course Update Failed..";
		Student std = null;
		String jpql = "select s from Student s where studentId = :stdId";
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
		    std = session.createQuery(jpql, Student.class).setParameter("stdId", studentId).getSingleResult();
			std.setEnrolledCourse(courseName);
			tx.commit();
			message = "Course Update Successfull..."+std.getFirstName() +" - "+std.getEnrolledCourse();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
		}	
		return message;
		
	}
	
	
	
	
	
	
	
	
	

}
