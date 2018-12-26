import java.util.*;

public class d04Guard {
	private int number;
	private int minAsleep;
	public List<String> strings;
	public List<String> times;
	public int bar = -1;

	public d04Guard(int number, int minAsleep) {
		this.number = number;
		this.minAsleep = minAsleep;
		strings = new ArrayList<String>();
		times = new ArrayList<String>();
	}

	public void add(String stringToAdd) {
		strings.add(stringToAdd);
	}

	public void addtime(String start, String stop) {
		times.add(start + "-" + stop);
	}

	public int getNumber() {
		return number;
	}

	public int getMinAsleep() {
		return minAsleep;
	}

	public void addAsleep(int timeToAdd) {
		minAsleep += timeToAdd;
	}

	public String toString() {
		return "ID: " + number + " min asleep: " + minAsleep + "\n" + strings + "\n" + times + "\n" + foo();
	}

	public int foo() {
		int[] foo = new int[60];

		for (String str : times) {
			int start = Integer.parseInt(str.split("-")[0].split(":")[1]);
			int stop = Integer.parseInt(str.split("-")[1].split(":")[1]);

			for (int i = start; i != stop; i++) {
				foo[i]++;
			}
		}
		int max = 0;
		for (int i = 0; i != 60; i++) {
			if (foo[i] > max) {
				max = foo[i];
			}
		}
		if (max == 18) {
			System.out.println("");
		}

		return max;
	}

}