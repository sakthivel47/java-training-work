package studentmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import studentmanagementsystem.exceptions.DataNotPresentException;
import studentmanagementsystem.exceptions.StudentNotFoundException;
import studentmanagementsystem.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private static List<Student> studentList = new ArrayList<Student>();

	@Override
	public String addStudent(Student student) throws DataNotPresentException {
		if(student != null) {
			studentList.add(student);
			return "Student with student id " + student.getId() + " added successfully";
		} else {
			throw new DataNotPresentException("Data not present!");
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return studentList;
	}
	
	@Override
	public List<Student> getStudentByCity(String city) {
		return studentList;
	}

	@Override
	public List<Student> sortStudentsByName() {
		return studentList;
	}

	@Override
	public List<Student> sortStudentsByCity() {
		return studentList;
	}

	@Override
	public Student displayStudent(Integer id) throws StudentNotFoundException {
		for(Student student : studentList) {
			if(student.getId() == id) {
				return student;
			}
		}
		throw new StudentNotFoundException("Student with id " + id + " doesn't exists");
	}

}
