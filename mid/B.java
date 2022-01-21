public class Class {
	public static void main(String[] args) {
		Class c = new Class(10);
		System.out.println(c.x);

		c.fun(5);
		System.out.println(c.x);
	}

	private int x;

	Class()
	{
		this(1);
	}

	Class(int v)
	{
		x = v;
	}

	void fun(int x)
	{
		x = 2;
	}
}