class StackX {
	private final int SIZE = 30;
	private int[] stack;
	private int top;

	public StackX() {           // constructor
	   stack = new int[SIZE];    // make array
	   top = -1;
	}
	public void push(int j) {   // put item on stack
	    stack[++top] = j; 
	}
	public int pop() {          // take item off stack
		return stack[top--]; 
	}
	public int peek() {         // peek at top of stack
	    return stack[top]; 
	}
	public boolean isEmpty() {  // true if nothing on stack
	    return (top == -1); 
	}
}

class Vertex {
	public char label;        // label (e.g. 'A')
	public boolean wasVisited;
	
	public Vertex(char label) {   // constructor
	   this.label = label;
	   wasVisited = false;
	}
}

class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][];      // adjacency matrix
	private int nVerts;          // current number of vertices
	private StackX theStack;
	
	public Graph() {               // constructor
	   vertexList = new Vertex[MAX_VERTS];
	   adjMat = new int[MAX_VERTS][MAX_VERTS];		// adjacency matrix
	   nVerts = 0;
	   for(int y=0; y<MAX_VERTS; y++)
	      for(int x=0; x<MAX_VERTS; x++)
	         adjMat[x][y] = 0;
	   theStack = new StackX();
	}
	
	public void addVertex(char lab) {
	   vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
	   adjMat[start][end] = 1;
	   adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
	   System.out.print(vertexList[v].label);
	}
	
	public int dfs(int start) {  // depth-first search
	   int count=1;
	   vertexList[start].wasVisited = true; 
	   //displayVertex(start);       
	   theStack.push(start);            
	
	   while( !theStack.isEmpty() ) { 
		  // get an unvisited vertex adjacent to stack top
	      int v = getAdjUnvisitedVertex( theStack.peek() );
	      if(v == -1)                    // if no such vertex,
	         theStack.pop();
	      else {                          // if it exists,
	         vertexList[v].wasVisited = true;
			 count++;
	         //displayVertex(v);               
	         theStack.push(v);         
	      }
	   }
	   for(int j=0; j<nVerts; j++)     
	      vertexList[j].wasVisited = false;
	   return count;
	}  
	
	public int getAdjUnvisitedVertex(int v) {
	   for(int j=0; j<nVerts; j++)
	      if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
	         return j;
	   return -1;
	} 

	public void isConnected(int start) {
		int count = dfs(start);
		if (nVerts == count) {
			System.out.println("\nThis graph is connected. ");
		} else {
			System.out.println("\nThis graph is disconnected. ");
		}
	}
} 

public class Exercise2 {
	public static void main(String[] args) {
	   Graph theGraph = new Graph();
	   theGraph.addVertex('A');    // 0 
	   theGraph.addVertex('B');    // 1
	   theGraph.addVertex('C');    // 2
	   theGraph.addVertex('D');    // 3
	   theGraph.addVertex('E');    // 4
	   theGraph.addVertex('F');	   // 5
	   theGraph.addVertex('G');    // 6
	   theGraph.addVertex('H');    // 7
	
	   theGraph.addEdge(0, 1);     // AB
	   theGraph.addEdge(1, 2);     // BC
	   theGraph.addEdge(0, 3);     // AD
	   theGraph.addEdge(3, 4);     // DE
	   theGraph.addEdge(5, 6);     // FG
	   theGraph.addEdge(7, 6);     // HG
	   theGraph.addEdge(5, 7);     // FH
	
	   theGraph.isConnected(0);
	   System.out.println();
	   } 
} 