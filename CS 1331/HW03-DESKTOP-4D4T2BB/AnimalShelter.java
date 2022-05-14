//I worked on the homework assignment alone, using only course materials.\\
import java.util.Scanner;
public class AnimalShelter{
  public static void main(String[] args){
    String[][] Animals = new String[][] {{"x","x","Stefanie","x","Tomas"},{"Leedan","x","x","x","x"},{"x","x","x","Andhru","x"},{"x","Lio","Rhitvic","x","x"},{"Nepun","x","x","Avenash","Dustan"}};
    System.out.println("Welcome to the Animal Shelter!");
    Scanner Input = new Scanner(System.in);
    String Answer = "Y";
    while (!"E".equals(Answer)) {
      System.out.println("\nWould you like to adopt a pet? [Y]es, [N]o, or [E]xit");
      Answer = (Input.nextLine());

    if(Answer.equals("Y")){
      for (int i = 0; i < Animals.length; ++i) {
        System.out.println();
        for(int j = 0; j < Animals[i].length; ++j) {
          if (j != (Animals[i].length -1)){
            System.out.print("|"+ Animals[i][j]);

          }else {
            System.out.print("|"+ Animals[i][j]+ "|");
          }

        }
      }
      while (Animals.equals(Animals)){
        System.out.println("\n\nWhat pet are you interested in adopting?");
        Answer = (Input.nextLine());
        String[] position = Answer.split(" ");
        int position_0 = Integer.parseInt(position[0]);
        int position_1 = Integer.parseInt(position[1]);

        if(Animals.length <= position_0 || Animals.length <= position_1) {
          System.out.println("Location does not exist.");
          continue;
        }

        if(Animals[position_0][position_1].equals("x")){
          System.out.println("There is no pet in this location.");
          continue;
        }

        System.out.println("\n" + Animals[position_0][position_1] + " has been successfully adopted!");
        Animals[position_0][position_1] = "x";
        for (int i = 0; i < Animals.length; ++i) {
          System.out.println();
          for(int j = 0; j < Animals[i].length; ++j) {
            if (j != (Animals[i].length -1)){
              System.out.print("|"+ Animals[i][j]);

            }else {
              System.out.print("|"+ Animals[i][j]+ "|");
            }

          }
        }
        System.out.println();
        break;
      }

    }
    if(Answer.equals("N")){
      System.out.println("Next person in line!");
    }
    if(Answer.equals("E")){
      System.out.println("We hope you come again!");
    }

  }

  }




}
