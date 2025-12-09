package assignment6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircusDriverTestStudent {
    private Circus circus;

    @BeforeEach
    void setUp() {
        circus = new Circus();
    }

    @Test
    void testAddAnimal() {
        Dog dog = new Dog("name1", 3, "Breed1", "Color1");
        circus.addAnimal(dog);

        List<Animal> animals = circus.getAnimals();
        assertEquals(1, animals.size());
        assertEquals("name1", animals.get(0).getName());
    }

    @Test
    void testAddAnotherAnimal() {
        Lion lion = new Lion("name2", 5, "Species2", "Color2");
        circus.addAnimal(lion);

        List<Animal> animals = circus.getAnimals();
        assertEquals(1, animals.size());
        assertEquals("name2", animals.get(0).getName());
    }

    @Test
    void testSortAnimalsByAge() {
        Dog dog = new Dog("name1", 3, "Breed1", "Color1");
        Lion lion = new Lion("name2", 5, "Species2", "Color2");
        circus.addAnimal(dog);
        circus.addAnimal(lion);

        circus.sortAnimalsByAge();

        List<Animal> animals = circus.getAnimals();
        assertEquals("name1", animals.get(0).getName());
        assertEquals("name2", animals.get(1).getName());
    }

    @Test
    void testSortAnimalsByName() {
        Dog dog = new Dog("name1", 3, "Breed1", "Color1");
        Lion lion = new Lion("name2", 5, "Species2", "Color2");
        circus.addAnimal(lion);
        circus.addAnimal(dog);

        circus.sortAnimalsByName();

        List<Animal> animals = circus.getAnimals();
        assertEquals("name1", animals.get(0).getName());
        assertEquals("name2", animals.get(1).getName());
    }

    @Test
    void testSearchAnimalByName() {
        Dog dog = new Dog("name1", 3, "Breed1", "Color1");
        Lion lion = new Lion("name2", 5, "Species2", "Color2");
        circus.addAnimal(dog);
        circus.addAnimal(lion);
        circus.searchAnimalByName("name2");
        circus.searchAnimalByName("name1");
    }
}
