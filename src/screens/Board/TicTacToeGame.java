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
    private GameMode modeOfGame; // "Multi" or "Single"
    private boolean gameOver;
    private int player1Score = 0;
    private int player2Score = 0;

    public TicTacToeGame(String player1Name, String player2Name, GameMode modeOfGame) {
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
            if (modeOfGame == GameMode.TwoPlayers|| modeOfGame == GameMode.RECORD||modeOfGame==GameMode.Online) {
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

    public char getWinnerMark() {
        //in all possible directions
        for (int i = 0; i < 3; i++) {
            //in case rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }  //in case cols
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
            //in case main diagonal
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
                return board[0][0];
            }
            //in case Secondry diagonal
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
                return board[0][2];
            }
        }
        return ' ';
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

    public void aiMove() {
        if (modeOfGame == GameMode.AI_EASY) {
            Random rand = new Random();
            while (!gameOver) {
                int row = rand.nextInt(3);
                int col = rand.nextInt(3);
                if (board[row][col] == ' ') {
                    currentPlayerMark = 'O'; // AI uses 'O'
                    placeMark(row, col);
                    currentPlayerMark = 'X'; // 3lshan a-Switch back to player 1
                    break;
                }

            }
        }
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
        currentPlayerMark = 'X';
        gameOver = false;
    }

    public void incrementPlayerScore() {

        char WinnerMark = getWinnerMark();
        if (WinnerMark == 'X') {
            player1Score++;
        } else if (WinnerMark == 'O') {
            player2Score++;

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

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setCurrentPlayerMark(char currentPlayerMark) {
        this.currentPlayerMark = currentPlayerMark;
    }
     public void hardAiMove() {
        if (modeOfGame == GameMode.AI_EASY || modeOfGame == GameMode.AI_HARD||modeOfGame == GameMode.AI_MEDIUM) {
            currentPlayerMark = 'O';

            // Check for a winning move
            int[] winMove = findWinningMove(currentPlayerMark);
            if (winMove != null) {
                placeMark(winMove[0], winMove[1]);
                currentPlayerMark = 'X';
                return;
            }

            // Check for a blocking move
            int[] blockMove = findWinningMove('X');
            if (blockMove != null) {
                placeMark(blockMove[0], blockMove[1]);
                currentPlayerMark = 'X';
                return;
            }

            makeRandomMove();
            currentPlayerMark = 'X';
        }
    }

    private int[] findWinningMove(char playerMark) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = playerMark;
                    boolean winningMove = checkForWin();
                    board[i][j] = ' ';
                    if (winningMove) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    public void makeRandomMove() {
        Random rand = new Random();
        while (!gameOver) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (board[row][col] == ' ') {
                currentPlayerMark = 'O'; // AI uses 'O'
                placeMark(row, col);
                currentPlayerMark = 'X'; // Switch back to player 1
                break;
            }
        }
    }

    public void mediumAiMove() {
        if (modeOfGame == GameMode.AI_EASY || modeOfGame == GameMode.AI_HARD||modeOfGame == GameMode.AI_MEDIUM) {
            currentPlayerMark = 'O'; // AI's mark
            int[] bestMove = minimax(0, currentPlayerMark);
            placeMark(bestMove[1], bestMove[2]);
            currentPlayerMark = 'X'; // Switch back to player 1
        }
    }

    private int[] minimax(int depth, char player) {
        // Base cases: check for end state
        if (checkForWin()) {
            if (currentPlayerMark == 'O') {
                return new int[]{10 - depth, -1, -1}; // AI wins
            } else {
                return new int[]{-10 + depth, -1, -1}; // Player wins
            }
        } else if (isBoardFull()) {
            return new int[]{0, -1, -1}; // Draw
        }

        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = player;
                    int[] score = minimax(depth + 1, (player == 'O') ? 'X' : 'O');
                    moves.add(new int[]{score[0], i, j});
                    board[i][j] = ' '; // Undo move
                }
            }
        }

        int[] bestMove = null;
        if (player == 'O') { // AI's best move
            int bestScore = Integer.MIN_VALUE;
            for (int[] move : moves) {
                if (move[0] > bestScore) {
                    bestScore = move[0];
                    bestMove = move;
                }
            }
        } else { // Player's best move
            int bestScore = Integer.MAX_VALUE;
            for (int[] move : moves) {
                if (move[0] < bestScore) {
                    bestScore = move[0];
                    bestMove = move;
                }
            }
        }
        return bestMove;
    }

    
}
