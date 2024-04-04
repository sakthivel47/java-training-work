package studentmanagementsystem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import studentmanagementsystem.dao.StudentDAO;
import studentmanagementsystem.dao.StudentDAOImpl;
import studentmanagementsystem.exceptions.DataNotPresentException;
import studentmanagementsystem.exceptions.StudentNotFoundException;
import studentmanagementsystem.model.CityComparator;
import studentmanagementsystem.model.NameComparator;
import studentmanagementsystem.model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) throws DataNotPresentException {
		StudentDAO studentDAO = new StudentDAOImpl();
		String message = studentDAO.addStudent(student);
		return message;
	}

	@Override
	public List<Student> getStudentByCity(String city) throws StudentNotFoundException{
		StudentDAO studentDAO = new StudentDAOImpl();
		List<Student> studentsWithSameCity= new ArrayList<Student>();
		for(Student student: studentDAO.getAllStudents()) {
			if(student.getCity().equalsIgnoreCase(city)) {
				studentsWithSameCity.add(student);
			}
		}
		if(studentsWithSameCity != null && !studentsWithSameCity.isEmpty()) {
			return studentsWithSameCity;
		} else {
			throw new StudentNotFoundException("Students with city name " + city + " doesn't exists");
		}
	}

	@Override
	public List<Student> getAllStudents() {
		StudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.getAllStudents();
	}

	@Override
	public List<Student> sortStudentsByName() {
		StudentDAO studentDAO = new StudentDAOImpl();
		List<Student> studentsSortedByName = studentDAO.getAllStudents();
		Collections.sort(studentsSortedByName, new NameComparator());
		return studentsSortedByName;
	}

	@Override
	public List<Student> sortStudentsByCity() {
		StudentDAO studentDAO = new StudentDAOImpl();
		List<Student> studentsSortedByCity = studentDAO.getAllStudents();
		Collections.sort(studentsSortedByCity, new CityComparator());
		return studentsSortedByCity;
	}

	@Override
	public Student displayStudent(Integer id) throws StudentNotFoundException {
		StudentDAO studentDAO = new StudentDAOImpl();
		return studentDAO.displayStudent(id);
	}
}
