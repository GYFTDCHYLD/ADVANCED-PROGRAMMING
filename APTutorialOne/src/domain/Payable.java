package domain;

public interface Payable {
	public final double OVRATE = 1.25;
	
	public double calculateOverTime();
	
}
