import java.util.*;
import java.io.*;

public class d05c1 {
	static String input;
	static char[] inparr;
	static List<Character> inplist;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("d5input.txt"));
		input = sc.next();
		sc.close();

		inparr = input.toCharArray();
		inplist = new ArrayList<Character>();
		for (char c : inparr) {
			inplist.add(c);
		}
		foo();
		System.out.println(inplist.size());
	}

	public static void foo() {
		boolean somethinghappened = false;
		for (int i = inplist.size() - 1; i > 0; i--) {
			char n = inplist.get(i);
			char nMinusOne = inplist.get(i - 1);
			if (Character.toUpperCase(n) == Character.toUpperCase(nMinusOne)) {
				if (Character.isLowerCase(n) && Character.isUpperCase(nMinusOne)
						|| Character.isUpperCase(n) && Character.isLowerCase(nMinusOne)) {
					inplist.remove(i);
					inplist.remove(i - 1);
					i -= 2;
					somethinghappened = true;
				}
			}
		}
		if (somethinghappened) {
			foo();
		} else {
			return;
		}
	}
}