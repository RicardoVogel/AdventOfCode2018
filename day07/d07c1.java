import java.util.*;
import java.io.*;

public class d07c1 {
	static String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static boolean[] visited = new boolean[27];
	static List<Node> nodeList = new ArrayList<Node>();
	static List<Node> nodeList1 = new ArrayList<Node>();
	static String output = "";
	static Node start;

	public static class Node {
		List<Node> successors;
		List<Node> predecessors;
		char value;

		public Node(char value) {
			this.value = value;
			predecessors = new ArrayList<Node>();
			successors = new ArrayList<Node>();
		}

		@Override
		public String toString() {
			return value + "";
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("d7input.txt"));
		start = new Node('[');

		for (char c : abc.toCharArray()) {
			nodeList.add(new Node(c));
		}

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			char before = line.charAt(5);
			char after = line.charAt(36);
			nodeList.get(before - 65).successors.add(nodeList.get(after - 65));
			nodeList.get(after - 65).predecessors.add(nodeList.get(before - 65));

		}
		sc.close();

		nodeList1.add(start);
		for (Node n : nodeList) {
			if (n.predecessors.isEmpty() && !n.successors.isEmpty()) {
				start.successors.add(n);
				nodeList1.add(n);
			}

			Collections.sort(n.successors, new Comparator<Node>() {
				@Override
				public int compare(Node arg0, Node arg1) {
					if (arg0.value > arg1.value) {
						return 1;
					} else if (arg0.value == arg1.value) {
						return 0;
					} else {
						return -1;
					}
				}
			});
			Collections.sort(n.predecessors, new Comparator<Node>() {
				@Override
				public int compare(Node arg0, Node arg1) {
					if (arg0.value > arg1.value) {
						return 1;
					} else if (arg0.value == arg1.value) {
						return 0;
					} else {
						return -1;
					}
				}
			});
		}
		Collections.sort(start.predecessors, new Comparator<Node>() {
			@Override
			public int compare(Node arg0, Node arg1) {
				if (arg0.value > arg1.value) {
					return 1;
				} else if (arg0.value == arg1.value) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		foo(start);
		output = output.replace("[", "");
		System.out.println(output);
	}

	public static void foo(Node n) {
		for (Node m : n.predecessors) {
			if (!visited[m.value - 65]) {
				return;
			}
		}

		output += n.value;
		visited[n.value - 65] = true;
		nodeList1.remove(nodeList1.indexOf(n));
		
		for (Node m : n.successors) {
			nodeList1.add(m);
		}
		for (Node m : nodeList) {
			if (!visited[m.value - 65]) {
				foo(m);
			}
		}
	}
}
