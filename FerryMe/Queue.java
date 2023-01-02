package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: Queue.java
* Description: Queue class
*/

public class Queue<E> implements QueueInterface<E> {
    /* ATTRIBUTES */
    private Node<E> front;
    private Node<E> back;

    /* CONSTRUCTOR */
    public Queue(){};

    /* PRIVATE METHODS */
    /*
    * Method: isEmpty
    * Parameters: None
    * Return: Boolean
    * Purpose: To find out if the queue is empty or not
    */
    protected boolean isEmpty(){
        return (front == null);
    };

    /* PUBLIC METHODS */
    /*
    * Method: offer
    * Parameters: <E> Generic type
    * Return: Boolean
    * Purpose: To add a new node to the queue
    */
    @Override
    public boolean offer(E item){
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
        }
        else{
            back.next = newNode;
        }
        back = newNode;

        return false;
    };

    /*
    * Method: poll
    * Parameters: None
    * Return: <E> Generic type
    * Purpose: Return the node at the front of the queue and remove it
    */
    @Override
    public E poll(){
        if(isEmpty()){
            return null;
        }

        Node<E> returnNode = front;
        front = front.next;

        return returnNode.data;
    };

    /*
    * Method: peek
    * Parameters: None
    * Return: <E> Generic Type
    * Purpose: Return the node at the front of the queue
    */
    @Override
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return front.data;
    };

    /*
    * Method: toString
    * Parameters: None
    * Return: String
    * Purpose: Override the toString method and return a string of all the data contained in the queue
    */
    @Override
    public String toString(){
        Node<E> temp = front;
        String output = "";
        while(temp != null){
            output += temp.data + " ";
            temp = temp.next;
        }
        return output;
    };
};