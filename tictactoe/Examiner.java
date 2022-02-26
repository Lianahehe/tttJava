package tictactoe;

public class Examiner { 
    boolean inSession = true;

    // this method just checks if that position is empty based on the position the
    // player provided
    public boolean isValidMove(char[][] gameBoard, int position) {
        // if that position contains a space(which means its empty) it returns true
        switch (position) {
            case 1:
                return (gameBoard[0][0] == ' ');

            case 2:
                return (gameBoard[0][2] == ' ');

            case 3:
                return (gameBoard[0][4] == ' ');

            case 4:
                return (gameBoard[2][0] == ' ');

            case 5:
                return (gameBoard[2][2] == ' ');

            case 6:
                return (gameBoard[2][4] == ' ');

            case 7:
                return (gameBoard[4][0] == ' ');

            case 8:
                return (gameBoard[4][2] == ' ');

            case 9:
                return (gameBoard[4][4] == ' ');
        }
        return false;
    }

    // checks if input is in the correct range (1-9), returns true if its in range
    public boolean inputValid(int position) { 
        return (position > 0 && position < 10);
            
    }

    // check to see winner,loser or draw
    public boolean isGameFinished(char[][] gameBoard, String player, int counter) {

        if (checkWin(gameBoard, 'X')) {
            System.out.println(player + " has won !");
            return true;
        }

        if (checkWin(gameBoard, 'O')) {
            System.out.println(player + " has won !");
            return true;
        }
        
        // once a total of 9 turns have been taken, means that tiles r full so it ends
        // in a draw
        if (counter != 9) {
            return false;
        }
        System.out.println("All tiles filled, game ended in a draw");
        return true;
    }

    public boolean checkWin(char[][] board, char symbol) {
        // hard coded winning check possibilities

        // across
        if ((board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||  
                (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
                (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||

                // down
                (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
                (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
                (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||

                // diagonal
                (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
                (board[4][0] == symbol && board[2][2] == symbol && board[0][4] == symbol)) {
            return true;
        }

        return false;
    }

}

