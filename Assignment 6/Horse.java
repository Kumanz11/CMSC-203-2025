package assignment6;
public class Horse implements Animal {
    // instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    // constructor
    public Horse(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("Gallop");

    }

    @Override
    public void makeSound() {
        System.out.println("Neigh");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Horse))
            return false;

        Horse other = (Horse) obj;

        return this.age == other.age &&
               this.name.equals(other.name) &&
               this.species.equals(other.species) &&
               this.color.equals(other.color);
    }
    @Override
    public String toString() {
        return String.format("Horse [Name: %s, Age: %d, Species: %s, Color: %s]",
                name, age, species, color);
    }
}
