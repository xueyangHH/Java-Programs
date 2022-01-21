class Node {
	public int iData;         
	public Node leftChild;       
	public Node rightChild;        
}

class Tree {
	private Node root;
	public Tree() { 
		root = null; 
	}
	public void createBST(int[] a) {
		int index = 0;
		while (index < a.length) {
			insert(a[index]);
			index++;
		}
	}
	public void insert(int id) {
	   Node newNode = new Node();
	   newNode.iData = id;
	   if (root == null) {
		   root = newNode;
	   } else {
			   Node current = root;
			   Node parent;
			   while (true) {
				   parent = current;
				   if (id < current.iData) {
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
	public void inOrder(Node Root) {
	   if (Root != null) {
		   inOrder(Root.leftChild);
		   System.out.print(Root.iData + " ");
		   inOrder(Root.rightChild);
	   }
    }
	public void TreeSort(int[] a) {
		createBST(a);
		inOrder(root);
	}	
}

public class Exercise1Alg3 {
	public static void main(String[] args) {
		int[] a = {7,75,102,45,24,53,75,31,49,2};
		Tree tree = new Tree();
		System.out.println("/////Below is the output/////");
		tree.TreeSort(a);
	}
}
