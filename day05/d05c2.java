import java.util.*;
import java.io.*;

public class d05c2 {
	static String input;
	static char[] inparr;
	static final char[] alphabeth = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static List<Character> inplist;
	static int[] outputs = new int[26];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("d5input.txt"));
		input = sc.next();
		sc.close();

		inparr = input.toCharArray();
		int counter = 0;
		for (char c : alphabeth) {
			outputs[counter] = bar(c);
			counter++;
		}

		Arrays.sort(outputs);
		System.out.println(outputs[0]);
	}

	public static int bar(char rem) throws FileNotFoundException {
		inplist = new ArrayList<Character>();
		for (char c : inparr) {
			inplist.add(c);
		}
		for (int i = inplist.size() - 1; i > 0; i--) {
			if (inplist.get(i) == rem || inplist.get(i) == Character.toUpperCase(rem)) {
				inplist.remove(i);
			}
		}

		foo();
		return inplist.size();
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
