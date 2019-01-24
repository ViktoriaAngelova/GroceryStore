package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.Buyer;
import core.Person;
import core.Product;

public final class Engine {

	private static Scanner input;
	private static List<Buyer> buyers;
	private static List<Product> products;

	static {
		input = new Scanner(System.in);
		buyers = new ArrayList<>();
		products = new ArrayList<>();
	}

	private Engine() {
		throw new UnsupportedOperationException();
	}

	public static void run() {
		Engine.setBuyers(input.nextLine());
		Engine.setProducts(input.nextLine());
		List<String> listOfComands = Engine.getListOfComands();
		Engine.executeComands(listOfComands);
		Engine.printBuyers();
		input.close();
	}

	private static Buyer createBuyer(final String data) {
		String[] dataArray = data.trim().split("=");

		try {
			return new Person(dataArray[0], Double.parseDouble(dataArray[1]));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private static Product createProduct(final String data) {
		String[] dataArray = data.trim().split("=");

		try {
			return new Product(dataArray[0], Double.parseDouble(dataArray[1]));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private static void setBuyers(final String buyersData) {
		String[] dataArray = buyersData.trim().split(";");
		Buyer buyer;

		for (String data : dataArray) {
			buyer = createBuyer(data);
			if (buyer != null) {
				buyers.add(buyer);
			}
		}
	}

	private static void setProducts(final String productsData) {
		String[] dataArray = productsData.trim().split(";");
		Product product;

		for (String data : dataArray) {
			product = createProduct(data);
			if (product != null) {
				products.add(product);
			}
		}
	}

	private static Buyer getBuyer(final String buyerName) {
		for (Buyer buyer : buyers) {
			if (buyer.getName().equalsIgnoreCase(buyerName)) {
				return buyer;
			}
		}
		return null;
	}

	private static Product getProduct(final String productName) {
		for (Product product : products) {
			if (product.toString().equalsIgnoreCase(productName)) {
				return product;
			}
		}
		return null;
	}

	private static List<String> getListOfComands() {
		List<String> listOfComands = new ArrayList<>();
		String userInput = input.nextLine();

		while (!userInput.equalsIgnoreCase("end")) {
			listOfComands.add(userInput);
			userInput = input.nextLine();
		}
		return listOfComands;
	}

	private static void executeComands(final List<String> listOfComands) {
		String[] dataArray;
		Buyer buyer;
		Product product;

		for (String comand : listOfComands) {
			dataArray = comand.trim().split(" ");
			buyer = getBuyer(dataArray[0]);
			product = getProduct(dataArray[1]);
			if (buyer != null && product != null) {
				buyer.buyProduct(product);
			}
		}
	}

	private static void printBuyers() {
		for (Buyer buyer : buyers) {
			System.out.println(buyer);
		}
	}

}
