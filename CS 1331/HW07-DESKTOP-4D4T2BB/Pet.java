//I worked on the homework assignment alone, using only course materials

/**
*This class represents an abstract Petobject.
*@author Owen Huggins
*@version 1.0
*/

public abstract class Pet  {
    private String name;
    private int age;
    private int painLevel;
    /**
    *A constructor for Pet that sets the name, age and painLevel.
    *@param name the first one
    *@param age the second one
    *@param painLevel the last one
    */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        if (age < 1) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }

        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }
    /**
    *A getter method for the name which returns the getName
    *@return name.
    */

    public String getName() {
        return (name);
    }

    /**
    *A getter method for the age which returns the getAge
    *@return age.
    */
    public int getAge() {
        return (age);
    }

    /**
    *A getter method for the painLevel which returns the getPainLevel
    *@return painLevel.
    */
    public int getPainLevel() {
        return (painLevel);
    }

    /**
    *A setter method for the name which sets the name
    *@param name the only one.
    */

    public void setName(String name) {
        this.name = name;
    }

    /**
    *A setter method for the age which sets the age
    *@param age the only one.
    */
    public void setAge(int age) {
        this.age = age;
    }

    /**
    *A setter method for the painLevel which sets the painLevel
    *@param painLevels the only one.
    */
    public void setPainlevel(int painLevels) {
        this.painLevel = painLevels;
    }
    /**
    *A method that emulates a pet playing with another pet
    *@param p the other pet that you play with.
    */
    public abstract void playWith(Pet p);
    /**
    *A method converts the pet's information into a string
    *@return a String of the pet's information
    */
    public String toString() {
        return ("My name is " + this.getName() + ", and I am " + this.getAge()
              + ". On a scale of one to ten my pain level is " + this.getPainLevel() + ".");

    }

    /**
    *A method tets if two pets are equal
    *@param o the only one
    *@return a boolean of whether or not the pets are equal
    */

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Pet)) {
            return false;
        }

        return ((((Pet) o).getName().equals(name)) && (((Pet) o).getAge() == age)
            && (((Pet) o).getPainLevel() == this.painLevel));
    }

}
