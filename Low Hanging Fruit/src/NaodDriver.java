/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Low Hanging Fruit
* Due Date: 08/26/2022
* File: NaodDriver.java
* Description: Driver to demonstrate the use of the NaodSudoku class
*/

import java.util.*;

public class NaodDriver {
    public static Scanner keyboard = new Scanner(System.in);

/*****
* Method: LoadNewPuzzle
* Parameters: {keyboard, a scanner}
* Return: NaodSudoku
* Purpose: To load a new board
*****/
    static NaodSudoku loadNewPuzzle(){
        NaodSudoku newSudoku = new NaodSudoku();
        int [][] newBoard = new int[9][9];
        System.out.println("Please enter the puzzle, all 81 single-character digits.\nEnter a space between each digit. ");
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                newBoard[i][j] = keyboard.nextInt();
            }
        }

        newSudoku.build(newBoard);

        return newSudoku;
    };

/*****
* Method: DisplayPuzzle
* Parameters: NaodSudoku
* Return: Void
* Purpose: Display the current board
*****/
    static void displayPuzzle(NaodSudoku board){
        System.out.println("PUZZLE DISPLAY");
        board.display();
    }

/*****
* Method: CheckPuzzle
* Parameters: NaodSudoku
* Return: Void
* Purpose: Report whether the puzzle is valid or not
*****/
    static void checkPuzzle(NaodSudoku board){
        System.out.print("Checking Puzzle.... The puzzle is ");
        if(board.isValid()){
            System.out.println("valid.");
        }
        else{
            System.out.println("invalid.");
        }
    }

/*****
* Method: SolvePuzzle
* Parameters: NaodSudoku
* Return: Void
* Purpose: Report whether the puzzle is solvable or not
*****/
    static void solvePuzzle(NaodSudoku board){
        if(board.solve()){
            System.out.println("PUZZLE SOLVED");
        }
        else{
            System.out.println("PUZZLE IS UNSOLVABLE");
        }
        board.display();
    }

    public static void main(String[] args) throws Exception {
        NaodSudoku currentBoard = new NaodSudoku();
        String command;

        while(true){
            command = keyboard.next();
            switch(command){
                //Load a puzzle
                case "l":
                currentBoard = loadNewPuzzle();
                break;

                //Display a puzzle
                case "d":
                displayPuzzle(currentBoard);
                break;

                //Check a puzzle
                case "c":
                checkPuzzle(currentBoard);
                break;

                //Sove a puzzle
                case "s":
                solvePuzzle(currentBoard);
                break;

                //Quit program
                case "q":
                System.out.println("Goodbye. Program terminated.");
                System.exit(0);
                break;

                default:
                System.out.println("PLEASE ENTER A VALID COMMAND");
            }
        }

        //keyboard.close();
    }
};
