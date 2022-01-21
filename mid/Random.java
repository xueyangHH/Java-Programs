public class Random {
	public int getInt(int a, int b)
	{
		double float_a = a*0.001;
		double float_b = b*0.001;
		double randNum = 0;
		while(true)
		{
			randNum = Math.random();
			if(randNum <= float_a || randNum >= float_b)
			{
				continue;
			}
			else
			{
				break;
			}
		}
		int randInt = randNum*1000;
		return randInt;
	}
	public String getString(n)
	{
		String string = "";
		Random r = new Random();
		for(int i = 0; i < n; i++) 
		{
			int num = r.getInt(97,122);
			string += char(num);
		}
		return string
	}
	public static void main(String[] args) {
		Random r = new Random();
		String randStr = r.getString();
	}
}