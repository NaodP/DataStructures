package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: Node.java
* Description: Generic Node to be used in a queue
*/

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data){
        this.data = data;
    }
};