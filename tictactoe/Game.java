package tictactoe;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game { 

    // main method
    public static void main(String[] args) {
        // counter keeps track the number of times both players have taken a turn
        int counter = 0;
        boolean inSession = true;
        Examiner check = new Examiner();

        System.out.println("Hello and welcome to this game of tic tac toe");

        // hard coded gameboard
        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' } };

        printGameBoard(gameBoard);

        // Create a Scanner and ask the player for their name
        Scanner in = new Scanner(System.in);
        System.out.print("Player 1, what is your name? ");
        String p1 = in.nextLine();

        while (true) { 
           
        	if (inSession) {
        		// players turn
                playerTurn(check, gameBoard, p1);
                counter += 1;

                // checks to see if game is finished or not (draw,win, lose)
                if (check.isGameFinished(gameBoard, p1, counter)) {
                    inSession = false;
                    break;
                }

                // computer turn
                cpu2Turn(check, gameBoard);

                counter += 1;
                
                if (check.isGameFinished(gameBoard, "CPU", counter)) {
                    inSession = false;
                    break;
                }
                
        		
        	}
        	else {
        		break;
        	}
            

        }

        System.out.println("Game ended");
        in.close();
        
    }

    // players turn
    private static void playerTurn(Examiner check, char[][] gameBoard, String p1) {
        Scanner scan = new Scanner(System.in);  
        System.out.println("Choose your position (1-9) " + p1);
        int playerPos = scan.nextInt();

        // checks to see if the value provided is in range
        while (!check.inputValid(playerPos)) {
            System.out.println("Invalid input, choose your position (1-9) again " + p1);
            playerPos = scan.nextInt();
        }
        // checks if there's a piece there already
        while (!check.isValidMove(gameBoard, playerPos)) {
            System.out.println("Not an empty spot, choose your position (1-9) again " + p1);
            playerPos = scan.nextInt();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {  
            System.out.println("Oops! Something went wrong! : " + e);
            
        }

        placePiece(gameBoard, playerPos, 'X');
        
        
    }

    // CPU turn
    private static void cpu2Turn(Examiner check, char[][] gameBoard) {
        System.out.println("Computer's turn...");

        Random rand = new Random();
        int comPos = 0;

        // checks to see if cpu is playing right move, so it doesn't overwrite player
        // 1's moves
        while (true) {
            comPos = rand.nextInt(9) + 1;
            if (check.isValidMove(gameBoard, comPos)) {
                break;
            }
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {  
            System.out.println("Oops! Something went wrong! : " + e);
        }

        placePiece(gameBoard, comPos, 'O');
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            System.out.println(row);
        }
    }

    // just places the X on the game board according to int value player has chosen
    public static void placePiece(char[][] gameBoard, int position, char symbol) {

        // switch case, numbers correspond to position on game board
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;

            default:
                break;
        }

        printGameBoard(gameBoard);

    }

}
