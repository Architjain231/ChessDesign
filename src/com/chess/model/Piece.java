package com.chess.model;

public abstract class Piece {

    public String name=this.getClass().getSimpleName();
    public String color;
    public abstract boolean canReach(int fromXCord,int fromYCord,int toXCord,int toYCord,Piece [][] board);
    @Override
    public String toString() {
        return  color+ '_' +name;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
