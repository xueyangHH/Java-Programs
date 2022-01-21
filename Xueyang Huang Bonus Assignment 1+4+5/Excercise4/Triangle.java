package Excercise3;

public class Triangle extends GeometricObject {
	private double base;
	private double height;
	
	public static void main(String[] args) {
		GeometricObject o = new Triangle(2,2);
		Triangle t = (Triangle) o;
		t.setBaseHei(4,3);
		double area = t.getArea();
		System.out.println(area);
		double peri = t.getPerimeter();
		System.out.println(peri);
	}
	
	public Triangle() {
		super();
	}
	
	public Triangle(double x, double y) {
		super(x,y);
	}

	public void setBaseHei(double b, double h) throws IllegalArgumentException {
		if (b < 0 || h < 0) {
			IllegalArgumentException ex = new IllegalArgumentException("negative input");
			throw ex;
		}
		else
			this.base = b;
			this.height = h;
	}
	
	@Override
	public double getArea() {
		return 0.5 * base * height;
	}

	@Override
	public double getPerimeter() {
		// since I cannot get the perimeter based on merely base and height of a triangle
		// I am going to return the minimum perimeter
		return base + Math.pow((Math.pow(base, 2) + 4 * Math.pow(height, 2)), 0.5);
	}

	
}
