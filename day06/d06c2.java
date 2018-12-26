import java.util.*;
import java.io.*;

public class d06c2 {
	static int amountOfLines = 50;
	static int border = 356;
	static Scanner sc;
	static int tot;
	static int[] xinparr = new int[amountOfLines];
	static int[] yinparr = new int[amountOfLines];
	static int[] coordarr = new int[amountOfLines];
	static int totalSaveCoords = 0;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new File("d6input.txt"));

		for (int i = 0; i != amountOfLines; i++) {
			String ln = sc.nextLine();
			xinparr[i] = Integer.parseInt(ln.split(", ")[0]);
			yinparr[i] = Integer.parseInt(ln.split(", ")[1]);
		}

		for (int i = 0; i <= border; i++) {
			for (int j = 0; j <= border; j++) {
				int totalDistance = 0;
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

					totalDistance += absx + absy;
				}
				if(totalDistance < 10000) {
					totalSaveCoords++;
				}
			}
		}
		System.out.println(totalSaveCoords);
		sc.close();
	}
}