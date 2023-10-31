import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Factory {
    public static void factory() throws IOException{
        Random rd = new Random();
        int runs = 1000;
        String[] carTypeArray = {"Sedan", "Sedan", "Niisan", "Tesla", "Buick"};
        String[] colorArray = {"Red", "Red", "Black", "White", "Green"};
        String[] csvArray = new String[runs];

        FileWriter file = new FileWriter("factory.csv");
        BufferedWriter test = new BufferedWriter(file);

        for(int i = 0; i < runs; i++){
            int index = rd.nextInt(carTypeArray.length);
            String carType = carTypeArray[index];

            int year = (2023 - (rd.nextInt(50) + 1));

            index = rd.nextInt(colorArray.length);
            String color = colorArray[index];

            int miles = rd.nextInt(250000);

            Car car = new Car(carType, year, color, miles);

            csvArray[i] = (car.getCarType()+ ',' + String.valueOf(car.getYear()) + ',' + car.getColor() + ',' + String.valueOf(car.getMiles()));

            String data = String.join(",", csvArray[i]);
            test.write(data);
            test.newLine();
        }
        

    }
}
