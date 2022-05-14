//I worked on the homework assignment alone, using only course materials.\\
import java.util.Scanner;
public class CarWash1331{
    public static void main(String[] args){
      float subtotal = 0;
      float total = 0;
      float discount_total = 0;
      float tip_total = 0;
      System.out.println("Welcome to Car Wash 1331!\n\nSedan/Coupe: $13.31\nTruck: $21.10\nSUV/Minivan: $35.10");
      Scanner Input = new Scanner(System.in);
      System.out.print("\nSelect the type of vehicle: ");
      String Car = (Input.nextLine()).toLowerCase();


      if(Car.equals("sedan") || Car.equals("coupe") || Car.equals("truck") || Car.equals("suv") || Car.equals("minivan")){
        if(Car.equals("sedan") || Car.equals("coupe"))
          subtotal += 13.31;
        if(Car.equals("truck"))
          subtotal += 21.10;
        if(Car.equals("suv") || Car.equals("minivan"))
          subtotal += 35.10;

        System.out.print("\nWould you like to add Wax for $3.00: ");
        String Wax = (Input.nextLine().toLowerCase());
          if(Wax.equals("yes"))
            subtotal += 3.00;

        System.out.print("Would you like to add Tire Polish for $5.00: ");
        String Polish = (Input.nextLine().toLowerCase());
          if(Polish.equals("yes"))
            subtotal += 5.00;

        System.out.print("Would you like to add an Interior Vacuum for $7.00: ");
        String Vacuum = (Input.nextLine().toLowerCase());
          if(Vacuum.equals("yes"))
            subtotal += 7.00;

        System.out.print("\nDo you have a discount code/coupon? ");
        String Coupon = (Input.nextLine().toLowerCase());
          if (Coupon.equals("yes")){

            System.out.print("Please enter the discount code: ");
            String Code = (Input.nextLine().toLowerCase());

            if (Code.equals("1331 wash!")){
              System.out.println("\nDiscount code is valid and accepted! ");
              discount_total = ((subtotal/10));


            }
            else{
              System.out.println("\nDiscount code is invalid and not accepted!");

            }
}
            System.out.print("\nWhat percentage would you like to tip? ");
            float Tip = Input.nextFloat();
            if(Tip < 0)
            Tip = 18;
            tip_total = ((subtotal*(Tip/100)));


        System.out.printf("\nSubtotal: $%.2f\n",(subtotal));
        System.out.printf("Discount: $%.2f\n",(discount_total));
        System.out.printf("Tip: $%.2f\n",(tip_total));
        System.out.printf("Total: $%.2f\n",(subtotal- discount_total + tip_total));
        }

    }



}
