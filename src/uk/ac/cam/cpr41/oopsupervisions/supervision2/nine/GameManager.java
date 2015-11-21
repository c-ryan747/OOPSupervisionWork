package uk.ac.cam.cpr41.oopsupervisions.supervision2.nine;

import java.util.Scanner;

public class GameManager {
    private static final GameState state = new GameState();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Get information
        System.out.println("Enter your name: ");
        state.setName(scanner.next());

        while (true) {
            System.out.println("Enter the difficulty: ");
            try {
                state.setDifficulty(Integer.parseInt(scanner.next()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invaild difficulty");
            }
        }

        playRound();
    }

    private static boolean guess() {
        System.out.println(state);
        System.out.print("Enter a guess: ");
        try {
            GuessResult r =  state.guess(Integer.parseInt(scanner.next()));
            switch (r) {
                case Correct:
                    System.out.println("You won!");
                    return false;
                case GoLower:
                    System.out.println("Go Lower");
                    return true;
                case GoHigher:
                    System.out.println("Go Higher");
                    return true;
                case GameOver:
                    System.out.println("You lost :(");
                    return false;
            }
        } catch (NumberFormatException e) {
            System.out.print("Invaild guess");
        }
        return true;
    }

    private static void playRound() {
        while(true) {
            state.reset();
            while (guess()) continue;
            System.out.println("Play again? (Y/N)");
            String responce = scanner.next();
            if (responce.equals("Y")) {
                continue;
            } else {
                break;
            }
        }

    }
}
