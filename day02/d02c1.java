import java.io.*;
import java.util.*;

public class d02c1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("d2input.txt"));
		System.out.println(checksum(sc));
		sc.close();
	}

	public static int checksum(Scanner sc) {
		int twos = 0;
		int threes = 0;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			char[] arr = str.toCharArray();
			int[] arr1 = new int[arr.length];

			for (int i = 0; i <= arr.length - 1; i++) {
				arr1[i] = (int) arr[i] - 97;
			}
			List<Integer> list = new ArrayList<Integer>();

			for (int i : arr1) {
				list.add(i);
			}
			Collections.sort(list);

			boolean twosdone = false;
			boolean threesdone = false;
			for (int i = 0; i <= arr.length - 1; i++) {
				if (list.indexOf(i) == list.lastIndexOf(i) - 2 && !threesdone) {
					threes++;
					threesdone = true;
				} else if (list.indexOf(i) == list.lastIndexOf(i) - 1 && !twosdone) {
					twos++;
					twosdone = true;
				}
			}
		}
		System.out.println(String.format("Twos: %s, Threes: %s", twos, threes));
		return twos * threes;
	}

}
