/***************************************************

  Program name:        GOLHex

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  10/25
 
****************************************************/

public class GOLHex {
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
		String aliveStr = "| • ";
		String deadStr = "|   ";
		//assume the grid is squared
		int n = alive.length;
		String l1_unit = "/ \\ ";
		String l3_unit = "\\ / ";
		String l1 = " ";
		String l3 = " ";
		String l4 = "  ";
		for (int a = 0; a < n; ++a)
		{
			l1 += l1_unit;
			l3 += l3_unit;
		}
		for(int i = 0; i < (2 * n); ++i)
		{
			if ((i+1) % 4 == 1)
				System.out.print(l1);
			else if ((i+1) % 4 == 3)
				System.out.print(l3);
			else if ((i+1) % 4 ==2)
				for(int j = 0; j < n; ++j)
				{
					if(alive[i/2][j])
						System.out.print(aliveStr);
					else
						System.out.print(deadStr);
				}
			else
				for (int m = 0; m < n; ++m)
				{
					if (alive[i/2][m])
						l4 += aliveStr;
					else
						l4 += deadStr;
				}
				System.out.print(l4);
				l4 = "  ";
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
		int[][] neighs = new int[6][2];
		// even i coordiante = i-1, j; i-1, j+1; i, j-1; i, j+1; i+1, j; i+1, j+1
		// odd i coordinate = i-1, j-1; i-1, j; i, j-1; i, j+1; i+1, j-1; i+1, j
		for(int x = -1; x <= 1; x++)
		{
			for (int y = 1; y <= 6; y++)
			{
				if (y < 3 && x < 0)
					neighs[x + y][0] = (i + x + n) % n;
				else if (y >= 3 && y < 5 && x == 0) 
					neighs[y - 1][0] = (i + x + n) % n;
				else if (y >= 5 && x > 0) { 
					neighs[y - 1][0] = (i + x + n) % n;
				}
			}
		}
		if ((i+1) % 2 != 0)
		{
			for(int x = 1; x < 6; x += 2)
			{
				for(int y = -1; y <= 0; y++)
				{
					if ((x < 3) || (x == 3 && y < 0))
						neighs[x + y][1] = (j + y + n) % n;
					else if (x == 3 && y == 0)
						neighs[x + y][1] = (j + 1 + n) % n;
					else { 
						neighs[x + y][1] = (j + y + n) % n;
					}
				}
			}
		}
		else {
			for(int x = 0; x <= 5; x += 2)
			{
				for(int y = 0; y <= 1; y++)
				{
					if (x < 2)
						neighs[x + y][1] = (j + y + n) % n;
					else if (x == 2 && y == 0)
						neighs[x][1] = (j - 1 + n) % n;
					else { 
						neighs[x + y][1] = (j + y + n) % n;
					}
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
				if (bnum <= 6) {
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
				if (snum <= 6) {
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