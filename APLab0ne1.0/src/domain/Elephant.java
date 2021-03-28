package domain;

public class Elephant extends Animal implements AnimalBehaviour{
	private double trunkLength; 
	
	public Elephant() {
		super();
		this.trunkLength = 0.0;
	}
	
	public Elephant(String name, int numberOfLeg, double height, double weight) {
		super(name, numberOfLeg, height, weight);
	}
	
	public Elephant(String name, int numberOfLeg, double height, double weight, double trunkLength) {
		this.name = name;
		this.numberOfLeg = numberOfLeg;
		this.height = height;
		this.weight = weight;
		this.trunkLength = trunkLength;
	}
	
	public Elephant(Elephant copy) {
		this.name = copy.name;
		this.numberOfLeg = copy.numberOfLeg;
		this.height = copy.height;
		this.weight = copy.weight;
		this.trunkLength = copy.trunkLength;
	}

	


	public double getTrunkLength() {
		return trunkLength;
	}

	public void setTrunkLength(double trunkLength) {
		this.trunkLength = trunkLength;
	}

	@Override
	public String toString() {
		return "\n Name           : " + name + 
			   "\n Number of Legs : " + numberOfLeg + 
			   "\n Height         : " + height + 
			   "\n Weight         : " + weight +
			   "\n Trunk length   : " + trunkLength; 
	}

	@Override
	public String move() {
		return "Elephant moved";
	}

	@Override
	public String makeNoise() {
		return "Elephant making noise";
	}

	@Override
	public void eat(String food) {
		System.out.println("Elephant eating " + food);
		
	}
}
