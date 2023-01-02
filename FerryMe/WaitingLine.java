package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: waitingLine.java
* Description: Waiting Line class
*/

public class WaitingLine {
    /* ATTRIBUTES */
    private Queue<Car> line[];

    /* CONSTRUCTORS */
    WaitingLine(){};
    WaitingLine(int lines){
        line = new Queue[lines];
        for(int i = 0; i < lines; i++){
            line[i] = new Queue<Car>();
        }
    };

    /* METHODS */
    /*
    * Method: addCar
    * Parameters: id(int), lineNum(int), destination(String)
    * Return: void
    * Purpose: Add a car to the given line number
    */
    protected void addCar(int id, int lineNum, String destination){
        line[lineNum-1].offer(new Car(id,lineNum,destination));
    };

    /*
    * Method: unload
    * Parameters: index(int)
    * Return: Queue<Car>
    * Purpose: Return the queue of cars for the given line number
    */
    protected Queue<Car> unload(int index){
        return line[index-1];
    };

    /* TESTING */
    protected String printLine(int index){
        String value = "";
        while(line[index].peek() != null){
            value += line[index].poll() + " ";
        }
        return value;
    };
    /* TESTING */
};