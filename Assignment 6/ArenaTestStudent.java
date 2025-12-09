package assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArenaTestStudent {

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena("color1", 100.0, 50.0);
    }

    @Test
    void testConstructorAndInitialValues() {
        assertEquals("color1", arena.getColor());
        assertEquals(100.0, arena.getLength(), 0.001);
        assertEquals(50.0, arena.getWidth(), 0.001);
        assertEquals("Arena", arena.getBuildingType());
    }

    @Test
    void testSetSize() {
        arena.setSize(120.0, 80.0);
        assertEquals(120.0, arena.getLength(), 0.001);
        assertEquals(80.0, arena.getWidth(), 0.001);
    }

    @Test
    void testSetColor() {
        arena.setColor("color2");
        assertEquals("color2", arena.getColor());
    }

    @Test
    void testSetBuildingType() {
        arena.setBuildingType("type1");
        assertEquals("type1", arena.getBuildingType());
    }

    @Test
    void testToString() {
        String expected = "Arena [Color: color1, Length: 100.0, Width: 50.0]";
        assertEquals(expected, arena.toString());
    }
}
