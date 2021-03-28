package domain;

public class Animal {
	protected String name;
	protected int numberOfLeg;
	protected double height;
	protected double weight;
	
	
	public Animal() {
		super();
		this.name = "";
		this.numberOfLeg = 0;
		this.height = 0.0;
		this.weight = 0.0;
	}
	
	public Animal(String name, int numberOfLeg, double height, double weight) {
		this.name = name;
		this.numberOfLeg = numberOfLeg;
		this.height = height;
		this.weight = weight;
	}
	
	public Animal(Animal copy) {
		this.name = copy.name;
		this.numberOfLeg = copy.numberOfLeg;
		this.height = copy.height;
		this.weight = copy.weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfLeg() {
		return numberOfLeg;
	}

	public void setNumberOfLeg(int numberOfLeg) {
		this.numberOfLeg = numberOfLeg;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "\n Name           : " + name + 
			   "\n Number of Legs : " + numberOfLeg + 
			   "\n height         : " + height + 
			   "\n weight         : " + weight;
	}
}
