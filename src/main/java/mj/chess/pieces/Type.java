package mj.chess.pieces;

public enum Type {
    BISHOP("b", 3.0),
    KING("k", 0.0),
    KNIGHT("n", 2.5),
    PAWN("p", 1.0),
    QUEEN("q", 9.0),
    ROOK("r", 5.0),
    BLANK(".", 0.0);

    private final String representation;
    private final double defaultPoint;

    Type(String representation, double defaultPoint) {
        this.representation = representation;
        this.defaultPoint = defaultPoint;
    }

    public String getRepresentation(Color color) {
        if (color == Color.BLACK) {
            return representation.toUpperCase();
        }

        return representation;
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }
}
