package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        /*char [][] emptyBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};*/

        char[][] tictacBoard = {
                {'|','1', '|', '2', '|', '3', '|'},
                {'-','-', '-', '-', '-', '-', '-'},
                {'|','4', '|', '5', '|', '6', '|'},
                {'-','-', '-', '-', '-', '-', '-'},
                {'|','7', '|', '8', '|', '9', '|'}
        };



       /* Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement(1-9)");
        int pos = scan.nextInt();

        System.out.println(pos);*/

        /*switch (pos) {
            case 1:
                emptyBoard[0][1] = 'X';
                break;
            case 2:
                emptyBoard[0][3] = 'X';
                break;
            case 3:
                emptyBoard[0][6] = 'X';
                break;
            case 4:
                emptyBoard[2][1] = 'X';
                break;
            case 5:
                emptyBoard[2][3] = 'X';
                break;
            case 6:
                emptyBoard[2][6] = 'X';
                break;
            case 7:
                emptyBoard[4][1] = 'X';
                break;
            case 8:
                emptyBoard[4][3] = 'X';
                break;
            case 9:
                emptyBoard[4][6] = 'X';
                break;
        }*/

        player1Move(tictacBoard);

        // printBoard(tictacBoard);

    }

    public static void printBoard(char[][] tictacBoard){

        for(char[] row: tictacBoard){
            for (char c: row){
                System.out.print(c);
            }
            System.out.println();
        }

    }

    public static void updateBoard(int position, int player, char [][] tictacBoard) {

        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch(position) {
            case 1:
                tictacBoard[0][1] = character;
                printBoard(tictacBoard);
                break;
            case 2:
                tictacBoard[0][3] = character;
                printBoard(tictacBoard);
                break;
            case 3:
                tictacBoard[0][5] = character;
                printBoard(tictacBoard);
                break;
            case 4:
                tictacBoard[2][1] = character;
                printBoard(tictacBoard);
                break;
            case 5:
                tictacBoard[2][3] = character;
                printBoard(tictacBoard);
                break;
            case 6:
                tictacBoard[2][5] = character;
                printBoard(tictacBoard);
                break;
            case 7:
                tictacBoard[4][1] = character;
                printBoard(tictacBoard);
                break;
            case 8:
                tictacBoard[4][3] = character;
                printBoard(tictacBoard);
                break;
            case 9:
                tictacBoard[4][5] = character;
                printBoard(tictacBoard);
                break;

                default: break;
        }
    }

    public static void player1Move(char[][] tictacBoard) {

        System.out.println("Please enter your move (1-9): ");
        int move = input.nextInt();
        updateBoard(move,1,tictacBoard);

        boolean result = isValidMove(move, tictacBoard);

        while (!result){
            System.out.println("Sorry! Invalid Move. Try again");
            move = input.nextInt();
            result = isValidMove(move, tictacBoard);
        }
        System.out.println("Player moved at position " + move);
        updateBoard(move, 1, tictacBoard);
    }


    public static boolean isValidMove(int move, char[][] tictacBoard) {

        switch(move) {
            case 1:
                if(tictacBoard[0][1] == '1') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if(tictacBoard[0][3] == '2') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if(tictacBoard[0][5] == '3') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if(tictacBoard[2][1] == '4') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if(tictacBoard[2][3] == '5') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if(tictacBoard[2][5] == '6') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if(tictacBoard[4][1] == '7') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if(tictacBoard[4][3] == '8') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if(tictacBoard[4][5] == '9') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

}
