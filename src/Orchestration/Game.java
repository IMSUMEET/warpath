package Orchestration;

import java.util.*;

import Enums.PieceType;
import Interfaces.IOInterface;
import Models.Player;
import Models.Dice;
import Models.Piece;
import Models.Board;
import Factory.BoardFactory;
import Factory.DiceFactory;
import Service.PlayerRegistration;

public class Game {
    // all players: List<Player>
    // board 
    // Dice
    // GameState // IN_PROGRESS GAME_OVER
    // winnner -> Player
    // PieceTypes
    // currentPlayerTurn : Player

    private final IOInterface ioInterface;
    private final PlayerRegistration playerRegistration;
    private final BoardFactory boardFactory;
    private final DiceFactory diceFactory;

    private List<Player> players;
    private Board board;
    private List<PieceType> activePieceTypes;

    public Game(
        IOInterface ioInterface,
        PlayerRegistration playerRegistration,
        BoardFactory boardFactory,
        DiceFactory diceFactory
        ){
        this.ioInterface = ioInterface;
        this.playerRegistration = playerRegistration;
        this.boardFactory = boardFactory;
        this.diceFactory = diceFactory;

        this.players = new ArrayList<>();
    }

    public void start(){
        this.players = playerRegistration.registerPlayers();
        this.activePieceTypes = getActivePieceTypes();
        this.board = boardFactory.createNewBoard(activePieceTypes);
        this.board.show();

        // players -> [pieceType <-> Faction] <-> | board

        // create board(players);
        // show board !
        // while GameState is not GAME_OVER
            // Each player rolls dice in (clockwise order)
            // store the current player dice roll (if the player rolls 4 or 8 move and roll again)
            // player choose which piece to move the dice roll value. board.move(Piece, diceValue) -> Handle cases or portal
            // if winner stop()
    }

    public void aboutTheGame(){
        ioInterface.write("Blah blah blah.");
    }

    private List<PieceType> getActivePieceTypes(){
        List<PieceType> list = new ArrayList<>();
        for(Player player : players){
            list.add(player.getPieceType());
        }
        return list;
    }
}
