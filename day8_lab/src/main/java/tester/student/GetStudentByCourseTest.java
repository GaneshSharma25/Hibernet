package tester.student;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.*;

import java.util.Scanner;

public class GetStudentByCourseTest {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {

			StudentDaoImpl std = new StudentDaoImpl();
			System.out.println("Enter Course name..");
			//Course.valueOf(sc.next().toUpperCase())
			std.getStudentsByCourse(Course.valueOf(sc.next().toUpperCase())).forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
