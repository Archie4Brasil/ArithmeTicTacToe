package com.greenlightgo.arithmetictactoe.mathtictactoe;

/**
 * Created by Grand on 12/5/2014.
 */
public class TicTacWinner {

    private static char board [][];
    private char playerMark;

    public TicTacWinner () {
        board = new char[3][3];
        playerMark = 'x';
        resetTicTacWinner();
    }
    public boolean markBoard(boolean rightAnswer, int activeButton){
        if(rightAnswer)
            playerMark = 'x';
        else playerMark= 'o';
        markSpot(activeButton);
        boolean gameStatus = checkForWin();
        return gameStatus;
    }
    public void markSpot(int ab){
        switch(ab){
            case 0: {
                board[0][0] = playerMark;
            }
            break;
            case 1: {
                board[0][1] = playerMark;
            }
            break;
            case 2: {
                board[0][2] = playerMark;
            }
            break;
            case 3: {
                board[1][0] = playerMark;
            }
            break;
            case 4: {
                board[1][1] = playerMark;
            }
            break;
            case 5: {
                board[1][2] = playerMark;
            }
            break;
            case 6: {
                board[2][0] = playerMark;
            }
            break;
            case 7: {
                board[2][1] = playerMark;
            }
            break;
            case 8: {
                board[2][2] = playerMark;
            }
            break;
        }
    }
    public static void resetTicTacWinner(){
        for (int i=0; i < 3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                board[i][j] = '-';
            }
        }
    }
    public static boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                    }
                }
            }

        return isFull;
    }
    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }
    // Loop through rows and see if any are winners.
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
                }
            }
        return false;
    }
    // Loop through columns and see if any are winners.
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
               return true;
               }
            }
        return false;
    }
    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    // Change player marks back and forth.
    public void changePlayer() {
        if (playerMark == 'x') {
            playerMark = 'o';
        }
        else {
            playerMark = 'x';
        }
    }


}
