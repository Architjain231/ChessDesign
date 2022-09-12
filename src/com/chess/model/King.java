package com.chess.model;

public class King extends Piece{

    King(String color)
    {
        this.color=color;
    }
    public boolean canReach(int fromXCord,int fromYCord,int toXCord,int toYCord ,Piece[][] board)
    {
       return (Math.abs(fromXCord-toXCord)<=1&&Math.abs(fromYCord-toYCord)<=1);
    }
}
