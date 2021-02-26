package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
import mj.chess.pieces.Position;
import mj.chess.pieces.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static mj.chess.Board.*;


public class Rank {
    List<Piece> pieces = new ArrayList<Piece>(8);

    public static Rank initWhiteRoyalPieces(int index) {
        Rank rank = new Rank();

        rank.addPiece(Piece.PieceMaker.createWhiteRook(new Position(0, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteKnight(new Position(1, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteBishop(new Position(2, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteQueen(new Position(3, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteKing(new Position(4, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteBishop(new Position(5, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteKnight(new Position(6, index)));
        rank.addPiece(Piece.PieceMaker.createWhiteRook(new Position(7, index)));

        return rank;
    }

    public static Rank initWhitePawns(int index) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createWhitePawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank initBlanks(int index) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createBlank(new Position(i, index)));
        }
        return rank;
    }

    public static Rank initBlackPawns(int index) {
        Rank rank = new Rank();
        for (int i = 0; i < 8; i++) {
            rank.addPiece(Piece.PieceMaker.createBlackPawn(new Position(i, index)));
        }
        return rank;
    }

    public static Rank initBlackRoyalPieces(int index) {
        Rank rank = new Rank();

        rank.addPiece(Piece.PieceMaker.createBlackRook(new Position(0, index)));
        rank.addPiece(Piece.PieceMaker.createBlackKnight(new Position(1, index)));
        rank.addPiece(Piece.PieceMaker.createBlackBishop(new Position(2, index)));
        rank.addPiece(Piece.PieceMaker.createBlackQueen(new Position(3, index)));
        rank.addPiece(Piece.PieceMaker.createBlackKing(new Position(4, index)));
        rank.addPiece(Piece.PieceMaker.createBlackBishop(new Position(5, index)));
        rank.addPiece(Piece.PieceMaker.createBlackKnight(new Position(6, index)));
        rank.addPiece(Piece.PieceMaker.createBlackRook(new Position(7, index)));

        return rank;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getPiece(int xCoordinate) {
        return pieces.get(xCoordinate);
    }

    int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Piece piece : pieces) {
            if (piece.matchColorAndType(color, type)) {
                countPiece++;
            }
        }
        return countPiece;
    }
    Piece findPiece(int xPosition) {
        return pieces.get(xPosition);
    }

    public void move(int xPos, Piece piece) {
        pieces.set(xPos, piece);
    }

    public List<Piece> findPiecesByColor(Color color) {
        List<Piece> piecesByColor = new ArrayList<>();
        for (Piece piece : pieces) {
            piece.addPiecesByColor(color, piecesByColor);
        }
        return Collections.unmodifiableList(piecesByColor);
    }

    @Override
    public String toString() {
        return pieces.toString();
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
}
