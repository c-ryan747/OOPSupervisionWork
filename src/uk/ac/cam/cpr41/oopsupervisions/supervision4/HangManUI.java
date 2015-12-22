package uk.ac.cam.cpr41.oopsupervisions.supervision4;

/**
 * Created by Callum Ryan on 22/12/15.
 */
public interface HangManUI {
    void updateUI(String word, Character[] incorrectGuesses, Character[] correctGuesses, HangManState state);
    void guessedLetter(char s);
    void newGame(boolean b);
}
