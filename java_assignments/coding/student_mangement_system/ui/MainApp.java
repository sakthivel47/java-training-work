package studentmanagementsystem.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import studentmanagementsystem.exceptions.DataNotPresentException;
import studentmanagementsystem.exceptions.StudentNotFoundException;
import studentmanagementsystem.model.Student;
import studentmanagementsystem.service.StudentService;
import studentmanagementsystem.service.StudentServiceImpl;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// create student objects
		System.out.println("**********Adding student**********");
		Student stud1 = new Student(1, "MS Dhoni", "Ranchi");
		Student stud2 = new Student(2,"SKY","Lucknow");
		Student stud3 = new Student(3,"R Ashwin","Chennai");
		Student stud4 = new Student(4,"Ishan Kishan","Patna");
		Student stud5 = new Student(5,"Virat Kohli","New Delhi");
		Student stud6 = new Student(6,"Rohit Sharma","New Delhi");
		Student stud7 = new Student(7,"Irfan Pathan","Ahmedabad");
		Student stud8 = new Student(8,"Yusuf Patha","Ahmedabad");
		Student stud9 = new Student(9,"Sorauv Ganguly","Kolkata");
		Student stud10 = new Student(10,"Sunil Gavaskar","Mumbai");
		Student stud11 = new Student(11,"Ishant Sharma","New Delhi");
		Student stud12 = new Student(12,"Mohammed Kaif","Muradabad");
		Student stud13 = new Student(13,"Kapil Dev","Chandigarh");

		// create a list and add all students to the list
		List<Student> studentsList = Arrays.asList(stud1, stud2, stud3, stud4, stud5,
				stud6, stud7, stud8, stud9, stud10, stud11, stud12, stud13);
		
		// create StudentService object
		StudentService studentService = new StudentServiceImpl();

		// add students to the database and catch exception if found
		for(Student student: studentsList) {
			try {
				System.out.println(studentService.addStudent(student));
			} catch (DataNotPresentException e) {
				e.getMessage();
			}
		}

		System.out.println();
		System.out.println("****************MENU DRIVER****************");
		// menu driver
		char run = 'y';
		do {
			System.out.print(""
					+ "1. Read all student\n"
					+ "2. Display all the student belong to a particular city\n"
					+ "3. Display name wise sorted\n"
					+ "4. Display city wise sorted.\r\n"
					+ "5. Display student details with id\n"
					+ "Enter your choice: ");

			int option = sc.nextInt();
			switch(option) {
			case 1:
			{
				System.out.println();
				System.out.println("**********Students List**********");
				for(Student student : studentService.getAllStudents()) {
					System.out.println(student);
				}
				System.out.println();
				break;
			}
			case 2:
			{
				System.out.print("Enter city: ");
				String city = sc.next();

				System.out.println();
				System.out.println("*********Students from " + city + "*********");
				try {
					for(Student student : studentService.getStudentByCity(city)) {
						System.out.println(student);
					}
				} catch (StudentNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 3:
			{
				System.out.println();
				System.out.println("*********Students list sorted by name*********");
				for(Student student : studentService.sortStudentsByName()) {
					System.out.println(student);
				}
				break;
			}
			case 4:
			{
				System.out.println();
				System.out.println("*********Students list sorted by name*********");
				for(Student student : studentService.sortStudentsByCity()) {
					System.out.println(student);
				}
				break;
			}
			case 5:
			{
				System.out.println();
				System.out.println("Get student detail by ID: ");
				System.out.print("Enter Student ID: ");
				int id = sc.nextInt();
				System.out.println("************************************");
				try {
					Student student = studentService.displayStudent(id);
					System.out.println(student);
				} catch (StudentNotFoundException e) {
					System.out.println(e.getMessage());;
				}
				break;
			}
			default:
				System.out.println("Invlaid option!");
			}
			
			System.out.print("Do you want to continue? (y/N) ");
			run = sc.next().charAt(0);

		}while(run == 'y' || run == 'Y');

		sc.close();
	}
}
