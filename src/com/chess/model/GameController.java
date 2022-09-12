package com.chess.model;

import java.util.LinkedList;
import java.util.Queue;

public class GameController {

    private Queue<Player> turnQueue;
    private Player player1;
    private Player player2;
    private ChessBoard chessBoard;

    GameController(ChessBoard chessBoard) {
        turnQueue = new LinkedList<>();
        player1 = new Player("Archit", "B");
        player2 = new Player("Rajat", "W");
        this.chessBoard = chessBoard;
        init();
    }

     public void start() {
        boolean ends = false;
        while (!ends) {
            Player player = turnQueue.poll();
            displayBoard();
            int[] moveArray = player.makeMove();
            while (!validateMove(moveArray)) {
                System.out.println("Invalid Move , Enter Valid Move");
                moveArray = player.makeMove();
            }
            boolean wins = this.checkIfCurrentPlayerWins(moveArray[2], moveArray[3]);
            if (wins) {
                System.out.println("Player : " + player.getName() + " won....Hurraahh...");
                System.out.println("-----------------------Game End------------------------------");
                ends = true;
            }
            this.move(moveArray);
            turnQueue.add(player);
        }
    }

    private void move(int moveArray[]) {
        Piece[][] board = chessBoard.getBoard();
        board[moveArray[2]][moveArray[3]] = board[moveArray[0]][moveArray[1]];
        board[moveArray[0]][moveArray[1]] = null;
    }

    private boolean validateMove(int moveArray[]) {
        boolean areValidInputs = validInput(moveArray);
        if (areValidInputs) {
            Piece[][] board = chessBoard.getBoard();
            int fromXCord = moveArray[0];
            int fromYCord = moveArray[1];
            int toXCord = moveArray[2];
            int toYCord = moveArray[3];
            Piece piece = board[fromXCord][fromYCord];
           boolean canReach= piece.canReach(fromXCord, fromYCord, toXCord, toYCord, board);
            if(canReach)
                return true;
        }
        return false;
    }

    private boolean validInput(int moveArray[]) {
        Piece[][] board = chessBoard.getBoard();
        int n = board.length;
        for (int i = 0; i < 4; i++) {
            if (moveArray[i] < 0 || moveArray[i] >= n || board[moveArray[0]][moveArray[1]] == null)
                return false;
        }
        if (moveArray[0] == moveArray[2] && moveArray[1] == moveArray[3])
            return false;
        Piece p1 = board[moveArray[0]][moveArray[1]];
        Piece p2 = board[moveArray[2]][moveArray[3]];
        if (p2 != null && (p1.getColor().equals(p2.getColor())))
            return false;
        return true;
    }

    public void init() {
        turnQueue.add(player1);
        turnQueue.add(player2);
    }

    private boolean checkIfCurrentPlayerWins(int x, int y) {
        Piece[][] board = chessBoard.getBoard();
        if (board[x][y] != null && board[x][y].getName().equals("King"))
            return true;
        return false;
    }

    private void displayBoard() {
        Piece[][] board = chessBoard.getBoard();

        System.out.print("            ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(i+"            ");
        }
        System.out.println();
        System.out.println("    ___________________________________________________________________________________________________________");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i+"  |     ");
            for (int j = 0; j < board.length; j++) {
                String equalString="";
                int length=0;
                if(board[i][j]!=null) {
                     length = board[i][j].getName().length();

                }else
                {
                    length=2;
                }
                while ((equalString.length() + length) != 8) {
                    equalString += " ";
                }
                if(board[i][j]!=null)
                System.out.print(board[i][j] + equalString+"|  ");
                else
                    System.out.print("    " + equalString+"|  ");

            }
            System.out.println();
            System.out.println("    ___________________________________________________________________________________________________________");

        }

    }
}
