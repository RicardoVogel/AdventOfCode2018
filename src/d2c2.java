import java.io.*;
import java.util.*;

public class d2c2 {
	public static List<Integer> list;
	public static Scanner sc;
	public static int result = 0;
	public static boolean done = false;

	public static void main(String[] args) throws FileNotFoundException {
		list = new ArrayList<Integer>();
		while (!done) {
			run();
		}
		sc.close();
	}

	public static void run() throws FileNotFoundException {
		sc = new Scanner(new File("d1input"));
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			result += Integer.parseInt(str);
			if (list.contains(result)) {
				System.out.println(result);
				done = true;
				return;
			}
			list.add(result);
		}
	}
}
