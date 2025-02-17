package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import service.DepartmentService;
import service.Menu;
import service.SellerService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		SellerService sellerService = new SellerService(sellerDao);
		DepartmentService departmentService = new DepartmentService(departmentDao);
		
		while(true) {
			Menu.showMenu();
			int choice = Menu.getUserChoice(sc);
			
			switch(choice) {
				case 1: sellerService.listAllSellers(); break;
				case 2: sellerService.findSellerById(sc); break;
				case 3: sellerService.findSellersByDepartment(sc); break;
				case 4: sellerService.createSeller(sc); break;
				case 5: sellerService.updateSeller(sc); break;
				case 6: sellerService.deleteSeller(sc); break;
				case 7: departmentService.createDepartment(sc); break;
				case 8: departmentService.listAllDepartments(); break;
				case 9: departmentService.updateDepartment(sc); break;
				case 10: departmentService.findDepartmentById(sc); break;
				case 11: Menu.exitProgram(sc); return;
				default: System.out.println("Invalid choice!"); break;
			}
		}
	}
}
