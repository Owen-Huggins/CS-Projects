/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/
public class Vet {

  /**
  *A method that will print out the toSring of a pet and make it bark if it's a dog
  *@param pet the only one
  */
    static void inspectPet(Pet pet) {
        if (pet != null) {
            if (pet instanceof Dog) {
                System.out.println(pet.toString());
                ((Dog) pet).bark();
            } else {
                System.out.println(pet.toString());
            }
        }
    }
    /**
    *A method that will give a pet a treat if it can
    *@param pet the only one
    */
    static void treatPet(Pet pet) {
        if (pet != null && pet instanceof Treatable) {
            if (pet instanceof Dog) {
                System.out.println("Welcome to the vet " + pet.getName());
                ((Dog) pet).treat();
                System.out.println("Wow what a cute dog!");
                giveDogTreat((Dog) pet);
            } else {
                System.out.println("Welcome to the vet " + pet.getName());
                ((Cat) pet).treat();
            }
        } else if (pet != null && !(pet instanceof Treatable)) {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }
    /**
    *A method that will give a dog a treat
    *@param dog the only one
    */
    static void giveDogTreat(Dog dog) {
        dog.setPainlevel(dog.getPainLevel() - 2);
    }
}
