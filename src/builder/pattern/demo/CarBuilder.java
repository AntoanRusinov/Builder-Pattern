package builder.pattern.demo;

public class CarBuilder {

    private final String model;
    private final int price;
    private final int weight;
    private final int length;
    private final int maxSpeed;
    private final int fuelCapacity;
    private final int seats;

    public static class Builder {
	// Required parameters
	private String model;
	private int price;
	private int weight;
	private int length;

	// Optional parameters with some default values
	private int maxSpeed = 180;
	private int fuelCapacity = 50;
	private int seats = 4;

	// Set required parameters
	public Builder(String model, int price, int weight, int length) {
	    this.model = model;
	    this.price = price;
	    this.weight = weight;
	    this.length = length;
	}

	// Setter for each optional parameter
	public Builder maxSpeed(int value) {
	    maxSpeed = value;
	    return this;
	}

	public Builder fuelCapacity(int value) {
	    fuelCapacity = value;
	    return this;
	}

	public Builder seats(int value) {
	    seats = value;
	    return this;
	}

	public CarBuilder build() {
	    return new CarBuilder(this);
	}

    }

    // BuilderFactory
    private CarBuilder(Builder builder) {
	model = builder.model;
	price = builder.price;
	weight = builder.weight;
	length = builder.length;
	maxSpeed = builder.maxSpeed;
	fuelCapacity = builder.fuelCapacity;
	seats = builder.seats;
    }

    public static void main(String[] args) {
	CarBuilder car = new CarBuilder.Builder("Mercedes", 150000, 3700, 6).maxSpeed(320).fuelCapacity(120).seats(8).build();
	System.out.println(car);
    }

    @Override
    public String toString() {
	return "CarBuilder [model=" + model + ", price=" + price + ", weight=" + weight + ", length=" + length + ", maxSpeed=" + maxSpeed
		+ ", fuelCapacity=" + fuelCapacity + ", seats=" + seats + "]";
    }

}
