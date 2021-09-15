package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);
    static int player1Score = 0;
    static int player2Score = 0;

    public static void main(String[] args) {

        boolean gameOver = false;
        boolean playAgain = true;

        char[][] tictacBoard = {
                {'_','|','_','|','_'},
                {'_', '|', '_','|','_'},
                {' ','|',' ','|',' '}};

        printBoard(tictacBoard);
        System.out.println("Welcome to Tic Tac Toe!!");
        while(playAgain){

            while (!gameOver) {

                player1Move(tictacBoard);
                gameOver = checkBoardStatus(tictacBoard);
                if (gameOver){
                    break;
                }

                player2Move(tictacBoard);
                gameOver = checkBoardStatus(tictacBoard);
                if(gameOver){
                    break;
                }
            }
            System.out.println("Player 1 Score: " +player1Score);
            System.out.println("Player 2 Score: " +player2Score);
            System.out.println("Would you like to play again? Y/N");
            input.nextLine();
            String result = input.nextLine().toUpperCase();

            // Switch-sats för att avgöra om man vill spela igen.
            switch (result){
                case "Y":
                    playAgain = true;
                    System.out.println("Dope! Let's play again");
                    resetTictacBoard(tictacBoard);
                    gameOver = false;
                    printBoard(tictacBoard);
                    break;

                case "N":
                    playAgain = false;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    break;
            }


        }




    }

    // Metod för att printa spelbrädet
    public static void printBoard(char[][] tictacBoard){
        System.out.println();
        for(char[] row: tictacBoard){
            for (char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }


    // Metod för att uppdatera spelbrädet med gjorda drag.
    public static void updateBoard(int position, int player, char [][] tictacBoard) {

        char character = ' ';

        if (player == 1) {
            character = 'X';
        } else if (player == 2) {
            character = 'O';
        }

        switch(position) {
            case 1:
                tictacBoard[0][0] = character;
                printBoard(tictacBoard);
                break;
            case 2:
                tictacBoard[0][2] = character;
                printBoard(tictacBoard);
                break;
            case 3:
                tictacBoard[0][4] = character;
                printBoard(tictacBoard);
                break;
            case 4:
                tictacBoard[1][0] = character;
                printBoard(tictacBoard);
                break;
            case 5:
                tictacBoard[1][2] = character;
                printBoard(tictacBoard);
                break;
            case 6:
                tictacBoard[1][4] = character;
                printBoard(tictacBoard);
                break;
            case 7:
                tictacBoard[2][0] = character;
                printBoard(tictacBoard);
                break;
            case 8:
                tictacBoard[2][2] = character;
                printBoard(tictacBoard);
                break;
            case 9:
                tictacBoard[2][4] = character;
                printBoard(tictacBoard);
                break;

            default: break;
        }
    }

    // Metod för att hantera drag gjorda av Player 1
    public static void player1Move(char[][] tictacBoard) {

        System.out.println("Player 1 enter your move (1-9): ");

        int move = input.nextInt();

        boolean result = isValidMove(move, tictacBoard);

        updateBoard(move,1,tictacBoard);

        while (!result){
            System.out.println("Sorry! Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove(move, tictacBoard);
        }
        System.out.println("Player 1 moved at position " + move);
        updateBoard(move, 1, tictacBoard);
    }




    // Metod för att kontrollera om valt drag är tillgängligt på spelbrädet.
    public static boolean isValidMove(int move, char[][] tictacBoard) {

        switch(move) {
            case 1:
                if(tictacBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(tictacBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if(tictacBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if(tictacBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if(tictacBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if(tictacBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if(tictacBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if(tictacBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if(tictacBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

    // Metod för att hantera drag gjorda av Player 2
    public static void player2Move(char[][] tictacBoard) {

        System.out.println("Player 2 enter your move (1-9): ");
        int move = input.nextInt();

        boolean result = isValidMove(move, tictacBoard);

        updateBoard(move,2,tictacBoard);

        while (!result){
            System.out.println("Sorry! Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove(move, tictacBoard);
        }
        System.out.println("Player moved at position " + move);
        updateBoard(move, 2, tictacBoard);
    }

    // Metod för att kontrollera om någon vunnit.
    public static boolean checkBoardStatus(char [][] tictacBoard) {

        // Horisontella vinstlinjer
        if (tictacBoard[0][0] == 'X' && tictacBoard[0][2] == 'X' && tictacBoard[0][4] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][0] == 'O' && tictacBoard[0][2] == 'O' && tictacBoard[0][4] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }
        if (tictacBoard[1][0] == 'X' && tictacBoard[1][2] == 'X' && tictacBoard[1][4] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[1][0] == 'O' && tictacBoard[1][2] == 'O' && tictacBoard[1][4] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }
        if (tictacBoard[2][0] == 'X' && tictacBoard[2][2] == 'X' && tictacBoard[2][4] == 'X') {
            System.out.println("Player 2 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[2][0] == 'O' && tictacBoard[2][2] == 'O' && tictacBoard[2][4] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }

        // Vertikala vinstlinjer
        if (tictacBoard[0][0] == 'X' && tictacBoard[1][0] == 'X' && tictacBoard[2][0] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][0] == 'O' && tictacBoard[1][0] == 'O' && tictacBoard[2][0] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }
        if (tictacBoard[0][2] == 'X' && tictacBoard[1][2] == 'X' && tictacBoard[2][2] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][2] == 'O' && tictacBoard[1][2] == 'O' && tictacBoard[2][2] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }
        if (tictacBoard[0][4] == 'X' && tictacBoard[1][4] == 'X' && tictacBoard[2][4] == 'X') {
            System.out.println("Player 2 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][4] == 'O' && tictacBoard[1][4] == 'O' && tictacBoard[2][4] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }

        // Diagonala vinstlinjer

        if (tictacBoard[0][0] == 'X' && tictacBoard[1][2] == 'X' && tictacBoard[2][4] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][0] == 'O' && tictacBoard[1][2] == 'O' && tictacBoard[2][4] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }
        if (tictacBoard[0][4] == 'X' && tictacBoard[1][2] == 'X' && tictacBoard[2][0] == 'X') {
            System.out.println("Player 1 Wins");
            player1Score++;
            return true;
        }
        if (tictacBoard[0][4] == 'O' && tictacBoard[1][2] == 'O' && tictacBoard[2][0] == 'O') {
            System.out.println("Player 2 Wins");
            player2Score++;
            return true;
        }

        // Kontrollerar om spelrundan blir lika.
        if(tictacBoard[0][0] != '_' && tictacBoard[0][2] != '_' && tictacBoard[0][4] != '_' &&
                tictacBoard[1][0] !='_'&& tictacBoard[1][2] != '_' && tictacBoard[1][4] != '_' &&
                tictacBoard[2][0] != ' ' && tictacBoard[2][2] != ' ' && tictacBoard[2][4] != ' ') {
            System.out.println("Its a tie");
            return true;
        }

    return false;
    }


    // Metod för att starta om spelrundan och återställa spelbrädet.
    public static void resetTictacBoard(char[][] tictacBoard) {
        tictacBoard[0][0] = '_';
        tictacBoard[0][2] = '_';
        tictacBoard[0][4] = '_';
        tictacBoard[1][0] = '_';
        tictacBoard[1][2] = '_';
        tictacBoard[1][4] = '_';
        tictacBoard[2][0] = ' ';
        tictacBoard[2][2] = ' ';
        tictacBoard[2][4] = ' ';
    }

}