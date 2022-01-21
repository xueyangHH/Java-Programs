/***************************************************

  Program name:        GOL

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  10/24
 
****************************************************/

public class GOL{
	public static void main(String[] args) {
		if (args.length == 3) {
			if (args[2].equals("hex")) {
				GOLHex hex = new GOLHex();
				hex.main(args);
			}
			else {
				System.out.println("Incorrect Command Line Argument Input");
			}
		}
		else if (args.length == 2) {
			GOLSqr sqr = new GOLSqr();
			sqr.main(args);
		}
		else {
			System.out.println("Incorrect Command Line Argument Input");
		}
	}
}
class GOLSqr {
	public static void init(boolean[][] alive, double alivePerc)
	{
		//assume the grid is squared
		int n = alive.length; //len(alive)

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				alive[i][j] = Math.random() < alivePerc;
			}
		}
	} 

	public static void print(boolean[][] alive)
	{
		char aliveChar = (char) 0x2B1B;
		//assume the grid is squared
		int n = alive.length;

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				if(alive[i][j])
					System.out.print(aliveChar);
				else
					System.out.print("  ");
			}

			System.out.println("");
		}
	}

	public static boolean isAlive(boolean[][] alive, int i, int j)
	{
		//what do we do with negative indices (or >= n)
		int n = alive.length;
		//i = n -> i -> 0
		//i=n+1->i -> i
		// i=-1 -> i -> n-1

		// + 0 // a + 0 = a
		// * 1
		// a % n = (a+kn) % n

		//a=2, n=3 a%n = 2 4%3 =1

		//assume that i,j >= -n
		int x = (i+n) % n;
		int y = (j+n) % n;

		return alive[x][y];
	}

	public static int[][] getNeighs(boolean[][] alive, int i, int j)
	{
		int n = alive.length;
		int[][] neighs = new int[8][2];
		// coordiante = i-1, j-1; i-1, j; i-1, j+1; i, j-1; i, j+1; i+1, j-1; i+1, j;
		// i+1, j+1
		for(int x = -1; x <= 1; x++)
		{
			for (int y = 1; y <= 8; y++)
			{
				if (y < 4 && x < 0)
					neighs[x + y][0] = (i + x + n) % n;
				else if (y >= 4 && y <= 6 && x == 0)
					if (y == 4 || y == 5) 
						neighs[x - 1 + y][0] = (i + x + n) % n;
					else 
					{
						neighs[x - 1 + y][0] = (i + x + 1 + n) % n;
					}
				else if (y > 6 && x > 0) { 
					neighs[y - 2 + x][0] = (i + x + n) % n;
				}
			}
		}
		for(int x = 1; x < 8; x += 3)
		{
			for(int y = -1; y <= 1; y++)
			{
				if ((x < 4) || (x == 4 && y < 0))
					neighs[x + y][1] = (j + y + n) % n;
				else if (x == 4 && y == 0)
					continue;
				else { 
					neighs[x - 1 + y][1] = (j + y + n) %n;
				}
			}
		}
		return neighs;
	}
	public static int countAliveNeighs(boolean[][] alive, int i, int j)
	{
		int nAlive = 0;
		int[][] neighs = getNeighs(alive, i, j);
		for(int x = 0; x < neighs.length; x++)
		{
			if(isAlive(alive, neighs[x][0], neighs[x][1])) //alive[x][y]
				nAlive++;
		}
		return nAlive;
	}
	public static void update(boolean[][] alive, int[] born, int[] surviving) 
	{
		//assume the grid is squared
		int n = alive.length; //len(alive)

		boolean[][] newAlive = new boolean[n][n];

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				int nAlive = countAliveNeighs(alive, i, j);
				if(isAlive(alive, i, j))
				{
					for (int s = 0; s < surviving.length; s++)
					{
						if (nAlive == surviving[s])
						{
							newAlive[i][j] = true;
							break;
						}
						else if (nAlive != surviving[s] && (s != surviving.length - 1))
						{
							continue;
						}
						else
						{
							newAlive[i][j] = false;
						}
					}
				}
				else
				{
					for (int b = 0; b < born.length; b++)
					{
						if (nAlive == surviving[b])
						{
							newAlive[i][j] = true;
							break;
						}
						else if (nAlive != surviving[b] && (b != born.length - 1))
						{
							continue;
						}
						else
						{
							newAlive[i][j] = false;
						}
					}
				}
			}
		}

		for(int i = 0; i < n; ++i)
		{
			for(int j = 0; j < n; ++j)
			{
				alive[i][j] = newAlive[i][j];
			}
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		String[] rulesStr = args[1].split("/", 2);
		int[] born = new int[rulesStr[0].length() - 1];
		int[] surviving = new int[rulesStr[1].length() - 1];
		int bnum;
		int snum;
		if (rulesStr[0].charAt(0) == 'B' && rulesStr[1].charAt(0) == 'S') {
			for (int i = 1; i < rulesStr[0].length(); i++) {
				bnum = 0;
				bnum = Integer.parseInt(rulesStr[0].charAt(i) + "");
				if (bnum <= 8) {
					born[i - 1] = bnum;
				}
				else {
					System.out.println("The number you entered is out of range.");
					born[0] = 100;
				}
			}
			for (int i = 1; i < rulesStr[1].length(); i++) {
				snum = 0;
				snum = Integer.parseInt(rulesStr[1].charAt(i) + "");
				if (snum <= 8) {
					surviving[i - 1] = snum;
				}
				else {
					System.out.println("The number you entered is out of range.");
					surviving[0] = 100;
				}
			}

			boolean[][] alive = new boolean[n][n];
			init(alive, 0.2);
			// alive[0][0] = true;
			// alive[0][1] = true;
			// alive[1][0] = true;
			// alive[1][1] = true;

			while(true)
			{
				print(alive);
				update(alive, born, surviving);
	 
				 try 
				{
				    Thread.sleep(200);
				} 
				catch(InterruptedException e)
				{
				     // this part is executed when an exception (in this example InterruptedException) occurs
				}

						System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}
		else {
			System.out.println("Rules cannot be identified.");
		}
	}
}