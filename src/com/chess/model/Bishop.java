package com.chess.model;

public class Bishop extends Piece {
    Bishop(String color) {
        this.color = color;
    }

    public boolean canReach(int fromXCord, int fromYCord, int toXCord, int toYCord, Piece[][] board) {
        if (Math.abs(fromXCord - fromYCord) != Math.abs(toXCord - toYCord))
            return false;
        int x_inc = -1;
        int y_inc = -1;
        if (fromXCord < toXCord && fromYCord < toYCord) {
            x_inc = 1;
            y_inc = 1;
        } else if (fromXCord > toXCord && fromYCord < toYCord) {
            x_inc = -1;
            y_inc = 1;
        } else if (fromXCord < toXCord && fromYCord > toYCord) {
            x_inc = 1;
            y_inc = -1;
        }
        for (int i = 0; i < Math.abs(fromXCord - toXCord) - 1; i++) {
            fromXCord += x_inc;
            fromYCord += y_inc;
            if (board[fromXCord][fromYCord] != null)
                return false;
        }
        return true;
    }
}
