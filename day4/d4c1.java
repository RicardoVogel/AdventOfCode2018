import java.io.*;
import java.util.*;

public class d4c1 {

	static List<d4Guard> guardList;
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		guardList = new ArrayList<d4Guard>();

		sc = new Scanner(new File("d4input.txt"));
		List<String> inputList = new ArrayList<String>();

		while (sc.hasNextLine()) {
			inputList.add(sc.nextLine());
		} 

		Collections.sort(inputList);
		d4Guard prev = null;
		int sleepH = 0;
		int sleepM = 0;
		for (String str : inputList) {
			if (str.contains("#")) {
				int id = Integer.parseInt(str.split(" ")[3].replace("#", ""));
				boolean alreadyExists = false;
				for (d4Guard gu : guardList) {
					if (gu.getNumber() == id) {
						prev = gu;
						alreadyExists = true;
						break;
					}
				}
				if (!alreadyExists) {
					d4Guard g = new d4Guard(id, 0);
					guardList.add(g);
					prev = g;
				}
				prev.add(str);
			} else if (str.contains("falls asleep")) {
				sleepH = Integer.parseInt(str.split(" ")[1].split(":")[0]);
				sleepM = Integer.parseInt(str.split(" ")[1].split(":")[1].replace("]", ""));
				prev.add(str);

			} else if (str.contains("wakes up")) {
				int wakeH = Integer.parseInt(str.split(" ")[1].split(":")[0]);
				int wakeM = Integer.parseInt(str.split(" ")[1].split(":")[1].replace("]", ""));

				prev.addAsleep((wakeH - sleepH) * 60);
				prev.addAsleep(wakeM - sleepM);
				prev.addtime(sleepH + ":" + sleepM, wakeH + ":" + wakeM);
				sleepH = 0;
				sleepM = 0;
				prev.add(str);
			}
		}

		Collections.sort(guardList, new Comparator<d4Guard>() {

			@Override
			public int compare(d4Guard a, d4Guard b) {
				if (a.getMinAsleep() > b.getMinAsleep()) {
					return -1;
				} else if (a.getMinAsleep() < b.getMinAsleep()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		System.out.println(guardList.get(0));
	}

}
