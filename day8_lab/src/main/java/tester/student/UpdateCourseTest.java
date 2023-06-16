package tester.student;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class UpdateCourseTest {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in) ){
			
			StudentDaoImpl student = new StudentDaoImpl();
			System.out.println("Enter StudentID and New Course name..");
			String res = student.updateCourse(sc.nextInt(), Course.valueOf(sc.next()));
			System.out.println(res);
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}

	}

}
