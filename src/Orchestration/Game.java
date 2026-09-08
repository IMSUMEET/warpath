package Orchestration;

import java.util.*;

import Interfaces.IOInterface;
import Models.Player;
import Factory.PlayerFactory;
import Enums.PieceType;

public class Game {
    // all players: List<Player>
    // board 
    // Dice
    // GameState // IN_PROGRESS GAME_OVER
    // winnner -> Player
    // PieceTypes
    // currentPlayerTurn : Player

    private final IOInterface ioInterface;
    private final PlayerFactory playerFactory;

    private List<Player> players;

    public Game(IOInterface ioInterface, PlayerFactory playerFactory){
        this.ioInterface = ioInterface;
        this.playerFactory = playerFactory;
        this.players = new ArrayList<>();
    }

    public void start(){
        int numberOfPlayers = getNumberOfPlayers();
        ioInterface.write("Enter player info for " + numberOfPlayers + " players one by one");
        this.players = getPlayerInfo(numberOfPlayers);
        Collections.shuffle(players);

        


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
        Map<String, PieceType> availablePieceType = new HashMap<>(
            Map.of(
                "ember", PieceType.EMBER,
                "frost", PieceType.FROST,
                "storm", PieceType.STORM,
                "thorn", PieceType.THORN
            )
        );
        
        for(int i = 1; i <= numberOfPlayers; i++){
            ioInterface.write("Enter player" + i  + " name");
            String name = ioInterface.read();
            
            PieceType currentPlayerPieceType = null;
                
            while(currentPlayerPieceType == null){
                ioInterface.write("Select pieceType from below for " + name);
                // 1:Ember 2:Frost 3:Storm 4:Thorn
                ioInterface.write(availablePieceType.toString());

                try {
                    String input = ioInterface.read().toLowerCase();
                    
                    if(availablePieceType.containsKey(input)){
                        currentPlayerPieceType = availablePieceType.get(input);
                        availablePieceType.remove(input);
                    }else{
                        throw new Exception();
                    }
                }catch (Exception e){
                    ioInterface.write("Invalid Piece Type " + e);
                }
            }

            Player player = playerFactory.createNewPlayer(name, currentPlayerPieceType);
            players.add(player);
        }
        printPlayers();
        return players;
    }

    private void printPlayers(){
        for(Player player : this.players){
            ioInterface.write(player.getPlayerName() + " has selected " + player.getPieceType());
        }
    }
}
