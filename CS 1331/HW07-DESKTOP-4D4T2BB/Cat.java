/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/

public class Cat extends Pet implements Treatable {
    private boolean hasStripes;
    private static final String DEFAULTNAME = "Purrfect";
    private static final int DEFAULTAGE = 4;
    private static final int DEFAULTPAINLEVEL = 9;

    /**
    *A constructor for Cat that sets the name, age, painLevel, and hasStripes with one constructor.
    *@param hasStripes the first one
    */

    public Cat(boolean hasStripes) {
        this(DEFAULTNAME, DEFAULTAGE, DEFAULTPAINLEVEL, hasStripes);
    }
    /**
    *A constructor for Cat that sets the name, age, painLevel, and hasStripes.
    *@param name the first one
    *@param age the second one
    *@param painLevel the third one
    *@param hasStripes the last one
    */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }
    /**
    *A getter method for the hasStripes which returns the getHasStripes
    *@return hasStripes.
    */
    public boolean getHasStripes() {
        return this.hasStripes;
    }
    /**
    *A setter method for the cat which sets the hasStripes
    *@param hasStripes the only one.
    */
    public void setHasStripes(boolean hasStripes) {
        this.hasStripes = hasStripes;
    }
    @Override
    public void playWith(Pet p) {
        if (p != null && p instanceof Cat) {
            if (((Cat) p).getHasStripes() == this.hasStripes) {
                this.setPainlevel(this.getPainLevel() - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");
            } else {
                this.setPainlevel(this.getPainLevel() - 2);
                System.out.println("Meow! I like playing with other cats without the same pattern as me");
            }
        }

        if (p != null && p instanceof Dog) {
            this.setPainlevel(this.getPainLevel() + 1);
            System.out.println("Meow. Go away " + p.getName() + "! I don’t like playing with Dogs!");
        }

    }
    /**
    *A method that decreases the painlevel by giving it a treat
    */
    public void treat() {
        this.setPainlevel(this.getPainLevel() - 1);
    }
    @Override
    public String toString() {
        return (super.toString() + " My age in human years is "
              + Treatable.convertCattoHumanYears(this.getAge()) + ".");
    }
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Cat) {
            return (super.equals(o) && this.hasStripes == ((Cat) o).getHasStripes());
        } else {
            return false;
        }
    }



}
