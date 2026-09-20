package Factory;

import Models.Piece;
import Enums.PieceType;

public class PieceFactory{
    public Piece createNewPiece(int pieceId, PieceType pieceType){
        return new Piece(pieceId, pieceType);
    }
}