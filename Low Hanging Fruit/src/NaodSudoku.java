/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Low Hanging Fruit
* Due Date: 08/26/2022
* File: NaodSudoku.java
* Description: A class that has a sudokuboard as an atribute, along with different methods
*/

public class NaodSudoku{
    /* ATTRIBUTES */
    private int [][] sudokuBoard = new int[9][9];
    private boolean [] checkedValues;

    /* CONSTRUCTORS */
    NaodSudoku(){};

/*****
* Method: Build
* Parameters: None
* Return: Void
* Purpose: To load a new board
*****/
    void build(int[][]value){
		sudokuBoard = value;
    };

/*****
* Method: Display
* Parameters: None
* Return: Void
* Purpose: To display the current board
*****/
    void display(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudokuBoard[i][j] == 0){
                    System.out.print("_");      
                }
                else{
                    System.out.print(sudokuBoard[i][j]);
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    };

/*****
* Method: IsValid
* Parameters: None
* Return: Boolean
* Purpose: Check if the sudoku board is valid
*****/
    boolean isValid(){
        //Check rows
        for(int i = 0; i < 9; i++){
            checkedValues = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(sudokuBoard[i][j] != 0){
                    if(checkedValues[sudokuBoard[i][j]-1] == true){
                        return false;
                    }
                    else{
                        checkedValues[sudokuBoard[i][j]-1] = true;
                    }
                }
            }
        }

        //Check columns
        for(int i = 0; i < 9; i++){
            checkedValues = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(sudokuBoard[j][i] != 0){
                    if(checkedValues[sudokuBoard[j][i]-1] == true){
                        return false;
                    }
                    else{
                        checkedValues[sudokuBoard[j][i]-1] = true;
                    }
                }
            }
        }

        //Check 3x3 boxes
        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                checkedValues = new boolean[9];
                for(int k = i; k < i+3; k++){
                    for(int l = j; l < j+3; l++){
                        if(sudokuBoard[k][l] != 0){
                            if(checkedValues[sudokuBoard[k][l]-1] == true){
                                return false;
                            }
                            else{
                                checkedValues[sudokuBoard[k][l]-1] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    };

/*****
* Method: Solve
* Parameters: None
* Return: Boolean
* Purpose: To check if the sudoku board can be solved, and solve it if so
*****/
    boolean solve(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudokuBoard[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        sudokuBoard[i][j] = k;
                        if(isValid()){
                            if(solve()){
                                return true;
                            }
                            else{
                                sudokuBoard[i][j] = 0;
                            }
                        }
                        else{
                            sudokuBoard[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        if(isValid()){
            return true;
        }
        return false;
    };
};