import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class d2c1Test {

	@Test
	void test0() {
		String str = "abcdef\n" + "bababc\n" + "abbcde\n" + "abcccd\n" + "aabcdd\n" + "abcdee\n" + "ababab";
		Scanner sc = new Scanner(str);
		int res = d2c1.checksum(sc);
		assertEquals(12, res);
	}

	@Test
	void testl0() {
		String str = "aaabbcccdd\n";
		Scanner sc = new Scanner(str);
		int res = d2c1.checksum(sc);
		assertEquals(1, res);
	}
	
	@Test
	void teasdfstl0() {
		String str = "revtcubfeiehzsgxdoafwkqmlp\n";
		Scanner sc = new Scanner(str);
		int res = d2c1.checksum(sc);
		assertEquals(1, res);
	}

}
