package com.chess.model;

public class ChessBoard {
    private Piece board[][];
    private static int DEFAULT_SIZE = 8;
    private int n, m;

    ChessBoard() {
        this(DEFAULT_SIZE, DEFAULT_SIZE);
    }

    ChessBoard(int n, int m) {
        this.n = n;
        this.m = m;
        board = new Piece[n][m];
        init();
    }

    public Piece[][] getBoard() {
        return board;
    }

    private void init() {
        board[0][0] = new Rook("B");
        board[0][7] = new Rook("B");
        board[7][0] = new Rook("W");
        board[7][7] = new Rook("W");

        board[0][1] = new Knight("B");
        board[0][6] = new Knight("B");
        board[7][1] = new Knight("W");
        board[7][6] = new Knight("W");

        board[0][2] = new Bishop("B");
        board[0][5] = new Bishop("B");
        board[7][2] = new Bishop("W");
        board[7][5] = new Bishop("W");

        board[0][3] = new King("B");
        board[0][4] = new Queen("B");
        board[7][4] = new King("W");
        board[7][3] = new Queen("W");
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("B");
            board[6][i] = new Pawn("W");
        }
    }
}
