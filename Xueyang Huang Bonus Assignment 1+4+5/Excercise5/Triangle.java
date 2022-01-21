
public class Triangle {
	private int x;
	private int y;
	private int z;
	
	public static void main(String[] args) {
		Triangle mytri = new Triangle(10,1,1);
		try {
			mytri.validate();
		}
		catch (IllegalTriangleException i) {
			System.out.println(i);
		}
	}
	
	public Triangle(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void validate() throws IllegalTriangleException {
		if (x + y <= z) {
			IllegalTriangleException exz = new IllegalTriangleException("new Triangle("+x+","+y+","+z+"), violates the rule since "+x+" + "+y+" <= "+z);
			throw exz;
		}
		else
			if (y + z <= x) {
				IllegalTriangleException exx = new IllegalTriangleException("new Triangle("+x+","+y+","+z+"), violates the rule since "+y+" + "+z+" <= "+x);
				throw exx;
			}
			else
				if (x + z <= y)  {
					IllegalTriangleException exy = new IllegalTriangleException("new Triangle("+x+","+y+","+z+"), violates the rule since "+x+" + "+z+" <= "+y);
					throw exy;
				}
				else
					System.out.println("All good");
				
	}
}
