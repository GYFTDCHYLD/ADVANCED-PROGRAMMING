package domain;

public class Dog extends Animal implements AnimalBehaviour{
	private String breed; 
	
	public Dog() {
		super();
		this.breed = "";
	}
	
	public Dog(String name, int numberOfLeg, double height, double weight) {
		super(name, numberOfLeg, height, weight);
	}
	
	public Dog(String name, int numberOfLeg, double height, double weight, String breed) {
		this.name = name;
		this.numberOfLeg = numberOfLeg;
		this.height = height;
		this.weight = weight;
		this.breed = breed;
	}
	
	public Dog(Dog copy) {
		this.name = copy.name;
		this.numberOfLeg = copy.numberOfLeg;
		this.height = copy.height;
		this.weight = copy.weight;
		this.breed = copy.breed;
	}

	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "\n Name           : " + name + 
			   "\n Number of Legs : " + numberOfLeg + 
			   "\n Height         : " + height + 
			   "\n Weight         : " + weight +
			   "\n Breed          : " + breed;
	}

	@Override
	public String move() {
		return "Dog moved";
	}

	@Override
	public String makeNoise() {
		return "Dog making noise";
	}

	@Override
	public void eat(String food) {
		System.out.println("Dog eating " + food);
		
	}
	

}
