import java.util.Scanner;
import java.util.Stack;


class NodeX {
	public double grade;
	public String name;
	public NodeX leftChild;       
	public NodeX rightChild;    
	public NodeX() {}
}

class BST {
	private NodeX root;
	
	public BST() { 
		root = null; 
	}
	
	public void createBST(NodeX[] a) {
		int index = 0;
		while (index < a.length) {
			insert(a[index].grade, a[index].name);
			index++;
		}
	}
	
	public void insert(double id, String dd) {
	   NodeX newNode = new NodeX();
	   newNode.name = dd;
	   newNode.grade = id;
	   if (root == null) {
		   root = newNode;
	   } else {
			   NodeX current = root;
			   NodeX parent;
			   while (true) {
				   parent = current;
				   if (id < current.grade) {
					   current = current.leftChild;
					   if (current == null) {
						   parent.leftChild = newNode;
						   return;
					   }
				   } else {
					   current = current.rightChild;
					   if (current == null) {
						   parent.rightChild = newNode;
						   return;
					   }
				   }
			   }
		}
    }
	
	public void inOrder(NodeX Root) {
	   if (Root != null) {
		   inOrder(Root.leftChild);
		   System.out.print(Root.grade + " ");
		   inOrder(Root.rightChild);
	   }
    }
	
	public void TreeSort() {
		inOrder(root);
	}
	
	public NodeX find(String n) { 		// use an iterative inOrder traverse to find the student
		NodeX found = null;
		if (root != null) {
    		Stack<NodeX> stack = new Stack<NodeX>();
    		NodeX current = root;
    		while (current != null || stack.size() > 0) {
    			while (current != null) {
    				stack.push(current);
    				current = current.leftChild;
    			}
    			current = stack.pop();
    			if (current.name.equals(n)) {
    				found = current;
    				break;
    			}
    			current = current.rightChild;
    		}
    	}
		return found;
	}
	
	public boolean delete(double key) {
	   // assume that all student's grades are not duplicated
	   NodeX current = root;
	   NodeX parent = root;
	   boolean isleftChild = true;
	   while (current.grade != key) {
		   parent = current;
		   if (key < current.grade) {
			   isleftChild = true;
			   current = current.leftChild;
		   } else {
			   isleftChild = false;
			   current = current.rightChild;
		   }
		   if (current == null) {
			   return false;
		   }
	   }
	   // no children
	   if (current.leftChild == null && current.rightChild == null) {
		   if (current == root) {
			   root = null;
		   } else if (isleftChild) {
			   parent.leftChild = null;
		   } else {
			   parent.rightChild = null;
		   }
	   } else if (current.rightChild == null) { 	   // no right child
		   if (current == root) {
			   root = current.leftChild;
		   } else if (isleftChild) {
			   parent.leftChild = current.leftChild;
		   } else {
			   parent.rightChild = current.leftChild;
		   }
	   } else if (current.leftChild == null) {			// no left child
		   if (current == root) {
			   root = current.rightChild;
		   } else if (isleftChild) {
			   parent.leftChild = current.rightChild;
		   } else {
			   parent.rightChild = current.rightChild;
		   }
	   } else {											// two children
		   NodeX successorPar = current;
		   NodeX successor = current;
		   NodeX trace = current.rightChild;
		   while (trace != null) {
			   successorPar = successor;
			   successor = trace;
			   trace = trace.leftChild;
		   }
		   if (current == root) {
			   root = successor;
		   } else if (isleftChild) {
			   parent.leftChild = successor;
		   } else {
			   parent.rightChild = successor;
		   }
		   successor.leftChild = current.leftChild;
		   if (successor != current.rightChild) {
			   successorPar.leftChild = successor.rightChild;
			   successor.rightChild = current.rightChild;
		   }
	   }
	   return true;
    }
	
	public void inOrderCon(NodeX Root, double key) {
	   if (Root != null) {
		   inOrderCon(Root.leftChild, key);
		   if (Root.grade > key) {
			   System.out.print(Root.grade + " ");
		   }
		   inOrderCon(Root.rightChild, key);
	   }
	}
	
	public void displayAbove(double key) {
		inOrderCon(root, key);
	}
}

public class Exercise3 {

	public static void main(String[] args) {
		
		NodeX[] students = new NodeX[10];
		BST tree = new BST();
		double dbinp;
		String strinp;
	    for(int i = 0; i < 10; i++) {
	    	NodeX newStu = new NodeX();
	    	students[i] = newStu;
		    Scanner input = new Scanner(System.in);
		    System.out.println("Please enter a student's name: ");
		    strinp = input.nextLine();
		    newStu.name = strinp;
		    Scanner input2 = new Scanner(System.in);
		    System.out.println("Please enter a student's grade: ");
		    dbinp = input2.nextDouble();
		    newStu.grade = dbinp;
	    }
	    
	    boolean created = false;
	    while(true) {
		    Scanner inputc = new Scanner(System.in);
		    System.out.println("\nWould you like to create a Binary Search Tree? (y for yes, n for no): ");
		    strinp = inputc.nextLine();
		    if (strinp.toLowerCase().equals("y")) {
		    	created = true;
		    	tree.createBST(students);
		    	break;
		    } else if (strinp.toLowerCase().equals("n")) {
		    	break;
		    } else {
		    	System.out.println("Invalid input.");
		    }
	    }
	    
	    
	    int intinp;
	    while(created) {
		    Scanner input = new Scanner(System.in);
		    System.out.println("\nWhich method would you like to call? ");
		    System.out.println("Enter 1 for inserting a new student; ");
		    System.out.println("Enter 2 for deleting a student; ");
		    System.out.println("Enter 3 for searching a student's grade; ");
		    System.out.println("Enter 4 for displaying sorted grades; ");
		    System.out.println("Enter 5 for displaying grades above a value; ");
		    intinp = input.nextInt();
		       if (intinp == 1) {
		   		   Scanner input3 = new Scanner(System.in);
		   		   System.out.println("\nPlease enter a student's name: ");
		   		   strinp = input3.nextLine();
				   Scanner input4 = new Scanner(System.in);
				   System.out.println("Please enter a student's grade: ");
				   dbinp = input4.nextDouble();
		    	   tree.insert(dbinp, strinp.toLowerCase());
		       }
		       else if (intinp == 2) {
		    	   Scanner input5 = new Scanner(System.in);
		   		   System.out.println("\nPlease enter a student's name to delete: ");
		   		   strinp = input5.nextLine();
		   		   if (tree.find(strinp.toLowerCase()) != null) {
		   			   double g = tree.find(strinp.toLowerCase()).grade;
			   		   tree.delete(g);
		   		   } else {
		   			   System.out.println(strinp + " not found. ");
		   		   }
		       }
		       else if (intinp == 3) {
		    	   Scanner input6 = new Scanner(System.in);
		   		   System.out.println("\nPlease enter a student's name to search: ");
		   		   strinp = input6.nextLine();
		   		   if (tree.find(strinp.toLowerCase()) != null) {
		   			   System.out.println(tree.find(strinp.toLowerCase()).grade);
		   		   } else {
		   			System.out.println(strinp + " not found. ");
		   		   }
		   		   System.out.println();
		       }
		       else if (intinp == 4) {
		    	   tree.TreeSort();
		    	   System.out.println();
		       }
		       else if (intinp == 5) {
		    	   Scanner input7 = new Scanner(System.in);
		   		   System.out.println("\nPlease enter a number above which grades are displayed: ");
		   		   dbinp = input7.nextDouble();
		   		   tree.displayAbove(dbinp);
		   		   System.out.println();
		       }
		   	   else {
		    	   System.out.print("\nInvalid entry");
		           System.out.println();
		   	   }
	    } 
	}

}
