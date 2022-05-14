/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/
public class Narwhal extends Pet {
    private int hornLength;
    private static final String DEFAULTNAME = "Jelly";
    private static final int DEFAULTAGE = 19;
    private static final int DEFAULTPAINLEVEL = 2;
    private static final int DEFAULTHORNLENGTH = 7;

    /**
    *A constructor for Cat that sets the name, age, painLevel, and hornLength without a constructor.
    */
    public Narwhal() {
        this(DEFAULTNAME, DEFAULTAGE, DEFAULTPAINLEVEL, DEFAULTHORNLENGTH);
    }
    /**
    *A constructor for Cat that sets the name, age, painLevel, and hornLengths.
    *@param name the first one
    *@param age the second one
    *@param painLevel the third one
    *@param hornLength the last one
    */

    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }
    /**
    *A getter method for the hornLength which returns the getHornLength
    *@return hornLength.
    */
    public int getHornLength() {
        return this.hornLength;
    }

    /**
    *A setter method for the Narwhal which sets the hornLength
    *@param hornLength the only one.
    */

    public void setHornLength(int hornLength) {
        this.hornLength = hornLength;
    }
    @Override
    public void playWith(Pet p) {
        if (p != null && p instanceof Narwhal) {
            this.setHornLength(this.hornLength - 2);
            System.out.println("Who needs dogs and cats when we have each other");
        } else if (p != null) {
            this.setHornLength(this.hornLength + 1);
            System.out.println("I live in the ocean so I can’t play with you");
        }

    }
    @Override
    public String toString() {
        return (super.toString() + " I have a horn that is " + this.hornLength + " feet long.");
    }
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Narwhal) {
            return (super.equals(o) && this.hornLength == ((Narwhal) o).getHornLength());
        } else {
            return false;
        }
    }


}
