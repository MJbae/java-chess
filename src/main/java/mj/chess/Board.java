package mj.chess;

import mj.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static mj.chess.utils.StringUtil.appendNewLine;

public class Board {
    private int numOfPieces = 0;
    private final int ROWS = 8;

    private final int FIRST_ROW = 0;
    private final int SECOND_ROW = 1;
    private final int THIRD_ROW = 2;
    private final int FORTH_ROW = 3;
    private final int FIFTH_ROW = 4;
    private final int SIXTH_ROW = 5;
    private final int SEVENTH_ROW = 6;
    private final int EIGHTH_ROW = 7;

    private List<Rank> ranks = new ArrayList<>(8);

    public Board() {
        initRows();
    }

    public void initialize() {
        ranks.add(Rank.initBlackRoyalPieces());
        ranks.add(Rank.initBlackPawns());
        ranks.add(Rank.initBlanks());
        ranks.add(Rank.initBlanks());
        ranks.add(Rank.initBlanks());
        ranks.add(Rank.initBlanks());
        ranks.add(Rank.initWhitePawns());
        ranks.add(Rank.initWhiteRoyalPieces());
    }

    public int countPieces() {
        return numOfPieces;
    }

    public String getLocationOfPieces() {
        return IntStream.range(0, ROWS)
                .mapToObj(row -> appendNewLine(getStringFromRow(getRank(row))))
                .collect(joining());
    }

    private void initRows() {
        ranks = new ArrayList<>(8);
    }

    private String getStringFromRow(Rank row) {
        return row.getPieces().stream()
                .map(Piece::getRepresentation)
                .collect(joining());
    }

    private Rank getRank(int yCoordinate){
        return ranks.get(yCoordinate);
    }
}
