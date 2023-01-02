package FerryMe;
import java.util.*;

public class Driver {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        FerryLine Ferry;
        WaitingLine WaitingLine;

        int num, carId, lineId, ferryLane, waitingLane;
        String destination;
    
        //Load Waiting Lines
        num = keyboard.nextInt();
        WaitingLine = new WaitingLine(13);

        for(int i = 0; i < num; i++){
            carId = keyboard.nextInt();
            lineId = keyboard.nextInt();
            destination = keyboard.next();
            WaitingLine.addCar(carId, lineId, destination);
        }

        //Load Ferry Lines
        num = keyboard.nextInt();
        Ferry = new FerryLine(num);

        for(int i = 0; i < num; i++){
            waitingLane = keyboard.nextInt();
            ferryLane = keyboard.nextInt();
            
            Ferry.load(ferryLane, WaitingLine.unload(waitingLane));
        }

        //Unload Ferry
        num = keyboard.nextInt();

        for(int i = 0; i < num; i++){
            destination = keyboard.next();
            Ferry.unload(destination);
        }

        //Check Ferry Status
        if(Ferry.isEmpty()){
            System.out.println("Success!");
        }
        else{
            System.out.println("Failed!");
        }

        /* TESTING */
        for(int i = 0; i < Ferry.getLanes(); i++){
            System.out.println(Ferry.printLine(i));
        }
        System.out.print('\n');
        for(int i = 0; i < Ferry.getLanes(); i++){
            System.out.println(WaitingLine.printLine(i));
        }
        /* TESTING */

        keyboard.close();
  
    };
};