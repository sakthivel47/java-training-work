package studentmanagementsystem.service;

import java.util.List;

import studentmanagementsystem.exceptions.DataNotPresentException;
import studentmanagementsystem.exceptions.StudentNotFoundException;
import studentmanagementsystem.model.Student;

public interface StudentService {
	
	/**
     * Description - Adds a new student to the system.
     * Parameters - student The student object to be added.
     * Return Value - A message indicating success or failure.
     * Throws - DataNotPresentException If required data is missing.
     */
	public String addStudent(Student student) throws DataNotPresentException;
	
	/**
     * Description - Retrieves a list of all students.
     * Return Value - A list of Student objects representing all students.
     */
	public List<Student> getAllStudents();
	
	/**
	 * Description - Retrieves a list of students from a specific city.
	 * Parameters - city The city name for filtering students.
	 * Return Value - A list of Student objects from the specified city.
	 */
	public List<Student> getStudentByCity(String city) throws StudentNotFoundException;
	
	/**
	 * Description - Sorts students by their names.
	 * Return Value - A sorted list of Student objects based on names.
	 */
	public List<Student> sortStudentsByName();
	
	/**
     * Description - Sorts students by their city.
     * Return Value - A sorted list of Student objects based on city.
     */
	public List<Student> sortStudentsByCity();
	
	/**
     * Description - Displays student details for a given ID.
     * Parameters id The unique identifier for the student.
     * Return Value - The Student object corresponding to the provided ID.
     * Throws - StudentNotFoundException If the student with the given ID is not found.
     */
	public Student displayStudent(Integer id) throws StudentNotFoundException;
}
