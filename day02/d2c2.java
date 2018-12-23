import java.io.*;
import java.util.*;

public class d2c2 {

	public static void main(String[] args) throws FileNotFoundException {
		boxcheck();
	}

	public static void boxcheck() throws FileNotFoundException {
		List<String> list = new ArrayList<String>();

		Scanner sc = new Scanner(new File("d2input.txt"));
		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}
		sc.close();

		int size = list.get(0).length();

		for (int i = 0; i != list.size() - 1; i++) {
			for (int j = 0; j != list.size() - 1; j++) {
				if (i != j) {
					int counter = 0;
					for (int k = 0; k != size - 1; k++) {
						if (list.get(i).charAt(k) != list.get(j).charAt(k)) {
							counter++;
						}
						if (counter > 1) {
							break;
						}
					}
					if (counter == 1) {
						System.out.println("i: " + list.get(i));
						System.out.println("j: " + list.get(j));
						return;
					}
				}
			}
		}
	}
}