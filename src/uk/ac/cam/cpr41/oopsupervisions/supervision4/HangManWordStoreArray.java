package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Callum Ryan on 22/12/15.
 *
 * An implementation of HangManWordStore using an ArrayList for storage
 *
 * Comparison to HangManWordStoreLowMem
 *   It's x1.5 slower on first call
 *   It's x4000 faster on subsequent calls
 *   But uses more memory
 */

public class HangManWordStoreArray implements HangManWordStore {
    private final ArrayList<String> words;
    private Random rand;

    public HangManWordStoreArray(Path f) {
        words = new ArrayList<>();

        // Attempt to read all lines into words list
        try (Stream<String> lines = Files.lines(f)) {
            lines.forEach(words::add);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Word getNewWord() {
        // Lazily create Random object
        if (rand == null) {
            rand = new Random();
        }

        // Return word at random index
        int index = rand.nextInt(words.size() - 1);
        return new Word(words.get(index));
    }
}
