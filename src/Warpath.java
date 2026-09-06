import Orchestration.GameRunner;

import java.util.Scanner;
import IO.ConsoleIO;
import Interfaces.IOInterface;
import Orchestration.Game;

public class Warpath {
    public static void main(String[] args){
        // DI - will handled by this 
        // This class will be the Entry point
        Scanner scanner = new Scanner(System.in);

        IOInterface ioInterface = new ConsoleIO(scanner);
        Game game = new Game(ioInterface);
        GameRunner gameRunner = new GameRunner(ioInterface, game);
        gameRunner.run();
        
        scanner.close();
    }
}
