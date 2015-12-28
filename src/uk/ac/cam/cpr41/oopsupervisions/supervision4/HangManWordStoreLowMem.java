package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * An implementation of HangManWordStore without storing the file in a data structure
 *
 * Comparison to HangManWordStoreArray
 *   It's x1.5 faster on first call
 *   It's x4000 slower on subsequent calls
 *   But uses less memory
 */

public class HangManWordStoreLowMem implements HangManWordStore {
    private Path wordsFile;
    private int numberOfWords;
    private Random rand;

    public HangManWordStoreLowMem(Path f) {
        wordsFile = f;
        findNumberOfWordsInFile();
    }

    private void findNumberOfWordsInFile() {
        // Casting from long to int here should be okay with most files
        // If not then it'll only take words from the first Integer.MAX_VALUE words
        try (Stream<String> lines = Files.lines(wordsFile)) {
            numberOfWords = (int) lines.count();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Word getNewWord() {
        try (Stream<String> lines = Files.lines(wordsFile)) {
            // Generate a random index
            if (rand == null) {
                rand = new Random();
            }
            int indexOfWord = rand.nextInt(numberOfWords - 1);

            // Return the word at that index
            String wordAtIndex = lines.skip(Integer.max(0, indexOfWord - 1)).findFirst().get();
            return new Word(wordAtIndex);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
