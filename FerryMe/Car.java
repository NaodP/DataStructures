package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: Car.java
* Description: Car class
*/

public class Car {
    /* ATTRIBUTES */
    private int id;
    private int line;
    protected String destination;

    /* CONSTRUCTORS */
    Car(){};
    Car(int id, int line, String destination){
        this.id = id;
        this.line = line;
        this.destination = destination;
    }

    /* TESTING */
    @Override
    public String toString() {
        String value = this.id + " " + this.line + " " + this.destination;
        return value;
    }
    /* TESTING */
};
