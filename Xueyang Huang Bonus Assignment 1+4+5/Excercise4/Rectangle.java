package Excercise3;

public class Rectangle extends GeometricObject {
	private double width;
	private double height;
	
	public static void main(String[] args) {
		GeometricObject o = new Rectangle(2,2);
		Rectangle r = (Rectangle) o;
		r.setWidHei(5,4);
		double area = r.getArea();
		System.out.println(area);
		double peri = r.getPerimeter();
		System.out.println(peri);
	}
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(double x, double y) {
		super(x,y);
	}
	
	public void setWidHei(double w, double h) throws IllegalArgumentException {
		if (w < 0 || h < 0) {
			IllegalArgumentException ex = new IllegalArgumentException("negative input");
			throw ex;
		}
		else
			this.width = w;
			this.height = h;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2 * (width + height);
	}

}
