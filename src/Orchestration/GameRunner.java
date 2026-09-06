package Orchestration;

import Interfaces.IOInterface;

public class GameRunner {

    // Private Constants
    private final IOInterface ioInterface;
    private final Game game;


    // Private Variables
    private boolean isRunning;

    // Contructor
    public GameRunner(IOInterface ioInterface, Game game){
        this.ioInterface = ioInterface;
        this.game = game;
        this.isRunning = false;
    }

    // Public methods
    public void run(){
        this.isRunning = true;

        // Greeting user
        ioInterface.write("Welcome to the game.");
    
        while(isRunning){
            ioInterface.write("Choose option.");
            ioInterface.write("1. Start the Game");
            ioInterface.write("2. About the Game");
            ioInterface.write("3. Exit");

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
                        this.isRunning = false;
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

    // Private Methods
}
