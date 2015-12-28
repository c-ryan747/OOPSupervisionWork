package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * Provides a textual UI for a game on hang man in the console
 */

public abstract class HangManTextualUI implements HangManUI {
    // Ascii art ftw
    private final static String[] stages = {"  +---+   \n  |   |   \n      |   \n      |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n      |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n  |   |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|   |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n /    |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n / \\  |   \n      |   \n========= \n"};

    private final Scanner scanner = new Scanner(System.in);

    // To be filled in by controller (or subclass)
    public abstract void guessedLetter(char s);
    public abstract void newGame(boolean b);

    public void updateUI(String word, Character[] incorrectGuesses, Character[] correctGuesses, HangManState state) {
        switch (state) {
            case Guessing:
                System.out.println(stages[incorrectGuesses.length]);

                System.out.println("Word: " + word);
                System.out.println("Letter Guessed incorrectly: " + Arrays.toString(incorrectGuesses));
                System.out.println("Letter Guessed correctly  : " + Arrays.toString(correctGuesses));
                System.out.println("Guess a letter: ");

                // Take the next character inputted to the console
                guessedLetter(scanner.next().charAt(0));
                break;
            case Win:
                System.out.println("Congratulations the word was: " + word);

                askToPlayAgain();
                break;
            case Loss:
                System.out.println("Game over :(");
                System.out.println("The word was: " + word);

                askToPlayAgain();
                break;
        }
    }

    private void askToPlayAgain() {
        System.out.println("Play again? (Y/N)");

        String response = scanner.next();
        if (response.equalsIgnoreCase("Y")) {
            newGame(true);
        } else {
            newGame(false);
        }
    }
}
