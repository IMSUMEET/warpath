package Orchestration;

import java.util.List;
import java.util.ArrayList;

import Interfaces.IOInterface;
import Models.Player;

public class Game {
    // all players: List<Player>
    // board 
    // Dice
    // GameState // IN_PROGRESS GAME_OVER
    // winnner -> Player
    // PieceTypes
    // PieceTypesThisGame
    // currentPlayerTurn : Player

    private final IOInterface ioInterface;

    private List<Player> players;

    public Game(IOInterface ioInterface){
        this.ioInterface = ioInterface;
        this.players = new ArrayList<>();
    }

    public void start(){
        int numberOfPlayers = getNumberOfPlayers();
        ioInterface.write("Enter player info for " + numberOfPlayers + " players one by one");
        this.players = getPlayerInfo(numberOfPlayers);

        
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
    private int getNumberOfPlayers(){
        int numberOfPlayers = 0;
        boolean validPlayerCount = false;
        while (!validPlayerCount) {
            try {
                ioInterface.write("Please Enter the number of players participating");
                String input = ioInterface.read();
                numberOfPlayers = Integer.parseInt(input);

                if(numberOfPlayers <= 0 || numberOfPlayers > 4){
                    throw new NumberFormatException();
                }
                validPlayerCount = true;
            } catch (NumberFormatException e) {
                ioInterface.write("NumberFormatException -> Please enter valid number of players [1 - 4]" + e);
            }
        }

        return numberOfPlayers;
    }

    private List<Player> getPlayerInfo(int numberOfPlayers){
        for(int i = 1; i <= numberOfPlayers; i++){
            ioInterface.write("Enter player" + i  + " name");
            String name = ioInterface.read();

            Player player = createNewPlayer(name);
            players.add(player);
        }

        return players;
    }

    private Player createNewPlayer(String playerName){
        return new Player(playerName);
    }
}
