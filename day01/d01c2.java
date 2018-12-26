import java.io.*;
import java.util.*;

public class d01c2 {
	public static List<Integer> list;
	public static Scanner sc;
	public static int result = 0;
	public static boolean done = false;
	public static int i = 0;
	public static int n = 0;

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		list = new ArrayList<Integer>();
		while (!done) {
			run();
			n++;
		}
		System.out.println("Amount of times traversed: " + n);
		System.out.println("Amount of numbers: " + i);
		sc.close();
		long endTime = System.nanoTime();

		long duration = (endTime - startTime); 
		System.out.println(duration);
	}
	

	public static void run() throws FileNotFoundException {
		sc = new Scanner(new File("d1input.txt"));
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			result += Integer.parseInt(str);
			if (list.contains(result)) {
				System.out.println("Result: " + result);
				done = true;
				return;
			}
			i++;
			list.add(result);
		}
	}
}
