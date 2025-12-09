package assignment6;
public class Bird implements Animal {
    // instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    // constructor
    public Bird(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
    public void move() {
    	System.out.println("Fly");
    }

    @Override
    public void makeSound() {
       System.out.println("chirp");
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
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if (o == null || !(o instanceof Bird))
            return false;
        
        Bird other = (Bird) o;
        
        return this.age == other.age &&
               ((this.name == null && other.name == null) ||
                (this.name != null && this.name.equals(other.name))) &&
               ((this.species == null && other.species == null) ||
                (this.species != null && this.species.equals(other.species))) &&
               ((this.color == null && other.color == null) ||
                (this.color != null && this.color.equals(other.color)));
    }

    @Override
    public String toString() {
        return String.format("Bird [Name: %s, Age: %d, Species: %s, Color: %s]",
                name, age, species, color);
    }
}
