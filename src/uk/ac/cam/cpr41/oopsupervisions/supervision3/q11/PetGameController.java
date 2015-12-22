package uk.ac.cam.cpr41.oopsupervisions.supervision3.q11;


import java.util.Scanner;

public class PetGameController {
    private PetDataStore state;
    private final PetView view;
    private final Scanner scanner = new Scanner(System.in);
    private boolean shouldExit = false;

    public PetGameController() {
        state = new PetDataStore();
        view = new PetTextualView(state);
    }

    public void startGame() {
        while (!shouldExit) {
            view.outputState();
            options();
        }
    }

    private void options() {
        view.showOptions();
        boolean done = false;

        while (!done) {
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                shouldExit = true;
                return;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                view.displayMessge("Please input both a command and an argument");
                continue;
            } else {
                try {
                    // Interpret input
                    int command = Integer.parseInt(parts[0]);
                    int arg = Integer.parseInt(parts[1]);
                    switch (command) {
                        case 1:
                            feedPet(arg);
                            done = true;
                            break;
                        case 2:
                            sleepPet(arg);
                            done = true;
                            break;
                        case 3:
                            playWithPet(arg);
                            done = true;
                            break;
                        case 4:
                            discardPet(arg);
                            done = true;
                            break;
                        case 5:
                            createPet(arg);
                            done = true;
                            break;
                        default:
                            view.displayMessge("Invalid command");
                            break;
                    }
                } catch (NumberFormatException nfe) {
                    view.displayMessge("Input the command and argument as an integer");
                } catch (PetException pe) {
                    view.displayMessge(pe.getMessage());
                }
            }
        }
    }

    private void playWithPet(int x) throws PetException {
        Pet p = state.getPet(x);
        p.play();
    }

    private void sleepPet(int x) throws PetException {
        Pet p = state.getPet(x);
        p.sleep();
    }

    private void feedPet(int x) throws PetException {
        Pet p = state.getPet(x);
        p.feed();
    }

    private void discardPet(int x) throws PetException {
        state.removePet(x);
    }

    private void createPet(int x) throws PetException{
        state.addPet(x);
    }

    public static void main(String[] args ) {
        PetGameController pgc = new PetGameController();
        pgc.startGame();
    }
}
