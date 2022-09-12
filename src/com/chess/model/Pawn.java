package com.chess.model;

public class Pawn extends Piece {
    Pawn(String color) {
        this.color = color;
    }

    public boolean canReach(int fromXCord, int fromYCord, int toXCord, int toYCord, Piece[][] board) {

        Piece piece = board[fromXCord][fromYCord];
        if (piece.getColor().equals("B")) {
            if (toXCord - fromXCord == 1) {
                if (fromYCord == toYCord)
                    return true;
                if (Math.abs(fromYCord - toYCord) == 1) {
                    if (board[toXCord][toYCord] != null)
                        return true;
                    return false;
                } else
                    return false;
            } else
                return false;
        } else {
            if (toXCord - fromXCord == -1) {
                if (fromYCord == toYCord)
                    return true;
                if (Math.abs(fromYCord - toYCord) == 1) {
                    if (board[toXCord][toYCord] != null)
                        return true;
                    return false;
                } else
                    return false;
            } else
                return false;
        }
    }
}
