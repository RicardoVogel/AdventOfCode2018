import java.util.*;
import java.io.*;

public class d08c2 {
	static Scanner sc;
	static int[] inparr;
	static int tot;
	static int c = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sca = new Scanner(new File("d8input.txt"));
		int counter = 0;
		while (sca.hasNext()) {
			sca.next();
			counter++;
		}
		inparr = new int[counter];
		sca.close();

		sc = new Scanner(new File("d8input.txt"));
		for (int i = 0; i != counter; i++) {
			inparr[i] = sc.nextInt();
		}

		sc.close();
		
		System.out.println(foo());
	}

	public static int foo() {
		int output = 0;
		int children = inparr[c];
		c++;
		int entries = inparr[c];
		c++;
		int[] childarr = new int[children];
		
		for (int i = children; i > 0; i--) {
			childarr[children-i] = foo();
		}
		if (children == 0) {
			for (int i = entries; i > 0; i--) {
				output += inparr[c];
				c++;
			}
		} else {
			for (int i = entries; i > 0; i--) {
				if (inparr[c] > children) {
					c++;
				} else {
					output += childarr[inparr[c]-1];
					c++;
				}
			}
		}
		return output;
	}

}