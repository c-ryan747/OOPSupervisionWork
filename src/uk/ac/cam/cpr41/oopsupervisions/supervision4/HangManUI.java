package uk.ac.cam.cpr41.oopsupervisions.supervision4;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * Interface for hang man UI
 */

public interface HangManUI {
    // Output game state to the user and prompt for a response
    void updateUI(String word, Character[] incorrectGuesses, Character[] correctGuesses, HangManState state);

    // Methods to handle interaction
    // Filled in by controller (or subclass)
    void guessedLetter(char s);
    void newGame(boolean b);
}
