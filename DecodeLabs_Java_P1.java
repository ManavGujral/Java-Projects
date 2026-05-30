import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {

            int target = random.nextInt(100) + 1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 7;

            System.out.println("\n===== NUMBER GUESSING GAME =====");
            System.out.println("Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (guess != target && attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                try {
                    guess = sc.nextInt();
                    attempts++;

                    if (guess > target) {
                        System.out.println("Too High!");
                    } 
                    else if (guess < target) {
                        System.out.println("Too Low!");
                    } 
                    else {
                        System.out.println("Correct! You guessed the number.");
                        score++;
                    }

                    System.out.println("Attempts left: " + (maxAttempts - attempts));

                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    sc.nextLine(); // flush buffer
                }
            }

            if (guess != target) {
                System.out.println("Game Over! The correct number was: " + target);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Play Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\nThank you for playing!");

        sc.close();
    }
}