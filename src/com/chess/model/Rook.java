package com.chess.model;

public class Rook extends Piece {
    Rook(String color) {
        this.color = color;
    }

    public boolean canReach(int fromXCord, int fromYCord, int toXCord, int toYCord, Piece[][] board) {
        if (fromXCord != toXCord && fromYCord != toYCord)
            return false;
        int x_inc = 0;
        int y_inc = 0;
        if (fromXCord == toXCord) {
            if (fromYCord < toYCord)
                y_inc = 1;
            else
                y_inc = -1;
        } else {
            if (fromXCord < toXCord)
                x_inc = 1;
            else
                x_inc = -1;
        }
        for (int i = 0; i < Math.abs(fromXCord - toXCord + fromYCord - toYCord) - 1; i++) {
            fromXCord += x_inc;
            fromYCord += y_inc;
            if (board[fromXCord][fromYCord] != null)
                return false;
        }
        return true;
    }
}
