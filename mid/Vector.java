class Vector {
	private double x;
	private double y;
	public Vector() {
		x = 0;
		y = 0;
	}

	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double distance2(Vector v) {
		double distance2 = (x-v.x) * (x-v.x) + (y-v.y) * (y-v.y);
		return distance2;
	}

	public double distance(Vector V) {
		double distance = sqrt(distance2);
		return distance;
	}

	public Vector move(Vector v) {
		x += v.x;
		y += v.y;
		return v(x,y);
	}
}

class Circle {
	private Vector center;
	private double radius;
	public Circle() {
		Vector center = new Vector();
		center(0,0);
		radius = 0;
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	public void move(Vector v) {
		double x_pos = center.x;
		double y_pos = center.y;
		x_pos += v.x;
		y_pos += v.y;
		center.x = x_pos;
		center.y = y_pos;
	}
	public boolean inside(Vector v) {
		double distance1 = center.distance(v);
		if (distance1 < radius) {
			return true;
		}
		else {
			return false;
		}
	}
}

public class ifInside{
	public static void main(String[] args) {
		Circle mycircle = new Circle();
		mycircle(10);
		Vector moving = new Vector();
		moving(5,5);
		Vector myvector = new Vector();
		myvector(1,1);
		mycircle.move(moving);
		boolean inside = mycircle.inside(myvector);
		System.out.println("The vector (1,1) inside the circle is" + inside);
	}
}