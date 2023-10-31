import java.util.Random;

public class birthday {
    public static double probOfBirthday(int classmates, int runs){
        Random rd = new Random();
        double sharedBirthdays = 0;
        Person[] students = new Person[classmates];

        //runs the entire experiment the amount of times user specified
        for (int i = 0; i < runs; i++) {

            //creates an array of Persons, size is specified by user input
            for (int j = 0; j < classmates; j++) {
                students[j] = new Person(rd.nextInt(12) + 1, rd.nextInt(31) + 1);
            }

            //loops check each Person in array and determines if they share a birthday with another index of the array
            for (int j = 0; j < classmates; j++) {
                for (int m = j + 1; m < classmates; m++) {

                    //if they share an index, add to shared birthdays
                    if (students[j].getMonth() == students[m].getMonth() && students[j].getDay() == students[m].getDay()) {
                        sharedBirthdays++;
                    }
                }
            }

        }
        double result = (sharedBirthdays / runs) * 100;

        return result;
    }
}
