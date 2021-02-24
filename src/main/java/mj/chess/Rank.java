package mj.chess;

import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Rank {
    List<Piece> pieces = new ArrayList<Piece>(8);

    Rank() {
    }

    public static Rank initWhiteRoyalPieces() {
        Rank rank = new Rank();

        rank.addPiece(Piece.PieceMaker.createWhiteRook());
        rank.addPiece(Piece.PieceMaker.createWhiteKnight());
        rank.addPiece(Piece.PieceMaker.createWhiteBishop());
        rank.addPiece(Piece.PieceMaker.createWhiteQueen());
        rank.addPiece(Piece.PieceMaker.createWhiteKing());
        rank.addPiece(Piece.PieceMaker.createWhiteBishop());
        rank.addPiece(Piece.PieceMaker.createWhiteKnight());
        rank.addPiece(Piece.PieceMaker.createWhiteRook());

        return rank;
    }

    public static Rank initWhitePawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createWhitePawn());
        }
        return rank;
    }

    public static Rank initBlanks() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createBlank());
        }
        return rank;
    }

    public static Rank initBlackPawns() {
        Rank rank = new Rank();
        for(int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createBlackPawn());
        }
        return rank;
    }

    public static Rank initBlackRoyalPieces() {
        Rank rank = new Rank();

        rank.addPiece(Piece.PieceMaker.createBlackRook());
        rank.addPiece(Piece.PieceMaker.createBlackKnight());
        rank.addPiece(Piece.PieceMaker.createBlackBishop());
        rank.addPiece(Piece.PieceMaker.createBlackQueen());
        rank.addPiece(Piece.PieceMaker.createBlackKing());
        rank.addPiece(Piece.PieceMaker.createBlackBishop());
        rank.addPiece(Piece.PieceMaker.createBlackKnight());
        rank.addPiece(Piece.PieceMaker.createBlackRook());

        return rank;
    }

    public List<Piece> getPieces() {
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
