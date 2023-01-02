package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: ferryLine.java
* Description: Ferry line class
*/

public class FerryLine {
    /* ATTRIBUTES */
    private Queue<Car> line[];
    private int lanes; //Test

    /* CONSTRUCTORS */
    FerryLine(){};
    FerryLine(int lines){
        this.lanes = lines; //Test
        line = new Queue[lines];
        for(int i = 0; i < lines; i++){
            line[i] = new Queue<Car>();
        }
    };

    /* METHODS */
    /*
    * Method: Load
    * Parameters: lane(int), newLine(Queue<Car>)
    * Return: Void
    * Purpose: Load all the cars from a waiting line into the corresponding ferry line
    */
    protected void load(int lane, Queue<Car> newLine){
        while(newLine.peek() != null){
            line[lane-1].offer(newLine.poll());
        }
    };

    /*
    * Method: Unload
    * Parameters: destination(String)
    * Return: Void
    * Purpose: Unload all the available cars for the given destination
    */
    protected void unload(String destination){
        for(int i = 0; i < line.length; i++){
            while(line[i].peek() != null){
                if(line[i].peek().destination.equals(destination)){
                    line[i].poll();
                }
                else{
                    break;
                }
            }
        }
    };

    /*
    * Method: isEmpty
    * Parameters: None
    * Return: boolean
    * Purpose: Return true if the ferry is empty, false if it is not
    */
    protected boolean isEmpty(){
        for(int i = 0; i < line.length; i++){
            if(line[i].peek() != null){
                return false;
            }
        }
        return true;
    };

    /* TESTING */
    protected int getLanes(){
        return lanes;
    };
    
    public String printLine(int index){
        return line[index].toString();
    };
    /* TESTING */
};