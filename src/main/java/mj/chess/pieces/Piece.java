package mj.chess.pieces;

import java.util.List;

public class Piece {

    private final Color color;
    private final Type type;
    private final String representation;
    private final Position position;

    private Piece(Color color, Type type, Position position) {

        this.color = color;
        this.type = type;
        this.representation = type.getRepresentation(color);
        this.position = position;

        validateColor(this.color);
        validateType(this.type);
        validateRepresentation(this.representation);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public String getRepresentation() {
        return representation;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWhite() {
        return matchColor(Color.WHITE);
    }

    public boolean isBlack() {
        return matchColor(Color.BLACK);
    }

    public boolean matchColorAndType(Color color, Type type) {
        return matchColor(color) && matchType(type);
    }

    private boolean matchColor(Color color) {
        return this.color == color;
    }

    private boolean matchType(Type type) {
        return this.type == type;
    }

    public void addPiecesByColor(Color color, List<Piece> piecesByColor) {
        if (matchColor(color)) {
            piecesByColor.add(this);
        }
    }

    public double getPoint(List<Piece> pieces) {
        if (!matchType(Type.PAWN)) {
            return this.type.getDefaultPoint();
        }

        List<Position> columnNeighbors = this.position.getColumnNeighbors();
        for (Position position : columnNeighbors) {
            if (pieces.contains(new Piece(this.color, this.type, position))) {
                return this.type.getDefaultPoint() - 0.5;
            }
        }

        return this.type.getDefaultPoint();
    }

    private void validateColor(Color color) {
        boolean isValid = false;

        for (Color eachColor : Color.values()) {
            if (eachColor == color) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid Color");
        }
    }

    private void validateType(Type type) {
        boolean isValid = false;

        for (Type eachType : Type.values()) {
            if (eachType == type) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid Type");
        }
    }

    private void validateRepresentation(String representation) {
        boolean isValid = false;

        for (Type eachType : Type.values()) {
            for (Color color : Color.values()) {
                if (eachType.getRepresentation(color).equals(representation)) {
                    isValid = true;
                    break;
                }
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid representation");
        }
    }

    public boolean sameAs(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Piece other = (Piece) obj;
        if (color != other.color)
            return false;
        if (position == null) {
            if (other.position != null) {
                return false;
            }
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    public static class PieceMaker {

        public static Piece createWhitePawn() {
            return new Piece(Color.WHITE, Type.PAWN);
        }

        public static Piece createBlackPawn() {
            return new Piece(Color.BLACK, Type.PAWN);
        }

        public static Piece createWhiteRook() {
            return new Piece(Color.WHITE, Type.ROOK);
        }

        public static Piece createBlackRook() {
            return new Piece(Color.BLACK, Type.ROOK);
        }

        public static Piece createWhiteBishop() {
            return new Piece(Color.WHITE, Type.BISHOP);
        }

        public static Piece createBlackBishop() {
            return new Piece(Color.BLACK, Type.BISHOP);
        }

        public static Piece createWhiteQueen() {
            return new Piece(Color.WHITE, Type.QUEEN);
        }

        public static Piece createBlackQueen() {
            return new Piece(Color.BLACK, Type.QUEEN);
        }

        public static Piece createWhiteKnight() {
            return new Piece(Color.WHITE, Type.KNIGHT);
        }

        public static Piece createBlackKnight() {
            return new Piece(Color.BLACK, Type.KNIGHT);
        }

        public static Piece createWhiteKing() {
            return new Piece(Color.WHITE, Type.KING);
        }

        public static Piece createBlackKing() {
            return new Piece(Color.BLACK, Type.KING);
        }

        public static Piece createBlank() {
            return new Piece(Type.BLANK);
        }
    }
}
