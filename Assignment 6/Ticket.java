package assignment6;
public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }
    
    public double calculatePrice() {
        double price = basePrice;

        if (dayOfWeek.equals("monday") ||
            dayOfWeek.equals("tuesday") ||
            dayOfWeek.equals("wednesday") ||
            dayOfWeek.equals("thursday") ||
            dayOfWeek.equals("friday")) 
        {
            price *= 0.90;
        }

        if (age <= 12) {
            price *= 0.90;
        } 
        else if (age >= 13 && age <= 22) {
            price *= 0.90; 
        }
        else if (age >= 65) {
            price *= 0.95; 
        }

        return price;
    }

    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}
