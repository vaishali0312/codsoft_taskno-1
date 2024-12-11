import java.util.Random;
import java.util.Scanner;
 class NumberGuessingGame {
public static void main(String args[]) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int roundsWon = 0;
boolean playAgain = true;
        while (playAgain) {
            // Set a limit on the number of attempts
            int attemptsLeft = 5;
            int targetNumber = random.nextInt(100) + 1;  // Generates a random number between 1 and 100
            boolean correctGuess = false;

            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");
            System.out.println("You have " + attemptsLeft + " attempts to guess the number.");

            // Loop for attempts
            while (attemptsLeft > 0 && !correctGuess) {
                System.out.print("\nEnter your guess: ");
                int userGuess = scanner.nextInt();

                // Check if the guess is correct, too high, or too low
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                    roundsWon++;
                } else if (userGuess > targetNumber) {
                    attemptsLeft--;
                    System.out.println("Your guess is too high! You have " + attemptsLeft + " attempts left.");
                } else {
                    attemptsLeft--;
                    System.out.println("Your guess is too low! You have " + attemptsLeft + " attempts left.");
                }

                if (attemptsLeft == 0 && !correctGuess) {
                    System.out.println("Sorry! You've run out of attempts. The correct number was " + targetNumber + ".");
                }
            }

            // Ask if the user wants to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String playAgainResponse = scanner.next();
            if (playAgainResponse.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        // Display the final score (rounds won)
        System.out.println("\nGame Over! You won " + roundsWon + " rounds.");
        scanner.close();
    }
}