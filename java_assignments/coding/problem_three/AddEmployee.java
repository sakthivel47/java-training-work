package problemtwo;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee {
	
	private static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static List<Employee> getEmployeeList() {
		return employeeList;
	}

	public static void setEmployeeList(List<Employee> employeeList) {
		AddEmployee.employeeList = employeeList;
	}

	public void AddEmployee(Employee emp) {
		employeeList.add(emp);
	}
	
	public Employee getEmployee(int id) {
		for(Employee employee : employeeList) {
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}
}
