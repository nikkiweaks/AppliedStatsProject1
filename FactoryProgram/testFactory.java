import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class testFactory {
    public static void main(String[] args) throws IOException{
        Factory fact = new Factory();
        FileWriter file = new FileWriter("factory.csv");
        
        BufferedWriter test = new BufferedWriter(file);

        String[] header = {"Car type", "Year", "Color", "Miles"};
        String header2 = String.join(",", header);
        test.write(header2);
        test.newLine();

        fact.factory();

        test.close();
    }
}
