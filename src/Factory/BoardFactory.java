package Factory;

public class BoardFactory {
    public Board createNewBoard(List<Player> players){
        return new Board(players);
    }
}