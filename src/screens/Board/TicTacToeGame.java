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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToeGame {

    private String player1Name;
    private String player2Name;
    private char[][] board;
    private char currentPlayerMark;
    private char xo;
    private GameMode modeOfGame; // "Multi" or "Single"
    private boolean gameOver;
    private int player1Score = 0;
    private int player2Score = 0;

    public TicTacToeGame(String player1Name, String player2Name, GameMode modeOfGame,char xo) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.modeOfGame = modeOfGame;
        this.board = new char[3][3];
        if(xo == 'X'){
        this.currentPlayerMark = 'X';
        }else if(xo == 'O'){
          this.currentPlayerMark = 'O';
        }
        this.xo = xo;
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

//    public boolean placeMark(int row, int col) {
//        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
//            board[row][col] = currentPlayerMark;
//            gameOver = checkForWin() || isBoardFull();
//            currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
//            return true;
//        }
//        return false;
//    }
    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayerMark;
            gameOver = checkForWin() || isBoardFull();
            // Only switch player if it's a two-player game
            if (modeOfGame == GameMode.TwoPlayers) {
                currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
            }
            return true;
        }
        return false;
    }

    private boolean checkForWin() {

        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])
                    || checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return checkRowCol(board[0][0], board[1][1], board[2][2])
                || checkRowCol(board[0][2], board[1][1], board[2][0]);
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
        // Check if the game has been won
        if (checkForWin()) {
            // Determine the winning mark based on the board state
            char winningMark = checkWinningMark();

            // Return the corresponding player's name
            return (winningMark == 'X') ? player1Name : player2Name;
        }
        return null;
    }

    private char checkWinningMark() {
        // Iterate through the board to find the winning combination
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }

        // Default return value
        return ' ';
    }

    public void resetGame() {
        initializeBoard();
        currentPlayerMark = 'O';
        gameOver = false;
    }

    public void incrementPlayerScore() {
        char winningMark = checkWinningMark();
      if(xo=='X'){  
        if (winningMark == 'X') {
            player1Score++; // Increment score for Player 1 if 'X' wins
        } else if (winningMark == 'O') {
            player2Score++; // Increment score for Player 2 (or AI) if 'O' wins
        }
      }else if(xo=='O'){
           if (winningMark == 'O') {
            player2Score++; // Increment score for Player 1 if 'X' wins
        } else if (winningMark == 'X') {
            player1Score++; // Increment score for Player 2 (or AI) if 'O' wins
        }
      }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public char[][] getBoard() {
        return board;
    }

    public void aiMove() {
        if (modeOfGame == GameMode.AI) {
            Random rand = new Random();
        if(xo=='X'){   
            while (!gameOver ) {
                int row = rand.nextInt(3);
                int col = rand.nextInt(3);
                if (board[row][col] == ' ') {
                    currentPlayerMark = 'O'; // AI uses 'O'
                    placeMark(row, col);
                    currentPlayerMark = 'X'; // 3lshan a-Switch back to player 1
                    break;
                }
            }
        }else if(xo=='O'){
            currentPlayerMark='O';
            while (!gameOver ) {
                int row = rand.nextInt(3);
                int col = rand.nextInt(3);
                if (board[row][col] == ' ') {
                     currentPlayerMark = ' ';
                    currentPlayerMark = 'X'; // AI uses 'X'
                    placeMark(row, col);
                    currentPlayerMark = 'O'; // 3lshan a-Switch back to player 1
                    
                    break;
                }
            }
        }
        }
    }

    public List<int[]> getWinningCombination() {
        List<int[]> winningCombinations = new ArrayList<>();

        //  rows
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                winningCombinations.add(new int[]{i, 0});
                winningCombinations.add(new int[]{i, 1});
                winningCombinations.add(new int[]{i, 2});
                return winningCombinations;
            }
        }
        //  columns
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                winningCombinations.add(new int[]{0, i});
                winningCombinations.add(new int[]{1, i});
                winningCombinations.add(new int[]{2, i});
                return winningCombinations;
            }
        }
        //  diagonal
        if (checkRowCol(board[0][0], board[1][1], board[2][2])) {
            winningCombinations.add(new int[]{0, 0});
            winningCombinations.add(new int[]{1, 1});
            winningCombinations.add(new int[]{2, 2});
            return winningCombinations;
        }
        //  reverse diagonal
        if (checkRowCol(board[0][2], board[1][1], board[2][0])) {
            winningCombinations.add(new int[]{0, 2});
            winningCombinations.add(new int[]{1, 1});
            winningCombinations.add(new int[]{2, 0});
            return winningCombinations;
        }

        return winningCombinations; 
    }

}
