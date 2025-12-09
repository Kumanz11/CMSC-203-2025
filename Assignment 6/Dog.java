package assignment6;



public class Dog implements Animal, Cloneable {
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    public Dog(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("Run");
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");

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
    public Dog clone() {
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Dog(name, age, species, color);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        if (!(obj instanceof Dog))
            return false;
        
        Dog other = (Dog) obj;
        return this.age == other.age &&
               this.name.equals(other.name) &&
               this.species.equals(other.species) &&
               this.color.equals(other.color);
    }
    @Override
    public String toString() {
        return String.format("Dog [Name: %s, Age: %d, Species: %s, Color: %s]",
                name, age, species, color);
    }
}
