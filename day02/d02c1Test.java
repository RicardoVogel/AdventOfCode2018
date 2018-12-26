import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

class d02c1Test {

	@Test
	void test0() {
		String str = "abcdef\n" + "bababc\n" + "abbcde\n" + "abcccd\n" + "aabcdd\n" + "abcdee\n" + "ababab";
		Scanner sc = new Scanner(str);
		int res = d02c1.checksum(sc);
		assertEquals(12, res);
	}

	@Test
	void testl0() {
		String str = "aaabbcccdd\n";
		Scanner sc = new Scanner(str);
		int res = d02c1.checksum(sc);
		assertEquals(1, res);
	}
	
	@Test
	void teasdfstl0() {
		String str = "revtcubfeiehzsgxdoafwkqmlp\n";
		Scanner sc = new Scanner(str);
		int res = d02c1.checksum(sc);
		assertEquals(1, res);
	}

}
