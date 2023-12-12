package codsoft;

import java.util.Random;
import java.util.Scanner;

public class num1 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        int maxAttempts = 4;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        boolean playAgain = true;

        while (playAgain) 
        {
            int targetNumber = random.nextInt(100);
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between 1 and 100 . Can you guess it?");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly)
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) 
                {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
                else if (userGuess < targetNumber) 
                {
                	
                    System.out.println("Too low! Try again.");
                }
                else 
                {
                    System.out.println("Too high! Try again.");
                }
                if (attempts == maxAttempts && !guessedCorrectly)
                {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                    break; 
                }
            }

            totalAttempts += attempts;
            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total attempts: " + totalAttempts);

        scanner.close();
    }
}

