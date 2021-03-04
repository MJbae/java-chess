package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("체스말 생성에 따라 색, 타입, 표현문자 상태 확인 ")
    void createPiece() {
        Position position = new Position(1, 1);

        verifyPiece(Piece.PieceMaker.createWhitePawn(position), Color.WHITE,Type.PAWN);
        verifyPiece(Piece.PieceMaker.createBlackKnight(position), Color.BLACK,Type.KNIGHT);
        verifyPiece(Piece.PieceMaker.createWhiteRook(position), Color.WHITE,Type.ROOK);
        verifyPiece(Piece.PieceMaker.createWhiteBishop(position), Color.WHITE,Type.BISHOP);
        verifyPiece(Piece.PieceMaker.createBlackQueen(position), Color.BLACK, Type.QUEEN);
        verifyPiece(Piece.PieceMaker.createWhiteKing(position), Color.WHITE,Type.KING);


    }

    private void verifyPiece(final Piece piece, Color color, Type type) {
        String representation = type.getRepresentation(color);

        assertAll(
                () -> verifyColorOfPiece(piece, color),
                () -> verifyTypeOfPiece(piece, type),
                () -> verifyRepresentationOfPiece(piece, representation)
        );
    }

    private void verifyColorOfPiece(final Piece piece, Color color) {
        assertThat(piece.getColor()).isEqualTo(color);
    }

    private void verifyTypeOfPiece(final Piece piece, Type type) {
        assertThat(piece.getType()).isEqualTo(type);
    }

    private void verifyRepresentationOfPiece(final Piece piece, final String representation) {
        assertThat(piece.getRepresentation()).isEqualTo(representation);
    }
}

