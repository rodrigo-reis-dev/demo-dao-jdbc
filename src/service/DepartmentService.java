package service;

import java.util.List;
import java.util.Scanner;

import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

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
	
	public void findDepartmentById(Scanner sc) {
		System.out.println();
		System.out.print("Enter an ID to find a Department: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department dep  = departmentDao.findById(id);
		if (dep == null) {
			System.out.println("Department does not exist!");
		} else {
			System.out.println(dep);
		}
	}
	
	public void deleteDepartment(Scanner sc) {
		System.out.println();
		System.out.print("Enter the ID of the department to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Department departmentToDelete = departmentDao.findById(id);
		if (departmentToDelete == null) {
			System.out.println("Seller does not exist!");
		} else if(departmentDao.hasSellers(id)) {
			System.out.println("Cannot Delete, this department has sellers" );
			List<Seller> sellers = departmentDao.findSellersByDepartment(id);
			for(Seller seller : sellers) {
				System.out.println(seller);
			}
			
		} else {
			System.out.println("Deleting: " + departmentToDelete.getName());
			departmentDao.deleteById(id);
			System.out.println("Deletion completed.");
		}
	}
	
	public void updateDepartment(Scanner sc) {
		System.out.println();
		System.out.print("Enter the ID of Department: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Department department = departmentDao.findById(id);
		
		if (department == null) {
			System.out.println("Department does not exist!");
		} else {
			System.out.println("Current name: " + department.getName());
			System.out.print("Enter a new name: ");
			String newName = sc.nextLine();
			department.setName(newName);
			departmentDao.update(department);
			System.out.println("Seller updated: " + department);
		}
	} 

}
