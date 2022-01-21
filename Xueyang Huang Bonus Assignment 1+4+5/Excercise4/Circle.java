package Excercise3;

public class Circle extends GeometricObject{
	private double radius;
	
	public static void main(String[] args) {
		GeometricObject o = new Circle(2,2);
		Circle c = (Circle) o;
		c.setRad(4);
		double area = c.getArea();
		System.out.println(area);
		double peri = c.getPerimeter();
		System.out.println(peri);
	}
	public Circle() {
		super();
	}
	
	public Circle(double x, double y) {
		super(x,y);
	}

	public void setRad(double r) throws IllegalArgumentException {
		if (r < 0) {
			IllegalArgumentException ex = new IllegalArgumentException("negative ipput");
			throw ex;
		}
		else
			this.radius = r;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
}
