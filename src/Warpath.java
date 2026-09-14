import Orchestration.GameRunner;

import java.util.Scanner;
import IO.ConsoleIO;
import Interfaces.IOInterface;
import Orchestration.Game;
import Factory.PlayerFactory;
import Factory.BoardFactory;
import Factory.DiceFactory;
import Factory.PieceFactory;
import Factory.TileFactory;

public class Warpath {
    public static void main(String[] args){
        // DI - will handled by this 
        // This class will be the Entry point
        Scanner scanner = new Scanner(System.in);

        IOInterface ioInterface = new ConsoleIO(scanner);

        PlayerFactory playerFactory = new PlayerFactory();
        BoardFactory boardFactory = new BoardFactory();
        DiceFactory diceFactory = new DiceFactory();
        TileFactory tileFactory = new TileFactory();
        PieceFactory pieceFactory = new PieceFactory();



        Game game = new Game(ioInterface, playerFactory, boardFactory, diceFactory, pieceFactory, tileFactory);
        GameRunner gameRunner = new GameRunner(ioInterface, game);
        gameRunner.run();
        
        scanner.close();
    }
}
