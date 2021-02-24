package mj.chess;

import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    List<Piece> pieces = new ArrayList<Piece>(8);

    Rank(){
    }

    public List<Piece> getPieces(){
        return pieces;
    }
    public Piece getPiece(int xCoordinate) {
        return pieces.get(xCoordinate);
    }

    @Override
    public String toString() {
        return pieces.toString();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
}
