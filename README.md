# tttJava
Tic tac toe game written in java

The three java classes Examiner.java, Game.java and Tests.java were created under the package tictactoe.


Gama.java contains the main method that runs the code in addition to other methods. This includes the method 
PlayerTurn and cpuTurn that defines the behaviours that occur when it is their turn. 
It also includes the method printGameBoard that simply prints the game board and the method placePiece that places the symbol(X or O) onto 
the game board.


Examiner.java is the class that contains the checks. isValidMove checks if the position on the board is empty based on the value the player provides. 
If the position is empty, that method returns true. inputValid checks if the input provided is in the correct range. 
It returns false if the number provided is less than 1 and if it is bigger than 9. 
checkWin contains the winning conditions check. isGameFinished is a method that determines whether the player has won, lost or if the game ended in a draw.


Tests.java contains simple tests to check if the methods defined have been implemented correctly.
