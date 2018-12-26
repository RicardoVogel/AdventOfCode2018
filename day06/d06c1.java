import java.util.*;
import java.io.*;

public class d06c1 {
	static int amountOfLines = 50;
	static int border = 356;
	static Scanner sc;
	static int tot;
	static int[] xinparr = new int[amountOfLines];
	static int[] yinparr = new int[amountOfLines];
	static int[] coordarr = new int[amountOfLines];

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("d6input.txt"));

		for (int i = 0; i != amountOfLines; i++) {
			String ln = sc.nextLine();
			xinparr[i] = Integer.parseInt(ln.split(", ")[0]);
			yinparr[i] = Integer.parseInt(ln.split(", ")[1]);
		}

		for (int i = 0; i <= border; i++) {
			for (int j = 0; j <= border; j++) {
				int closestk = closestCoord(i, j);
				coordarr[closestk]++;
			}
		}

		// top row
		for (int i = 0; i <= border; i++) {
			int j = 0;
			int closestk = closestCoord(i, j);
			coordarr[closestk] = 0;
		}

		// bot row
		for (int i = 0; i <= border; i++) {
			int j = border;
			int closestk = closestCoord(i, j);
			coordarr[closestk] = 0;
		}

		// left row
		for (int j = 0; j <= border; j++) {
			int i = 0;
			int closestk = closestCoord(i, j);
			coordarr[closestk] = 0;
		}

		// right row
		for (int j = 0; j <= border; j++) {
			int i = 0;
			int closestk = closestCoord(i, j);
				coordarr[closestk] = 0;
		}

		Arrays.sort(coordarr);
		System.out.println(coordarr[amountOfLines - 1]);

		sc.close();
	}

	public static int closestCoord(int i, int j) {
		int closest = Integer.MAX_VALUE;
		int closestk = Integer.MAX_VALUE;
		for (int k = 0; k < amountOfLines; k++) {
			int thisx = xinparr[k];
			int thisy = yinparr[k];

			int absx;
			int absy;
			if (thisx - i < 0) {
				absx = -1 * (thisx - i);
			} else {
				absx = thisx - i;
			}
			if (thisy - j < 0) {
				absy = -1 * (thisy - j);
			} else {
				absy = thisy - j;
			}

			if (absx + absy < closest) {
				closest = absx + absy;
				closestk = k;
			}
		}
		return closestk;
	}
}