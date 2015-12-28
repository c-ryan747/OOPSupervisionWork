package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * Contains the logic for a game of hang man
 */

public class HangManController {
    private HangManWordStore wordStore;
    private Word wordToGuess;
    private HangManUI ui;

    private final int numOfStages = 6;

    // file : path to a file containing new line delimited word dictionary
    public HangManController(Path file) {
        // Setup UI and WordStore
        wordStore = new HangManWordStoreArray(file);
        ui = new HangManTextualUI() {
            @Override
            public void guessedLetter(char s) {
                wordToGuess.guessLetter(s);
                guess();
            }

            @Override
            public void newGame(boolean b) {
                if (b) {
                    startNewGame();
                }
            }
        };
    }

    public void startNewGame() {
        // Generate a new word
        wordToGuess = wordStore.getNewWord();

        guess();
    }

    // Decide on the game state and update the UI accordingly
    private void guess() {
        if (wordToGuess.getIncorrectLetters().length == numOfStages) {
            // Game over
            ui.updateUI(wordToGuess.toString(),     wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Loss);
        } else if (wordToGuess.wordComplete()) {
            // Game won
            ui.updateUI(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Win);
        } else {
            // Game in progress
            ui.updateUI(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Guessing);
        }
    }

    public static void main(String[] args) {
        // Create a new Controller with words.txt
        try {
            Path file = Paths.get(HangManController.class.getResource("words.txt").toURI());
            HangManController hmc = new HangManController(file);
            hmc.startNewGame();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
