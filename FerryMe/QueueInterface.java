package FerryMe;

/*
* Author: Naod Philemon
* Course: Data Structures
* Assignment: Ferry Me
* Due Date: 09/23/2022
* File: QueueInterface.java
* Description: Queue Interface
*/

public interface QueueInterface<E> {
    boolean offer(E item);
    E poll();
    E peek();
};