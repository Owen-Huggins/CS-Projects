/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/
public class Dog extends Pet implements Treatable {
    private String breed;
    private static final String DEFAULTNAME = "Buzz";
    private static final int DEFAULTAGE = 6;
    private static final int DEFAULTPAINLEVEL = 3;

    /**
    *A constructor for Dog that sets the name, age, painLevel, and breed with one constructor.
    *@param breed the first one
    */

    public Dog(String breed) {
        this(DEFAULTNAME, DEFAULTAGE, DEFAULTPAINLEVEL, breed);
    }

    /**
    *A constructor for Dog that sets the name, age, painLevel, and breed.
    *@param name the first one
    *@param age the second one
    *@param painLevel the third one
    *@param breed the last one
    */

    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    /**
    *A getter method for the breed which returns the getBreed
    *@return breed.
    */

    public String getBreed() {
        return this.breed;
    }

    /**
    *A setter method for the breed which sets the breed
    *@param breed the only one.
    */

    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Override
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            int oldPainLevel = this.getPainLevel();
            this.setPainlevel(oldPainLevel - 3);
            System.out.println("Woof! I love playing with other dogs so much that my pain level went from "
                  + oldPainLevel + " to " + this.getPainLevel());
        } else if (p instanceof Cat) {
            if (((Cat) p).getHasStripes()) {
                int oldPainLevel = this.getPainLevel();
                this.setPainlevel(oldPainLevel - 2);
                System.out.println("AHHH! I thought you were a tiger!");
            } else {
                int oldPainLevel = this.getPainLevel();
                this.setPainlevel(oldPainLevel - 1);
                System.out.println("Woof. Cats without stripes are okay since they made my pain level go from "
                      + oldPainLevel + " to " + this.getPainLevel());
            }
        }

    }

    /**
    *A method that decreases the painlevel by giving it a treat
    */

    public void treat() {
        this.setPainlevel(this.getPainLevel() - 3);
    }
    /**
    *A method that emulates a dog barking
    */
    public void bark() {
        System.out.println("bark bark");
    }

    @Override
    public String toString() {
        return ("My name is " + this.getName() + ", I am " + this.getAge() + ", and I am a "
              + this.breed + ". On ascale of one to ten my pain level is " + this.getPainLevel()
              + ". My age in human years is " + Treatable.convertDogToHumanYears(this.getAge()) + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Dog) {
            return (super.equals(o) && this.breed == ((Dog) o).getBreed());
        } else {
            return false;
        }
    }
}
