package core;

import java.util.ArrayList;
import java.util.List;

public class Person implements Buyer {

	private String name;
	private double money;
	private List<Product> groceryBag;

	public Person(final String name, final double money) {
		setName(name);
		setMoney(money);
		groceryBag = new ArrayList<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void buyProduct(final Product product) {
		if (product.getValue() > money) {
			System.out.println(name + " can't afford " + product);
		} else {
			money -= product.getValue();
			groceryBag.add(product);
			System.out.println(name + " bought " + product);
		}
	}

	@Override
	public String toString() {
		if (groceryBag.isEmpty()) {
			return name + " - Nothing bought";
		}
		return name + " - " + String.join(", ", getGroceries());
	}

	private List<String> getGroceries() {
		List<String> groceries = new ArrayList<>();
		for (Product product : groceryBag) {
			groceries.add(product.getName());
		}
		return groceries;
	}

	private void setName(final String name) {
		if (name.equals("")) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
		this.name = name;
	}

	private void setMoney(final double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Money cannot be negative!");
		}
		this.money = money;
	}

}
