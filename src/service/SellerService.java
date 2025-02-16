package service;

import java.util.List;
import java.util.Scanner;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerService {

	private SellerDao sellerDao;

	public SellerService(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}

	public void listAllSellers() {
		System.out.println();
		List<Seller> list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
	}

	public void findSellerById(Scanner sc) {
		System.out.println();
		System.out.print("Enter an ID to find a Seller: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(id);
		if (seller == null) {
			System.out.println("Seller does not exist!");
		} else {
			System.out.println(seller);
		}
	}

	public void findSellersByDepartment(Scanner sc) {
		System.out.println();
		System.out.print("Enter a department ID to find sellers: ");
		int id = sc.nextInt();
		sc.nextLine();
		Department department = new Department(id, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		if (list == null || list.isEmpty()) {
			System.out.println("No sellers found in this department.");
		} else {
			for (Seller obj : list) {
				System.out.println(obj);
			}
		}
	}

	public void createSeller(Scanner sc) {
		System.out.println();
		System.out.print("Enter the name: ");
		String name = sc.nextLine();
		System.out.print("Enter the email: ");
		String email = sc.nextLine();
		System.out.print("Enter department ID (1-4): ");
		int depNew = sc.nextInt();
		sc.nextLine();
		Department dep = new Department(depNew, null);
		Seller newSeller = new Seller(null, name, email, new java.util.Date(), 4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted: " + newSeller);
		System.out.println("New ID: " + newSeller.getId());
	}

	public void updateSeller(Scanner sc) {
		System.out.println();
		System.out.print("Enter the ID of the seller you want to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(id);
		if (seller == null) {
			System.out.println("Seller does not exist!");
		} else {
			System.out.println("Current name: " + seller.getName());
			System.out.print("Enter a new name: ");
			String newName = sc.nextLine();
			seller.setName(newName);
			sellerDao.update(seller);
			System.out.println("Seller updated: " + seller);
		}
	}

	public void deleteSeller(Scanner sc) {
		System.out.println();
		System.out.print("Enter the ID of the seller to delete: ");
		int id = sc.nextInt();
		sc.nextLine();
		Seller sellerToDelete = sellerDao.findById(id);
		if (sellerToDelete == null) {
			System.out.println("Seller does not exist!");
		} else {
			System.out.println("Deleting: " + sellerToDelete.getName());
			sellerDao.deleteById(id);
			System.out.println("Deletion completed.");
		}
	}

}
