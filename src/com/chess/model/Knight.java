package com.chess.model;

public class Knight extends Piece {
    Knight(String color) {
        this.color = color;
    }

    public boolean canReach(int fromXCord, int fromYCord, int toXCord, int toYCord, Piece[][] board) {
        if ((Math.abs(fromXCord - toXCord) == 1 && Math.abs(fromYCord - toYCord) == 2) ||
                (Math.abs(fromXCord - toXCord) == 2 && Math.abs(fromYCord - toYCord) == 1)) {
            return true;
        }
        return false;
    }
}
