/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens.Board;

/**
 *
 * @author Omar
 */
import java.util.Arrays;

public class TicTacToeGame {
    private String player1Name;
    private String player2Name;
    private char[][] board;
    private char currentPlayerMark;
    private String modeOfGame; // "Multi" or "Single"
    private boolean gameOver;
    private int player1Score = 0;
    private int player2Score = 0;

    public TicTacToeGame(String player1Name, String player2Name, String modeOfGame) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.modeOfGame = modeOfGame;
        this.board = new char[3][3];
        this.currentPlayerMark = 'X'; 
        this.gameOver = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayerMark;
            gameOver = checkForWin() || isBoardFull();
            currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    private boolean checkForWin() {
       
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) ||
                checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return checkRowCol(board[0][0], board[1][1], board[2][2]) ||
               checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

   public boolean isDraw() {
        return isBoardFull() && !checkForWin();
    }

    public String getWinner() {
        if (checkForWin()) {
            return (currentPlayerMark == 'X') ? player2Name : player1Name;
        }
        return null;
    }

    public void resetGame() {
        initializeBoard();
        currentPlayerMark = 'X';
        gameOver = false;
    }
    public void incrementPlayerScore() {
        if (currentPlayerMark == 'X') {
            player2Score++; 
        } else {
            player1Score++;
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

}
