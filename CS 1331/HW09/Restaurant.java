import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Restaurant {
    private String name;
    private Location location;
    public static final double deliveryFee = 0.2;
    private Food[] menu;


    public Restaurant(String name, Location location) {


      Scanner fileScan = null;
      File fileIn = new File("restaurants(1).csv");
        try {
          fileScan = new Scanner(fileIn);
          while (fileScan.hasNextLine()) {

            String[] line = fileScan.nextLine().split(",");
            double x = Double.parseDouble(line[2]);
            double y = Double.parseDouble(line[3]);
            if (line[0] == "RESTAURANT" && line[1] == name && x == Location.getLocationX() && y == Location.getLocationY() {
                this(name, location);
            }


          }
        } catch (InvalidRestaurantException e) {
            throw e;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }



    }

    public Restaurant(String name, double x, double y) {
      Scanner fileScan = null;
      File fileIn = new File("restaurants(1).csv");
        try {
          fileScan = new Scanner(fileIn);
          while (fileScan.hasNextLine()) {

            String[] line = fileScan.nextLine().split(",");
            double x_csv = Double.parseDouble(line[2]);
            double y_csv = Double.parseDouble(line[3]);
            if (line[0] == "RESTAURANT" && line[1].equals(name) && x_csv == x && y_csv == y) {
                this.name = name;
                this.x = x;
                this.y = y;
            }


          }
        } catch (InvalidRestaurantException e) {
            throw e;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }

    }

}
