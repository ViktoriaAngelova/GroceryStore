

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	private static Scanner input;
	private static List<Buyer> buyers;
	private static List<Product> products;

	static {
		input = new Scanner(System.in);
		buyers = new ArrayList<>();
		products = new ArrayList<>();
	}

	private Program() {
		throw new UnsupportedOperationException();
	}

	public static String getUserinput() {
		return input.nextLine();
	}

	public static void setBuyers(final String buyersData) {
		String[] dataArray = buyersData.trim().split(";");
		Buyer buyer;

		for (String data : dataArray) {
			buyer = createBuyer(data);
			if (buyer != null) {
				buyers.add(buyer);
			}
		}
	}

	public static void setProducts(final String productsData) {
		String[] dataArray = productsData.trim().split(";");
		Product product;

		for (String data : dataArray) {
			product = createProduct(data);
			if (product != null) {
				products.add(product);
			}
		}
	}

	public static List<String> getListOfComands() {
		List<String> listOfComands = new ArrayList<>();
		String userInput = input.nextLine();

		while (!userInput.equalsIgnoreCase("end")) {
			listOfComands.add(userInput);
			userInput = input.nextLine();
		}
		input.close();
		return listOfComands;
	}

	public static void executeComands(final List<String> listOfComands) {
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

	public static void printBuyers() {
		for (Buyer buyer : buyers) {
			System.out.println(buyer);
		}
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

}
