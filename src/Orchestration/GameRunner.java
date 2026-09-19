package Orchestration;

import Interfaces.IOInterface;

public class GameRunner {

    // Private Constants
    private final IOInterface ioInterface;
    private final Game game;

    // Contructor
    public GameRunner(IOInterface ioInterface, Game game){
        this.ioInterface = ioInterface;
        this.game = game;
    }

    // Public methods
    public void run(){
        boolean isRunning = true;

        // Greeting user
        ioInterface.write("Welcome to the game.");
    
        while(isRunning){
            printMenu();

            String input = ioInterface.read();
            int option = 0;

            try {
                option = Integer.parseInt(input); // abc -> throw NumberFormatException
                switch(option){
                    case 1:
                        game.start();
                        break;
                    case 2:
                        game.aboutTheGame();
                        break;
                    case 3:
                        // Exit
                        ioInterface.write("Bye bye");
                        isRunning = false;
                        break;
                    default:
                        ioInterface.write("Invalid Input try again");
                        break;
                }
            } catch (NumberFormatException e) {
                ioInterface.write("Invalid input " + e + "TRY Again");
            }
        }
    }

    // Private methods
    private void printMenu(){
        ioInterface.write("Choose option.");
        ioInterface.write("1. Start the Game");
        ioInterface.write("2. About the Game");
        ioInterface.write("3. Exit");
    }
}
