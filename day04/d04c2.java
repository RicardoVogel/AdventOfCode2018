import java.io.*;
import java.util.*;

public class d04c2 {

	static List<d04Guard> guardList;
	private static Scanner sc;

	public static void main(String[] args) throws FileNotFoundException {
		guardList = new ArrayList<d04Guard>();

		sc = new Scanner(new File("d4input.txt"));
		List<String> inputList = new ArrayList<String>();

		while (sc.hasNextLine()) {
			inputList.add(sc.nextLine());
		}

		Collections.sort(inputList);
		d04Guard prev = null;
		int sleepH = 0;
		int sleepM = 0;
		for (String str : inputList) {
			if (str.contains("#")) {
				int id = Integer.parseInt(str.split(" ")[3].replace("#", ""));
				boolean alreadyExists = false;
				for (d04Guard gu : guardList) {
					if (gu.getNumber() == id) {
						prev = gu;
						alreadyExists = true;
						break;
					}
				}
				if (!alreadyExists) {
					d04Guard g = new d04Guard(id, 0);
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
	
		Collections.sort(guardList, new Comparator<d04Guard>() {
			@Override
			public int compare(d04Guard a, d04Guard b) {
				if (a.foo() > b.foo()) {
					return -1;
				} else if (a.foo() < b.foo()) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		System.out.println(guardList.get(0));
	}
}
