import java.util.ArrayList;

@SuppressWarnings("serial")
public class StackofInt extends ArrayList<Integer> {
	private ArrayList<Integer> list;
	
	public static void main(String[] args) {
		StackofInt x = new StackofInt();
		int listSize = x.size();
		System.out.println("size = " + listSize);
		x.push(1);
		x.push(2);
		x.push(3);
		x.push(4);
		x.push(5);
		int newSize = x.size();
		System.out.println("size = " + newSize);
		int top = x.peek();
		System.out.println("top n = " + top);
		int top2 = x.pop();
		System.out.println("top n = " + top2);
		x.push(1);
		String printed = x.toString();
		System.out.println(printed);
	}
	
	public StackofInt() {
		list = new ArrayList<Integer>();
	}
	
	public int size() {
		return list.size();
	}
	
	public int peek() {
		return list.get(list.size() -1);
	}
	
	public int pop() {
		list.remove(list.size() - 1);
		return list.get(list.size() -1);
	}
	
	public void push(int a) {
		list.add(a);
	}
	
	@Override
	public String toString() {
		String print = "";
		for (int i = 0; i < list.size(); i++) {
			print += list.get(i) + " ";
		}
		return print;
	}
	
	@Override
	public boolean equals(Object a) {
		if (a instanceof StackofInt) {
			return list.equals(a);
		}
		else
			return false;
	}
	
}
