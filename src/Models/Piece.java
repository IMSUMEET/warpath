package Models;

import Enums.PieceType;

public class Piece {
    private final PieceType pieceType;
    private final String emote;

    public Piece(PieceType pieceType, String emote){
        this.pieceType = pieceType;
        this.emote = emote;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public String getEmote(){
        return this.emote;
    }

}
