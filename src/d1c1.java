import java.io.*;
import java.util.*;

public class d1c1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("d1input"));
		int result = 0;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			result += Integer.parseInt(str);
		}
		sc.close();
		System.out.println(result);
	}
}
