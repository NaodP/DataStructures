/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: The End of the World
* Due Date: 09/30/2022
* File: hanoi.java
* Description: Outputs step by step instructions for solving the Towers of Hanoi puzzle
*/

import java.util.*;
public class hanoi {
    static int counter = 0;
    public static void main(String args[]){
        //Variables
        Scanner keyboard = new Scanner(System.in);
        int disks;
        double moves = 2;
        String answer;

        //Get Input
        System.out.println("How many disks do you want?: ");
        disks = keyboard.nextInt();

        //Calculate Moves
        moves = Math.pow(2,disks) - 1;

        //Verify
        System.out.println("This will take " + moves + " moves. Are you sure? 'Yes' or 'No': ");
        answer = keyboard.next();
        if(answer.toLowerCase().equals("no")) return;

        //Output Instructions
        toh(disks,1,3,2);
        keyboard.close();
    };

    static void toh(int n, int start, int target, int extra){
        if(n==0) return;
        toh(n-1,start,extra,target);
        counter++;
        System.out.println(counter + ". " + "Move from pole " + start + " to pole " + target + ".");
        toh(n-1,extra, target, start);
        return;
    };
};
