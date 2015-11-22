package uk.ac.cam.cpr41.oopsupervisions.supervision2.q9;

import java.util.Random;

public class GameState {
    private String name;
    private int difficulty;
    private int numOfGuessesSoFar;
    private int numberToGuess;
    private int numWon;
    private int numPlayed;

    public void reset() {
        this.numOfGuessesSoFar = 0;

        Random r  = new Random();
        this.numberToGuess = r.nextInt(100);
    }

    public GuessResult guess(int x) {
        numOfGuessesSoFar++;
        if (x == numberToGuess) {
            this.numWon++;
            this.numPlayed++;
            return GuessResult.Correct;
        }
        if (numOfGuessesSoFar == difficulty) {
            this.numPlayed++;
            return GuessResult.GameOver;
        }
        if (x > numberToGuess) return GuessResult.GoLower;
        return GuessResult.GoHigher;
    }

    @Override
    public String toString() {
        return "\nOverall: Number Played: " + numPlayed + " Number Won: " + numWon + "\nCurrent: Guesses Left: " + (difficulty - numOfGuessesSoFar) + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        if (difficulty > 0) {
            this.difficulty = difficulty;
        } else {
            throw new NumberFormatException();
        }
    }

    public int getNumOfGuessesSoFar() {
        return numOfGuessesSoFar;
    }

    public void setNumOfGuessesSoFar(int numOfGuessesSoFar) {
        this.numOfGuessesSoFar = numOfGuessesSoFar;
    }
}
