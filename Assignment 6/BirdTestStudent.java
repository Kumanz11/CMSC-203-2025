package assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BirdTestStudent {

    private Bird bird;

    @BeforeEach
    void setUp() {
        bird = new Bird("name1", 2, "species1", "color1");
    }

    @Test
    void testGetName() {
        assertEquals("name1", bird.getName());
    }

    @Test
    void testEqualsWithSameAttributes() {
        Bird sameBird = new Bird("name1", 2, "species1", "color1");
        assertEquals(bird, sameBird);
    }

    @Test
    void testNotEqualsWithDifferentName() {
        Bird different = new Bird("name2", 2, "species1", "color1");
        assertNotEquals(bird, different);
    }
}
