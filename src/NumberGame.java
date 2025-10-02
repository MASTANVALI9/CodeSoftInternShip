import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1, max = 100; // Range of numbers
        int totalRounds = 0, totalWins = 0, totalAttempts = 0;
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attemptsLeft = 5; // Limit the number of attempts
            boolean guessedCorrectly = false;
            System.out.println("Guess the number between " + min + " and " + max + " (Attempts left: " + attemptsLeft + ")");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                totalAttempts++;
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    totalWins++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was: " + numberToGuess);
            }
            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Display user's score
        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + totalRounds);
        System.out.println("Rounds won: " + totalWins);
        System.out.println("Total attempts made: " + totalAttempts);

        scanner.close();
    }
}
