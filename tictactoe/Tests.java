package tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests { 
    char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                           { '-', '+', '-', '+', '-' },
                           { ' ', '|', ' ', '|', ' ' },
                           { '-', '+', '-', '+', '-' },
                           { ' ', '|', ' ', '|', ' ' } };
    Examiner test = new Examiner();

    @Test
    void testValidMove() {
        boolean output = test.isValidMove(gameBoard, 10);
        assertEquals(false, output);
    }

    @Test
    void testInputValidBiggerNum() { 
        boolean output = test.inputValid(10);
        assertEquals(false, output);

    }
    
    @Test
    void testInputValidSmallerNum() { 
    	boolean output = test.inputValid(1);
        assertEquals(true, output);

    }
    
    

    @Test
    void testWin() {
        char[][] testBoard = { { 'X', '|', 'X', '|', ' ' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', 'X' },
                               { '-', '+', '-', '+', '-' },
                               { ' ', '|', ' ', '|', ' ' } };
        boolean testCase = test.checkWin(testBoard, 'X');
        assertEquals(false, testCase);
    }

    @Test
    void testDraw() {
        boolean testCase = test.isGameFinished(gameBoard, "player", 2);
        assertEquals(false, testCase);
    }

}

