package assignment6;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LionStudentTest {

    private Lion lion;

    @BeforeEach
    void setUp() {
        lion = new Lion("name1", 6, "species1", "color1");
    }

    @Test
    void testGetName() {
        assertEquals("name1", lion.getName());
    }

    @Test
    void testEqualsWithSameAttributes() {
        Lion sameLion = new Lion("name1", 6, "species1", "color1");
        assertEquals(lion, sameLion);
    }

    @Test
    void testNotEqualsDifferentName() {
        Lion differentLion = new Lion("name2", 6, "species1", "color1");
        assertNotEquals(lion, differentLion);
    }

    @Test
    void testNotEqualsDifferentAge() {
        Lion differentLion = new Lion("name1", 7, "species1", "color1");
        assertNotEquals(lion, differentLion);
    }
}
