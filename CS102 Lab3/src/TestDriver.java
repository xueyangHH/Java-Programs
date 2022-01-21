

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) throws Exception{
		// test with the Integer type
		Stack<Integer> stack1 = new Stack<>();
		
		for(int i = 0; i <= 5; i++)
			stack1.push(i);
		
		System.out.println("Popped " + stack1.pop());
		stack1.display();
		stack1.display(1, 3);
		stack1.search(3);
		Stack<Integer> check1 = new Stack<Integer>();
		for(int i = 0; i < 2; i++)
			check1.push(i);
		
		System.out.println(stack1.compareTo(check1));
		
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("temp"));
		out.writeObject(stack1);
		out.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("temp"));
		@SuppressWarnings("unchecked")
		Stack<Integer> read = (Stack<Integer>) in.readObject();
		
		read.display();
		System.out.println("Admin: " + read.admin);
		in.close();
		// test with the Character type
		Stack<Character> stack2 = new Stack<>();
		
		stack2.push('a');
		stack2.push('p');
		stack2.push('p');
		stack2.push('l');
		stack2.push('e');
		stack2.push('e');
		
		System.out.println("Popped " + stack2.pop());
		stack2.display();
		stack2.display(1, 3);
		stack2.search('l');
		Stack<Character> check2 = new Stack<Character>();
		check2.push('a');
		check2.push('p');
		
		System.out.println(stack2.compareTo(check2));
		
		ObjectOutputStream out2 = new ObjectOutputStream(
				new FileOutputStream("temp"));
		out2.writeObject(stack2);
		out2.close();
		ObjectInputStream in2 = new ObjectInputStream(
				new FileInputStream("temp"));
		@SuppressWarnings("unchecked")
		Stack<Character> read2 = (Stack<Character>) in2.readObject();
		
		read2.display();
		System.out.println("Admin: " + read2.admin);
		in2.close();
		// test with the String type
		Stack<String> stack3 = new Stack<>();
		
		stack3.push("java");
		stack3.push("C");
		stack3.push("C++");
		stack3.push("Python");
		stack3.push("R");
		stack3.push("MATLAB");
		
		System.out.println("Popped " + stack3.pop());
		stack3.display();
		stack3.display(1, 3);
		stack3.search("Python");
		Stack<String> check3 = new Stack<String>();
		check3.push("java");
		check3.push("C");
		
		System.out.println(stack3.compareTo(check3));
		
		ObjectOutputStream out3 = new ObjectOutputStream(
				new FileOutputStream("temp"));
		out3.writeObject(stack3);
		out3.close();
		ObjectInputStream in3 = new ObjectInputStream(
				new FileInputStream("temp"));
		@SuppressWarnings("unchecked")
		Stack<String> read3 = (Stack<String>) in3.readObject();
		
		read3.display();
		System.out.println("Admin: " + read3.admin);
		in3.close();
		// test with the Float type
		Stack<Float> stack4 = new Stack<>();
		
		for(float i = 0; i <= 5; i++)
			stack4.push(i);
		
		System.out.println("Popped " + stack4.pop());
		stack4.display();
		stack4.display(1, 3);
		stack4.search((float) 3.0);
		Stack<Float> check4 = new Stack<Float>();
		for(float i = 0; i < 2; i++)
			check4.push(i);
		
		System.out.println(stack4.compareTo(check4));
		
		ObjectOutputStream out4 = new ObjectOutputStream(
				new FileOutputStream("temp"));
		out4.writeObject(stack4);
		out4.close();
		ObjectInputStream in4 = new ObjectInputStream(
				new FileInputStream("temp"));
		@SuppressWarnings("unchecked")
		Stack<Float> read4 = (Stack<Float>) in4.readObject();
		
		read4.display();
		System.out.println("Admin: " + read4.admin);
		in4.close();
		// test with the Double type
		Stack<Double> stack5 = new Stack<>();
		
		for(double i = 0.0; i <= 5.0; i++)
			stack5.push(i);
		
		System.out.println("Popped " + stack5.pop());
		stack5.display();
		stack5.display(1, 3);
		stack5.search(3.0);
		Stack<Double> check5 = new Stack<Double>();
		for(double i = 0.0; i < 2.0; i++)
			check5.push(i);
		
		System.out.println(stack5.compareTo(check5));
		
		ObjectOutputStream out5 = new ObjectOutputStream(
				new FileOutputStream("temp"));
		out5.writeObject(stack5);
		out5.close();
		ObjectInputStream in5 = new ObjectInputStream(
				new FileInputStream("temp"));
		@SuppressWarnings("unchecked")
		Stack<Double> read5 = (Stack<Double>) in5.readObject();
		
		read5.display();
		System.out.println("Admin: " + read5.admin);
		in5.close();
	}

}
