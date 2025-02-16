package service;

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
		System.out.println("Enter the name: ");
		String name = sc.nextLine();
		Department department = new Department(null, name);
		departmentDao.insert(department);
		System.out.println("Department created " + department.getName());
		System.out.println("New department Id " + department.getId());
	}

}
