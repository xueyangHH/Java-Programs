package Excercise3;

public abstract class GeometricObject {
	private double x;
	private double y;
	
	public GeometricObject() {
		x = 0;
		y = 0;
	}
	
	public GeometricObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
}
