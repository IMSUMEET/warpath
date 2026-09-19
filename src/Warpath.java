import Orchestration.GameRunner;

import IO.ConsoleIO;
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
        try (ConsoleIO ioInterface = new ConsoleIO()) {
            PlayerFactory playerFactory = new PlayerFactory();
            DiceFactory diceFactory = new DiceFactory();
            TileFactory tileFactory = new TileFactory();
            PieceFactory pieceFactory = new PieceFactory();
            BoardFactory boardFactory = new BoardFactory(tileFactory, pieceFactory);

            Game game = new Game(ioInterface, playerFactory, boardFactory, diceFactory);
            GameRunner gameRunner = new GameRunner(ioInterface, game);
            gameRunner.run();
        }
    }
}
