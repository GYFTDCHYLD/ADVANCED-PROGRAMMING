package driver;

import domain.Animal;
import domain.AnimalBehaviour;
import domain.Bird;
import domain.Dog;
import domain.Elephant;

public class Driver {

	public static void main(String[] args) {
		Animal tempAnim;
		AnimalBehaviour behavior;
		
		tempAnim = new Bird("Parrot", 2, 3.4, 4.4, 2);
		behavior = (AnimalBehaviour) tempAnim;
		System.out.println(behavior.move());
		System.out.println(behavior.makeNoise());
		behavior.eat("rice");
		
		tempAnim = new Dog("Pitbull", 2, 3.4, 4.4, "pure");
		behavior = (AnimalBehaviour) tempAnim;
		System.out.println(behavior.move());
		System.out.println(behavior.makeNoise());
		behavior.eat("Dog Chow");

		tempAnim = new Elephant("Fant", 2, 8.4, 4.4, 5.5);
		behavior = (AnimalBehaviour) tempAnim;
		System.out.println(behavior.move());
		System.out.println(behavior.makeNoise());
		behavior.eat("grass");
	}
	

}
