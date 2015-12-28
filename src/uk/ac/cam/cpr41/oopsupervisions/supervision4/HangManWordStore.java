package uk.ac.cam.cpr41.oopsupervisions.supervision4;

/**
 * Created by Callum Ryan on 28/12/15.
 *
 * Interface for all hang man word sources
 */

public interface HangManWordStore {
    // Will return a randomly selected word
    Word getNewWord();
}
