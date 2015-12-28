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
    private HangManState state;

    private final int numOfStages = 6;

    // file : path to a file containing new line delimited word dictionary
    public HangManController(Path file) {
        // Setup UI and WordStore
        wordStore = new HangManWordStoreArray(file);
        ui = new HangManTextualUI() {
            @Override
            public void guessedLetter(char s) {
                wordToGuess.guessLetter(s);
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
        state = HangManState.Guessing;

        while (state.equals(HangManState.Guessing)) {
            if (wordToGuess.getIncorrectLetters().length == numOfStages) {
                // Game over
                state = HangManState.Loss;
            } else if (wordToGuess.wordComplete()) {
                // Game won
                state = HangManState.Win;
            }
            guess();
        }
    }

    // Decide on the game state and update the UI accordingly
    private void guess() {
        switch (state) {
            case Loss:
                ui.displayLoss(wordToGuess.toString(),     wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters());
                break;
            case Win:
                ui.displayWin(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters());
                break;
            case Guessing:
                ui.displayGuess(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters());
                break;
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
