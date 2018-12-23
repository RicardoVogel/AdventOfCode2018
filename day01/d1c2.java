import java.io.*;
import java.util.*;

public class d1c2 {
	public static List<Integer> list;
	public static Scanner sc;
	public static int result = 0;
	public static boolean done = false;
	public static int i = 0;
	public static int n = 0;

	public static void main(String[] args) throws FileNotFoundException {
		list = new ArrayList<Integer>();
		while (!done) {
			run();
			n++;
		}
		System.out.println("Amount of times traversed: " + n);
		System.out.println("Amount of numbers: " + i);
		sc.close();
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
