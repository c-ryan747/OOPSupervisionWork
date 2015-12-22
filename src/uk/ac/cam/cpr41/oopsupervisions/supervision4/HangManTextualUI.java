package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Callum Ryan on 22/12/15.
 */
public abstract class HangManTextualUI implements HangManUI {
    public static String[] stages = {"  +---+   \n  |   |   \n      |   \n      |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n      |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n  |   |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|   |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n      |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n /    |   \n      |   \n========= \n",
                                     "  +---+   \n  |   |   \n  0   |   \n /|\\  |   \n / \\  |   \n      |   \n========= \n"};
    public Scanner scanner = new Scanner(System.in);

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

                guessedLetter(scanner.next().charAt(0));
                break;
            case Win:
                System.out.println("Conguratulations the word was: " + word);

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
