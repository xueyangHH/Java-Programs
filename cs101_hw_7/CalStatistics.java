/***************************************************

  Program name:        CalStatistics

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  10/29
 
****************************************************/

import java.util.Scanner;
import java.util.Arrays;

public class CalStatistics {
	public static void main(String[] args) {
		double num_input;
		System.out.println("Insert numbers, (terminate with negative number): ");
		int currentLen = 0;
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("> ");
			num_input = input.nextDouble();
			if (num_input >= 0) {
				InfinitArray.add(num_input);
				currentLen++;
			}
			else {
				break;
			}
		} while (true);
		System.out.println();
		double average = InfinitArray.getAverage(currentLen);
		double[] min_max = InfinitArray.getMinMax(currentLen);
		double sd = InfinitArray.getSD(currentLen);
		double median = InfinitArray.getMedian(currentLen);
		System.out.printf("Their average is %.1f\n", average);
		System.out.println("Their min/max is " + min_max[0] + "/" + min_max[1]);
		System.out.println("Their standard deviation is " + sd);
		System.out.println("Their median is " + median);
	}
}
class InfinitArray {
	public static int callTimes = 0;
	public static double num = 0;
	public static double[] storage = new double[10];
	private static double sum = 0;
	private static double average;
	private static double min = Double.MIN_VALUE;
	private static double max = Double.MAX_VALUE;
	private static double[] min_max = new double[2];
	public static double variance;
	private static double sd;
	private static double median;
	public static void add(double num_input) {
		num = num_input;
		if (callTimes < storage.length) {
			storage[callTimes] = num;
			callTimes++;
		}
		else {
			double[] newStorage = new double[storage.length * 2];
			for (int i = 0; i < storage.length; i++)
			{
				newStorage[i] = storage[i];
			}
			storage = newStorage;
			storage[callTimes] = num;
			callTimes++;
		}
	}
	public static double getAverage(int len) {
		for (int i = 0; i < len; i++) 
		{
			sum += storage[i];
		}
		average = sum / len;
		sum = 0;
		return average;
	}
	public static double[] getMinMax(int len) {
		for (int i = 0; i < len; i++) 
		{
			if (max == Double.MAX_VALUE || storage[i] >= max) {
				max = storage[i];
			}
			if (min == Double.MIN_VALUE || storage[i] <= min) {
				min = storage[i];
			}
		}
		min_max[0] = min;
		min_max[1] = max;
		return min_max;
	}
	public static double getSD(int len) {
		double mean = getAverage(len);
		for (int i = 0; i < len; i++) 
		{
			variance += Math.pow((storage[i] - mean), 2);
		}
		sd = Math.pow((variance / len), 0.5);
		return sd;
	}
	public static double getMedian(int len) {
		double[] sorted = new double[len];
		for (int i = 0; i < len; i++) 
		{
			sorted[i] = storage[i];
		}
		Arrays.sort(sorted);
		if (len % 2 == 0) {
			median = (sorted[(int) (len / 2) - 1] + sorted[(int) (len / 2)]) / 2.0;
		}
		else {
			median = sorted[(int) ((len+1)/2)-1];
		}
		return median;
	}
}