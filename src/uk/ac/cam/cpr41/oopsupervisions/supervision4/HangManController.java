package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Callum Ryan on 22/12/15.
 */
public class HangManController {
    private WordStore wordStore;
    private Word wordToGuess;
    private HangManUI ui;

    public HangManController(Path file) {
        wordStore = new WordStore(file);

        ui = new HangManTextualUI() {
            @Override
            public void guessedLetter(char s) {
                wordToGuess.guessLetter(s);
                nextGuess();
            }

            @Override
            public void newGame(boolean b) {
                if (b) {
                    startNewGame();
                } else {
                    System.exit(1);
                }
            }
        };
        startNewGame();
    }

    public static void main(String[] args) {
        try {
            HangManController hmc = new HangManController(Paths.get(HangManController.class.getResource("words.txt").toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public void startNewGame() {
        wordToGuess = wordStore.getNewWord();
        nextGuess();
    }

    public void nextGuess() {
        if (wordToGuess.getIncorrectLetters().length == 6) {
            ui.updateUI(wordToGuess.toString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Loss);
        } else if (wordToGuess.wordComplete()) {
            ui.updateUI(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Win);
        } else {
            ui.updateUI(wordToGuess.hiddenString(), wordToGuess.getIncorrectLetters(), wordToGuess.getSuccessfulLetters(), HangManState.Guessing);
        }
    }
}
