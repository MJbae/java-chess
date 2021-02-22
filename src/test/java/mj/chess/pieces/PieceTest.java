package mj.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class PieceTest {

    @Test
    @DisplayName("체스말 생성에 따라 색, 타입, 표현문자 상태 확인 ")
    void createPiece() {
        assertAll(
                () -> verifyPiece(Piece.createWhitePawn(), Color.WHITE, Type.PAWN),
                () -> verifyPiece(Piece.createBlackPawn(), Color.BLACK, Type.PAWN)
        );
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

    @Test
    @DisplayName("모든 기물에 대해 흑백 상태 확인")
    void checkIsWhiteOrBlack() {
        for (Type eachType : Type.values()) {
            assertAll(
                    () -> verifyIsBlack(eachType),
                    () -> verifyIsWhite(eachType)
            );
        }
    }

    private void verifyIsWhite(Type type) {
        switch (type) {
            case PAWN:
                assertThat(Piece.createWhitePawn().isWhite()).isTrue();
                break;
            case KNIGHT:
                assertThat(Piece.createWhiteKnight().isWhite()).isTrue();
                break;
            case ROOK:
                assertThat(Piece.createWhiteRook().isWhite()).isTrue();
                break;
            case BISHOP:
                assertThat(Piece.createWhiteBishop().isWhite()).isTrue();
                break;
            case QUEEN:
                assertThat(Piece.createWhiteQueen().isWhite()).isTrue();
                break;
            case KING:
                assertThat(Piece.createWhiteKing().isWhite()).isTrue();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private void verifyIsBlack(Type type) {
        switch (type) {
            case PAWN:
                assertThat(Piece.createBlackPawn().isBlack()).isTrue();
                break;
            case KNIGHT:
                assertThat(Piece.createBlackKnight().isBlack()).isTrue();
                break;
            case ROOK:
                assertThat(Piece.createBlackRook().isBlack()).isTrue();
                break;
            case BISHOP:
                assertThat(Piece.createBlackBishop().isBlack()).isTrue();
                break;
            case QUEEN:
                assertThat(Piece.createBlackQueen().isBlack()).isTrue();
                break;
            case KING:
                assertThat(Piece.createBlackKing().isBlack()).isTrue();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
