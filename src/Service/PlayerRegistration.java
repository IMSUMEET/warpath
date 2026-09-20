package Service;

import java.util.*;

import Interfaces.IOInterface;
import Models.Player;
import Factory.PlayerFactory;
import Enums.PieceType;

public class PlayerRegistration {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;

    private final IOInterface ioInterface;
    private final PlayerFactory playerFactory;

    public PlayerRegistration(IOInterface ioInterface, PlayerFactory playerFactory){
        this.ioInterface = ioInterface;
        this.playerFactory = playerFactory;
    }

    public List<Player> registerPlayers(){
        int numberOfPlayers = getNumberOfPlayers();
        ioInterface.write("Enter player info for " + numberOfPlayers + " players one by one");
        List<Player> players = getPlayerInfo(numberOfPlayers);
        printPlayers(players);
        return players;
    }

    // Private Methods
    private int getNumberOfPlayers(){
        while (true) {
            ioInterface.write("Please Enter the number of players participating");
            String input = ioInterface.read();

            int numberOfPlayers;
            try {
                numberOfPlayers = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                ioInterface.write("Please enter a whole number [" + MIN_PLAYERS + " - " + MAX_PLAYERS + "]");
                continue;
            }

            if (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS) {
                ioInterface.write("Please enter valid number of players [" + MIN_PLAYERS + " - " + MAX_PLAYERS + "]");
                continue;
            }

            return numberOfPlayers;
        }
    }

    private List<Player> getPlayerInfo(int numberOfPlayers){

        List<Player> participants = new ArrayList<>();

        Map<String, PieceType> availablePieceType = new HashMap<>();
        for(PieceType pieceType : PieceType.values()){
            availablePieceType.put(pieceType.name().toLowerCase(), pieceType);
        }

        for(int i = 1; i <= numberOfPlayers; i++){
            ioInterface.write("Enter player" + i  + " name");
            String name = ioInterface.read();

            PieceType currentPlayerPieceType = null;

            while(currentPlayerPieceType == null){
                ioInterface.write("Select pieceType from below for " + name);
                // 1:Ember 2:Frost 3:Storm 4:Thorn
                ioInterface.write(availablePieceType.toString());

                String input = ioInterface.read().toLowerCase();

                if(availablePieceType.containsKey(input)){
                    currentPlayerPieceType = availablePieceType.get(input);
                    availablePieceType.remove(input);
                }else{
                    ioInterface.write("Invalid Piece Type, try again");
                }
            }

            Player player = playerFactory.createNewPlayer(name, currentPlayerPieceType);
            participants.add(player);
        }
        return participants;
    }

    private void printPlayers(List<Player> players){
        for(Player player : players){
            ioInterface.write(player.getPlayerName() + " has selected " + player.getPieceType());
        }
    }
}
