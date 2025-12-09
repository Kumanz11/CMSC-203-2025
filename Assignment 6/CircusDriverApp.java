package assignment6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CircusDriverApp {
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");

                // Use validateInput method
                int choice = 0;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        choice = validateInput(scanner);
                        validInput = true;
                    } catch (CustomInputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Please enter your choice again: ");
                    }
                }

                switch (choice) {
                    case 1:
                        handleAddAnimal(circus, scanner);
                        break;
                    case 2:
                        handleAddPerson(circus, scanner);
                        break;
                    case 3:
                        handleAddBuilding(circus, scanner);
                        break;
                    case 4:
                        handleGenerateTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Displaying all animals:");
                        System.out.println("----------------------");
                        circus.displayAllAnimals();
                        break;
                    case 6:
                        System.out.println("Displaying all persons:");
                        System.out.println("----------------------");
                        circus.displayAllPersons();
                        break;
                    case 7:
                        System.out.println("Displaying all buildings:");
                        System.out.println("------------------------");
                        circus.displayAllBuildings();
                        break;
                    case 8:
                        System.out.println("Sorting animals by age...");
                        circus.sortAnimalsByAge();
                        System.out.println("Animals sorted by age.");
                        break;
                    case 9:
                        System.out.println("Sorting animals by name...");
                        circus.sortAnimalsByName();
                        System.out.println("Animals sorted by name.");
                        break;                       
                    case 10:
                        System.out.print("Enter the name of the animal to search: ");
                        scanner.nextLine(); // Consume newline
                        String searchName = scanner.nextLine();
                        circus.searchAnimalByName(searchName);
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            } 
        }

        scanner.close();
    }

    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // consume bad input
            throw new CustomInputMismatchException("Invalid input. Please enter a number.");
        }
    }

    private static void handleAddAnimal(Circus circus, Scanner scanner) {
        System.out.println("\nSelect animal type to add:");
        System.out.println("1. Dog");
        System.out.println("2. Horse");
        System.out.println("3. Bird");
        System.out.println("4. Lion");
        System.out.print("Enter choice: ");
        int choice = readIntSafe(scanner);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = readIntSafe(scanner);
        System.out.print("Enter species: ");
        String species = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        switch (choice) {
            case 1:
                circus.addAnimal(new Dog(name, age, species, color));
                break;
            case 2:
                circus.addAnimal(new Horse(name, age, species, color));
                break;
            case 3:
                circus.addAnimal(new Bird(name, age, species, color));
                break;
            case 4:
                circus.addAnimal(new Lion(name, age, species, color));
                break;
            default:
                System.out.println("Invalid choice. No animal added.");
                return;
        }
        System.out.println("Animal added.");
    }

    private static void handleAddPerson(Circus circus, Scanner scanner) {
        System.out.println("\nSelect person type to add:");
        System.out.println("1. Clerk");
        System.out.println("2. Acrobatic");
        System.out.print("Enter choice: ");
        int choice = readIntSafe(scanner);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = readIntSafe(scanner);
        System.out.print("Enter years worked: ");
        int yearsWorked = readIntSafe(scanner);
        System.out.print("Enter job title: ");
        String job = scanner.nextLine();

        switch (choice) {
            case 1:
                circus.addPerson(new Clerk(name, age, yearsWorked, job));
                break;
            case 2:
                circus.addPerson(new Acrobatic(name, age, yearsWorked, job));
                break;
            default:
                System.out.println("Invalid choice. No person added.");
                return;
        }
        System.out.println("Person added.");
    }

    private static void handleAddBuilding(Circus circus, Scanner scanner) {
        System.out.println("\nSelect building type to add:");
        System.out.println("1. Arena");
        System.out.println("2. Ticketing Office");
        System.out.print("Enter choice: ");
        int choice = readIntSafe(scanner);

        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter length: ");
        double length = readDoubleSafe(scanner);
        System.out.print("Enter width: ");
        double width = readDoubleSafe(scanner);

        switch (choice) {
            case 1:
                circus.addBuilding(new Arena(color, length, width));
                break;
            case 2:
                circus.addBuilding(new TicketingOffice(color, length, width));
                break;
            default:
                System.out.println("Invalid choice. No building added.");
                return;
        }
        System.out.println("Building added.");
    }

    private static int readIntSafe(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private static double readDoubleSafe(Scanner scanner) {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private static void handleGenerateTicket(Scanner scanner) {
        double totalAmount = 0;
        double basePrice;
        StringBuilder ticketDetails = new StringBuilder();
        boolean addMoreTickets = true;

        System.out.print("\nEnter ticket base price: ");
        basePrice = scanner.nextDouble();
        scanner.nextLine();

        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        while (addMoreTickets) {
            // Day selection
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek day = DayOfWeek.values()[i];
                if (day.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, day);
                }
            }
            System.out.print("\nEnter your choice: ");
            int dayChoice = scanner.nextInt();
            scanner.nextLine();

            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
                System.out.println("Invalid choice. Please select a valid day.");
                continue;
            }

            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Customer type
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            System.out.print("\nEnter your choice: ");
            int customerType = scanner.nextInt();
            scanner.nextLine();

            double customerDiscount = 0.0;
            switch (customerType) {
                case 1 -> customerDiscount = 0.10;
                case 2 -> customerDiscount = 0.10;
                case 4 -> customerDiscount = 0.05;
            }

            // Seat selection
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            System.out.print("\nEnter your choice: ");
            int seatLocation = scanner.nextInt();
            scanner.nextLine();

            double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

            System.out.print("Enter number of tickets: ");
            int numberOfTickets = scanner.nextInt();
            scanner.nextLine();

            // Calculate total
            double price = basePrice * (1 - dayDiscount) * (1 - customerDiscount) * (1 - seatDiscount) * seatMultiplier;
            double totalPrice = price * numberOfTickets;
            totalAmount += totalPrice;

            ticketDetails.append(String.format("%d x tickets for %s on %s: $%.2f%n", numberOfTickets, switch(customerType){
                case 1 -> "child";
                case 2 -> "student";
                case 3 -> "adult";
                case 4 -> "senior";
                default -> "unknown";
            }, selectedDay, totalPrice));

            // Add more tickets
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreTickets = response.equals("y");
        }

        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails);
        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }
}
