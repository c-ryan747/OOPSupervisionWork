package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Callum Ryan on 22/12/15.
 */

public class Word {
    private char[] word;
    private boolean[] lettersHit;
    private Set<Character> incorrectLetters;
    private Set<Character> successfulLetters;

    public Word(String w) {
        word = w.toCharArray();
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
        for (boolean b : lettersHit) {
            if (!b) return false;
        }

        return true;
    }

    public void guessLetter(char l) {
        boolean letterCorrect = false;
        for (int i = 0; i < word.length; i++) {
            if (l == word[i]) {
                lettersHit[i] = true;
                successfulLetters.add(l);
                letterCorrect = true;
            }
        }

        if (!letterCorrect) incorrectLetters.add(l);
    }

    @Override
    public String toString() {
        return String.valueOf(word);
    }

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
