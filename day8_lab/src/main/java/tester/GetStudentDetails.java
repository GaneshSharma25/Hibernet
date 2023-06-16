package tester;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class GetStudentDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) // invoking static method -->
		// cls loading --> static init block --> configure : entire hib frmwork loaded
		{
			//create dao instance
			StudentDaoImpl dao=new StudentDaoImpl();
			System.out.println("Enter email and Password");
			
			System.out.println(dao.loginStudent(sc.next(),sc.next()));
			
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
