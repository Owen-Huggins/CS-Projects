import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Food {
    private String name;
    private int quantity;
    private double price;

    public Food (String name, int quantity, double price) {
      Scanner fileScan = null;
      File fileIn = new File("restaurants.csv");
        try {
          fileScan = new Scanner(fileIn);
          while (fileScan.hasNextLine()) {

            String[] line = fileScan.nextLine().split(",");

            String stringQuantity = Integer.toString(quantity);

            String stringPrice = Double.toString(price);
            if (line[0] != "RESTAURANT" && (line[0].equals(name)) && ((line[1]).trim().equals(stringQuantity)) && ((line[2]).trim().equals(stringPrice))) {

                this.name = name;
                this.quantity = quantity;
                this.price = price;
            }


          }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }

    public String toString() {
        return this.name + " costs $" + this.price + ", there are " + this.quantity + " remaining.";
    }

    public static void main(String[] args) {
        Food number1 = new Food("Sandwich", 10, 4.99);

        System.out.println(number1);
    }
}
