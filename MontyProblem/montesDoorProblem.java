import java.util.Random;
import java.util.ArrayList;

public class montesDoorProblem {
	public static void switchWins() {
		double switchWins = 0;
        int firstPickDoor = 0;
        int firstPickReward = 1;
        double results = 0;

        //creates arraylist with three elements of zero, zero means goat and one means car
		ArrayList<Integer> door = new ArrayList();
        door.add(0);
        door.add(0);
        door.add(0);
		Random rd = new Random();
		
		for(int i = 0; i < 10000; i++) {
			door.set(rd.nextInt(3), 1);
            int newChoice = 0;
			
			int choice = rd.nextInt(3);

            //while loop to make sure door chosen is not the door with the car behind it
            while(firstPickReward == 1){
                firstPickDoor = rd.nextInt(3);
                firstPickReward = door.get(firstPickDoor);
            }

			//checks to make sure user is switching doors, makes sure newChoice is not the same as the original choice or the door picked
            while(newChoice != choice && newChoice != firstPickDoor){
                newChoice = rd.nextInt(3);
            }

            //if the original choice is the door with the car behind it, count it as a win
            if(door.get(newChoice) == 1){
                switchWins++;
            }

            results = (switchWins / 10000) * 100;
		}
        System.out.println("Door number " + (firstPickDoor + 1) + " has a goat behind it, you've chosen to switch doors");
        System.out.println("The percentage of times someone would win this game by switching doors 10,000 times is: " + results + '%');
	}
	
	public static void stayWins() {
		double stayWins = 0;
        int firstPickDoor = 0;
        int firstPickReward = 1;
        double results = 0;

        //creates arraylist with three elements of zero, zero means goat and one means car
		ArrayList<Integer> door = new ArrayList();
        door.add(0);
        door.add(0);
        door.add(0);
        Random rd = new Random();
		
		for(int i = 0; i < 10000; i++) {
			door.set(rd.nextInt(3), 1);
			
			int choice = rd.nextInt(3);

            //while loop to make sure door chosen is not the door with the car behind it
            while(firstPickReward == 1){
                firstPickDoor = rd.nextInt(3);
                firstPickReward = door.get(firstPickDoor);
            }
			
            //if the original choice is the door with the car behind it, count it as a win
            if(door.get(choice) == 1){
                stayWins++;
            }

            results = (stayWins / 10000) * 100;
	    }
        System.out.println("Door number " + (firstPickDoor + 1) + " has a goat behind it, you've chosen to stay with your door");
        System.out.println("The percentage of times someone would win this game by staying with the same door 10,000 times is: " + results + "%");
    }

    public static void main(String[]args){
        stayWins();
        switchWins();
    }
}

