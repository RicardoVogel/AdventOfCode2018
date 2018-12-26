import java.util.*;
import java.io.*;

public class d08c1 {
	static Scanner sc;
	static int tot;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("d8input.txt"));
		foo();
		System.out.println(tot);
		sc.close();
	}

	public static void foo() {
		int children = sc.nextInt();
		int entries = sc.nextInt();
		for (int i = 0; i < children; i++) {
			foo();
		}

		for (int i = 0; i < entries; i++) {
			tot += sc.nextInt();
		}
	}

}