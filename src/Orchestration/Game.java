package Orchestration;

import Interfaces.IOInterface;

public class Game {
    // all players
    // board 
    // Dice
    // GameState // IN_PROGRESS GAME_OVER
    // winnner -> Player
    // PieceTypes
    // PieceTypesThisGame
    // currentPlayerTurn : Player

    private final IOInterface ioInterface;

    public Game(IOInterface ioInterface){
        this.ioInterface = ioInterface;
    }

    public void start(){
        // getnumberof players
        // for number of players get their info and assign them pieces
        // shuffle player order and create board(numberOfPlayers, PieceTypesThisGame);
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

    // Private Methods
}
