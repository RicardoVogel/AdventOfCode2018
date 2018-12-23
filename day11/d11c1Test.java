import org.junit.Test;

import static org.junit.Assert.*;

public class d11c1Test {
    @Test
    public void powerLevelSimple() {
        assertEquals(4, d11c1.powerLevel(3, 5, 8));
    }

    @Test
    public void powerLevel0() {
        assertEquals(-5, d11c1.powerLevel(122, 79, 57));
    }

    @Test
    public void powerLevel1() {
        assertEquals(0, d11c1.powerLevel(217, 196, 39));
    }

    @Test
    public void powerLevel2() {
        assertEquals(4, d11c1.powerLevel(101, 153, 71));
    }
}