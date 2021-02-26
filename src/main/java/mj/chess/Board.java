package mj.chess;

import mj.chess.pieces.Color;
import mj.chess.pieces.Piece;
import mj.chess.pieces.Position;
import mj.chess.pieces.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtil.appendNewLine;

public class Board {
    private int numOfPieces = 0;
    private final int ROWS = 8;

    public static final int FIRST_ROW = 0;
    public static final int SECOND_ROW = 1;
    public static final int THIRD_ROW = 2;
    public static final int FORTH_ROW = 3;
    public static final int FIFTH_ROW = 4;
    public static final int SIXTH_ROW = 5;
    public static final int SEVENTH_ROW = 6;
    public static final int EIGHTH_ROW = 7;

    private List<Rank> ranks = new ArrayList<>(8);

    public Board() { }

    public void initialize() {
        ranks.add(Rank.initBlackRoyalPieces(FIRST_ROW));
        ranks.add(Rank.initBlackPawns(SECOND_ROW));
        ranks.add(Rank.initBlanks(THIRD_ROW));
        ranks.add(Rank.initBlanks(FORTH_ROW));
        ranks.add(Rank.initBlanks(FIFTH_ROW));
        ranks.add(Rank.initBlanks(SIXTH_ROW));
        ranks.add(Rank.initWhitePawns(SEVENTH_ROW));
        ranks.add(Rank.initWhiteRoyalPieces(EIGHTH_ROW));
    }

    public int countPieces() {
        return numOfPieces;
    }

    public String getLocationOfPieces() {
        return IntStream.range(0, ROWS)
                .mapToObj(row -> appendNewLine(getStringFromRow(getRank(row))))
                .collect(joining());
    }

    private String getStringFromRow(Rank row) {
        return row.getPieces().stream()
                .map(Piece::getRepresentation)
                .collect(joining());
    }

    private Rank getRank(int yCoordinate) {
        return ranks.get(yCoordinate);
    }

    public Piece findPiece(String position) {
        Position p = new Position(position);
        return ranks.get(p.getYIndex()).findPiece(p.getXIndex());
    }

    public void move(String position, Piece piece) {
        move(new Position(position), piece);
    }

    public void move(Position p, Piece piece) {
        ranks.get(p.getYIndex()).move(p.getXIndex(), piece);
    }

    public double caculcatePoint(Color color) {
        List<Piece> pieces = findPiecesByColor(color);
        double point = 0.0;
        for (Piece piece : pieces) {
            point += piece.getPoint(pieces);
        }

        return point;
    }
    public int countPieceByColorAndType(Color color, Type type) {
        int countPiece = 0;
        for (Rank rank : ranks) {
            countPiece += rank.countPieceByColorAndType(color, type);
        }
        return countPiece;
    }
    private List<Piece> findPiecesByColor(Color color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Rank rank : ranks) {
            pieces.addAll(rank.findPiecesByColor(color));
        }
        return pieces;
    }
}
