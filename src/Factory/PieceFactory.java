package Factory;

public class PieceFactory{
    public Piece createNewPiece(PieceType pieceType){
        return new Piece(pieceType);
    }
}