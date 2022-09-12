package com.chess.model;

public class Chess {

    private ChessBoard chessBoard;
    private GameController controller;

    public Chess() {
        chessBoard = new ChessBoard();
        controller = new GameController(chessBoard);
    }

    public void startGame() {
        controller.start();
    }

}
