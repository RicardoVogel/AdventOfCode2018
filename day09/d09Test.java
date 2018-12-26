import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class d09Test {
    @Test
    public void testBasic() {
        assertEquals(32, d09.winningmarble(9, 25));
    }

    @Test
    public void test10() {
        assertEquals(8317, d09.winningmarble(10, 1618));
    }

    @Test
    public void test13() {
        assertEquals(146373, d09.winningmarble(13, 7999));
    }

    @Test
    public void test17() {
        assertEquals(2764, d09.winningmarble(17, 1104));
    }

    @Test
    public void test21() {
        assertEquals(54718, d09.winningmarble(21, 6111));
    }

    @Test
    public void test30() {
            assertEquals(37305, d09.winningmarble(30, 5807));
        }
}