package service;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {

	private DepartmentDao departmentDao;

	public DepartmentService(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public void createDepartment(Scanner sc) {
		System.out.println();
		System.out.print("Enter the name for new Department: ");
		String name = sc.nextLine();
		Department department = new Department(null, name);
		departmentDao.insert(department);
		System.out.println("Department created " + department.getName());
		System.out.println("New department Id " + department.getId());
	}
	
	public void listAllDepartments() {
		System.out.println();
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
	}

}
