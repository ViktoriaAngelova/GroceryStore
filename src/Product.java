

public class Product {

	private String name;
	private double value;

	public Product(final String name, final double value) {
		setName(name);
		setValue(value);
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return name;
	}

	private void setName(final String name) {
		if (name.equals("")) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
		this.name = name;
	}

	private void setValue(final double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value cannot be negative!");
		}
		this.value = value;
	}
}
