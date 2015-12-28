package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * Data structure to store a word, and the characters of it that have been guessed
 */

public class Word {
    private char[] word;
    private boolean[] lettersHit;               // True if letter at index correctly guessed
    private Set<Character> incorrectLetters;    // Set of correct guesses
    private Set<Character> successfulLetters;   // Set of incorrect guesses

    public Word(String w) {
        word = w.toCharArray();

        // Setup
        lettersHit = new boolean[word.length];
        incorrectLetters = new TreeSet<>();
        successfulLetters = new TreeSet<>();
    }

    public Character[] getIncorrectLetters() {
        return incorrectLetters.toArray(new Character[incorrectLetters.size()]);
    }

    public Character[] getSuccessfulLetters() {
        return successfulLetters.toArray(new Character[successfulLetters.size()]);
    }

    public boolean wordComplete() {
        // If any letter isn't hit return false
        for (boolean b : lettersHit) {
            if (!b) return false;
        }

        return true;
    }

    public void guessLetter(char l) {
        boolean letterCorrect = false;

        // Mark all occurrences of that letter as hit
        // And add to successfulLetters
        for (int i = 0; i < word.length; i++) {
            if (l == word[i]) {
                lettersHit[i] = true;
                successfulLetters.add(l);
                letterCorrect = true;
            }
        }

        // Else add to incorrectLetters
        if (!letterCorrect) incorrectLetters.add(l);
    }

    // Return full word
    @Override
    public String toString() {
        return String.valueOf(word);
    }

    // Return word with un-guessed characters hidden (as underscores)
    public String hiddenString() {
        String result = "";

        for (int i = 0; i < word.length; i++) {
            if (lettersHit[i]) {
                result += word[i];
            } else {
                result += "_";
            }
        }

        return result;
    }
}
