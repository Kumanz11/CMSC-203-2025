package assignment6;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogTestStudent {

    private Dog dog;

    @BeforeEach
    void setUp() {
        dog = new Dog("name1", 5, "species1", "color1");
    }

    @Test
    void testGetAge() {
        assertEquals(5, dog.getAge());
    }

    @Test
    void testEqualsSameFields() {
        Dog anotherDog = new Dog("name1", 5, "species1", "color1");
        assertEquals(dog, anotherDog);
    }

    @Test
    void testNotEqualsDifferentName() {
        Dog differentDog = new Dog("name2", 5, "species1", "color1");
        assertNotEquals(dog, differentDog);
    }

    @Test
    void testNotEqualsDifferentAge() {
        Dog differentDog = new Dog("name1", 6, "species1", "color1");
        assertNotEquals(dog, differentDog);
    }
}
