package uk.ac.cam.cpr41.oopsupervisions.supervision4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by Callum Ryan on 22/12/15.
 */
public class WordStore {
    private Path wordsFile;
    private int numberOfWords;

    public WordStore(Path f) {
        wordsFile = f;
        findNumberOfWordsInFile();
    }

    private void findNumberOfWordsInFile() {
        try (Stream<String> lines = Files.lines(wordsFile)) {
            numberOfWords = (int) lines.count();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Word getNewWord() {
        try (Stream<String> lines = Files.lines(wordsFile)) {
            Random r = new Random();
            int indexOfWord = r.nextInt(numberOfWords);

            Iterator<String> it = lines.iterator();
            int index = 0;
            while (it.hasNext()) {
                String s = it.next();
                if (index == indexOfWord) {
                    return new Word(s);
                }
                index++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return null;
    }
}
