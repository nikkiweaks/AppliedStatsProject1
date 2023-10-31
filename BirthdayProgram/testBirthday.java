import java.util.Scanner;

public class testBirthday {

    //for testing purposes i used 26 classmates and 10000 runs, around 88% each time
    public static void main(String[] args) {
        birthday test = new birthday();

        Scanner sc = new Scanner(System.in);
        System.out.println("How many students are in the class?: ");
        int classmates = sc.nextInt();

        System.out.println("How many times do you want the program to run?: ");
        int runs = sc.nextInt();

        System.out.println("The probability of two people sharing a birthday in the same class is: " + test.probOfBirthday(classmates, runs) + "%");
  }
}
