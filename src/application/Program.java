package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1, seller findByID ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

	}

}
