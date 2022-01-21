public class Class {
	public static void main(String[] args) {
		Class c = new Class();
		System.out.println(c.x);
		System.out.println(c.y);

		c = new Class();
		System.out.println(c.x);
		System.out.println(c.y);
	}

	private int x;
	private static int y = 0;

	Class()
	{
		x = 0;
		++y;
	}
}