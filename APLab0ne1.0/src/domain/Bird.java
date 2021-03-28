package domain;

public class Bird extends Animal implements AnimalBehaviour{
	private int numberOfWings;
	
	
	public Bird() {
		super();
		this.numberOfWings = 0;
	}
	
	public Bird(String name, int numberOfLeg, double height, double weight) {
		super(name, numberOfLeg, height, weight);
	}
	
	public Bird(String name, int numberOfLeg, double height, double weight, int numberOfWings) {
		this.name = name;
		this.numberOfLeg = numberOfLeg;
		this.height = height;
		this.weight = weight;
		this.numberOfWings = numberOfWings;
	}
	
	public Bird(Bird copy) {
		this.name = copy.name;
		this.numberOfLeg = copy.numberOfLeg;
		this.height = copy.height;
		this.weight = copy.weight;
		this.numberOfWings = copy.numberOfWings;
	}

	public int getNumberOfWings() {
		return numberOfWings;
	}

	public void setNumberOfWings(int numberOfWings) {
		this.numberOfWings = numberOfWings;
	}
	
	@Override
	public String toString() {
		return "\n Name           : " + name + 
			   "\n Number of Legs : " + numberOfLeg + 
			   "\n Height         : " + height + 
			   "\n Weight         : " + weight +
			   "\n Number of wings: " + numberOfWings;
	}

	@Override
	public String move() {
		return "Bird moved";
	}

	@Override
	public String makeNoise() {
		return "Bird making noise";
	}

	@Override
	public void eat(String food) {
		System.out.println("Bird eating " + food);
		
	}
	
	

}
