/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Extrasensory perception game 
 * Due: 09-15-25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   
* any source. I have not given my code to any student.
 * Print your Name here: Kevin Umanzor
*/
package assignment1;

import java.util.Scanner; 
import java.io.*;
import java.util.Random; 

public class ESPGame {
											// 
    public static void main(String[] args)throws IOException {
    	
    	// Declaring option integer constant values
        final int TOTAL_COLORS = 16; 
        final int OPTION_B_COLORS = 10; 
        final int OPTION_C_COLORS = 5; 
        
        // Declaring color string constant values
        final String COLOR1 = "black", COLOR2 = "white", COLOR3 = "gray", COLOR4 = "silver",
                COLOR5 = "maroon", COLOR6 = "red", COLOR7 = "purple", COLOR8 = "fuchsia",
                COLOR9 = "green", COLOR10 = "lime", COLOR11 = "olive", COLOR12 = "yellow",
                COLOR13 = "navy", COLOR14 = "blue", COLOR15 = "teal", COLOR16 = "aqua";
        
        String option, repeat = "yes";
        int lastWinCount = 0; 
        
        Scanner keyboard = new Scanner(System.in); 
        Random rand = new Random();
       
        System.out.println("CMSC203 Assignment1: Test your ESP skills!\r\n"+ "Welcome to ESP - extrasensory perception!\r\n"+ "Would you please choose one of the 4 options from the menu:\r\n" + "");
      
        
       // Start of game loop 
        while (repeat.equalsIgnoreCase("yes")) {
        	
        	// Display Menu 
            System.out.println("a. 16 Colors?");
            System.out.println("b. 10 Colors?");
            System.out.println("c. 5 Colors?");
            System.out.println("d. Exit Menu");
            System.out.print("Enter the option: ");
            option = keyboard.nextLine(); 
        	
        	System.out.print("Enter the name of a file: ");  
            String inputFileName = keyboard.nextLine(); 
            
            File file = new File(inputFileName);  
            Scanner inputFile = new Scanner(file); 
            
            int rounds = 1, winCount = 0, colorRange = 0; 
            
                       
            //if statement to determine what option was chosen and display the amount of colors the player wants to use
            if(option.equalsIgnoreCase("a")) {
                while (inputFile.hasNext()){   
                    String color = inputFile.nextLine(); 
                    System.out.println(color);  
                    colorRange = TOTAL_COLORS;
                } 
            } else if(option.equalsIgnoreCase("b")) {
                for(int i = 0; i < OPTION_B_COLORS; i++) {
                    String color = inputFile.nextLine(); 
                    System.out.println(color);
                    colorRange = OPTION_B_COLORS;
                }
            } else if(option.equalsIgnoreCase("c")) {
                for(int i = 0; i < OPTION_C_COLORS; i++) {
                    String color = inputFile.nextLine(); 
                    System.out.println(color);
                    colorRange = OPTION_C_COLORS;
                }
            } else if(option.equalsIgnoreCase("d")) {
                break; 
            }
            // Start of rounds loop
            while (rounds < 4){
            	System.out.println("Round " + rounds);
            	//Generates random number from 1 to colorRange (determined by option chosen)
                int randomNum = rand.nextInt(colorRange) + 1;  
                
               // Switch statement to determine what color corresponds to random generated number
               String randomColor = switch(randomNum) {
                    case 1 -> COLOR1; 
                    case 2 -> COLOR2; 
                    case 3 -> COLOR3; 
                    case 4 -> COLOR4; 
                    case 5 -> COLOR5; 
                    case 6 -> COLOR6; 
                    case 7 -> COLOR7; 
                    case 8 -> COLOR8; 
                    case 9 -> COLOR9; 
                    case 10 -> COLOR10; 
                    case 11 -> COLOR11; 
                    case 12 -> COLOR12; 
                    case 13 -> COLOR13; 
                    case 14 -> COLOR14; 
                    case 15 -> COLOR15; 
                    case 16 -> COLOR16; 
                    default -> "";
                };
                
                System.out.print("I am thinking of a color. Is it one of the listed colors above?\nEnter your guess: ");
                String colorChoice = keyboard.nextLine();
              
                System.out.println("I was thinking of " + randomColor);
                
                if(colorChoice.equalsIgnoreCase(randomColor)) {
                    winCount++;
                }
                rounds++;
            }
          
            System.out.println("Game Over");
            System.out.println("You guessed " + winCount + " out of 3 correctly.");
            lastWinCount = winCount; 
            
            System.out.print("Would you like to continue the game? (Yes/No): ");
            repeat = keyboard.nextLine();
            
            inputFile.close();
        }

        System.out.print("Enter your name: ");
        String name = keyboard.nextLine();
        System.out.print("Describe yourself: ");
        String desc = keyboard.nextLine();
        System.out.print("Due Date: ");
        String date = keyboard.nextLine();

        System.out.println("Username: " + name);
        System.out.println("User Description: " + desc);
        System.out.println("Date: " + date);
      
        PrintWriter outputFile = new PrintWriter("EspGameResults.txt");
        outputFile.println("Game Over");
        outputFile.println("You guessed " + lastWinCount+ " out of 3 correctly.");
        outputFile.println("Due Date: " + date);
        outputFile.println("Username: " + name);
        outputFile.println("User Description: " + desc);
        outputFile.println("Date: " + date);
        
        outputFile.close();
        keyboard.close();
    }
}
