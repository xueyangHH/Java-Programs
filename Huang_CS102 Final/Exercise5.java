class Link {
	public String name;              
	public double grade; // data item
	public Link next;              
	public Link(String name, double grade) {
	   this.name = name;
	   this.grade = grade;
	}
	public void displayLink() {
	   System.out.print("{" + name + ", " + grade + "} ");
	}
}

class LinkList {
	private Link first;  
	
	public LinkList() {
	   first = null;        
	}
	
	public Link getFirst() {
		return first;
	}
	
	public void insert(String n, double g) {                           
		   Link newlink = new Link(n,g);
		   newlink.next = first;
		   first = newlink;
	}
	
	public int displayList(Link head) {
		int counts = -1;
		System.out.println("List from first to last: ");
		Link current = head;
		while (current != null) {
			  current.displayLink();
			  counts++;
			  current = current.next;
		}
		System.out.println(" ");
		return counts;
	}
	
	public Link getMiddleNode(Link head) {  
	   Link left = head;
	   Link right = head;
	   // get the middle node by looping over the list with two referential links
	   while (right.next != null && right.next.next != null) {
		   left = left.next;
		   right = right.next.next;
	   }
	   return left;
    }
	
	public Link merge(Link l1, Link l2) {
		Link small = null;
		if (l1 == null) {
			return l2;
		} if (l2 == null) {
			return l1;
		}
		if (l1.grade < l2.grade) {
			small = l1;
			small.next = merge(l1.next, l2);
		} else {
			small = l2;
			small.next = merge(l1, l2.next);
		}
		return small;
	}
	
	public Link sort(Link head) {
		if (head == null || head.next == null) {
			return head;
		}
		Link mid = getMiddleNode(head);
		Link midnext = mid.next;
		mid.next = null;
		// recursively sort the left side and the right side of the list
		Link left = sort(head);
		Link right = sort(midnext);
		// merge the sorted list together
		Link merged = merge(left, right);
		return merged;
	}
}

public class Exercise5 {

	public static void main(String[] args) {
		LinkList students = new LinkList();
		students.insert("Alice", 98);
		students.insert("Betty", 89);
		students.insert("Cady", 90);
		students.insert("Daniel", 81);
		students.insert("Eddy", 95);
		System.out.println("This is the unsorted linked list. ");
		students.displayList(students.getFirst());
		Link head = students.sort(students.getFirst());
		System.out.println("This is the sorted linked list. ");
		students.displayList(head);
	}

}
