import Orchestration.GameRunner;

import java.util.Scanner;
import IO.ConsoleIO;
import Interfaces.IOInterface;
import Orchestration.Game;
import Factory.PlayerFactory;

public class Warpath {
    public static void main(String[] args){
        // DI - will handled by this 
        // This class will be the Entry point
        Scanner scanner = new Scanner(System.in);

        IOInterface ioInterface = new ConsoleIO(scanner);

        PlayerFactory playerFactory = new PlayerFactory();
        BoardFactory boardFactory = new BoardFactory();
        DiceFactory diceFactory = new DiceFactory();

        Game game = new Game(ioInterface, playerFactory, boardFactory, diceFactory);
        GameRunner gameRunner = new GameRunner(ioInterface, game);
        gameRunner.run();
        
        scanner.close();
    }
}
