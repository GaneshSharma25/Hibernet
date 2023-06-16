package tester.student;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDao;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class AddStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) // invoking static method -->
		// cls loading --> static init block --> configure : entire hib frmwork loaded
		{
			// create student dao instance
			StudentDao dao = new StudentDaoImpl();
			System.out.println("Enter student details : firstName, "
					+ " lastName,  email,  password,  enrolledCourse, dob");
			Student newStudent = new Student(sc.next(), 
					sc.next(), sc.next(), sc.next(),
					Course.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
			System.out.println(dao.registerNewStudent(newStudent));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
