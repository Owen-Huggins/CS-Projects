/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/
public interface Treatable {
  /**
  *A method that will convert the age of a dog into human years
  *@param dogAge the only one
  *@return humanAge
  */
    static int convertDogToHumanYears(int dogAge) {
        int humanAge = (int) ((16 * Math.log(dogAge)) + 31);
        return humanAge;
    }
    /**
    *A method that will convert the age of a cat into human years
    *@param catAge the only one
    *@return humanAge
    */
    static int convertCattoHumanYears(int catAge) {
        int humanAge = (int) ((9 * Math.log(catAge)) + 18);
        return humanAge;
    }
    /**
    *A method that will ensure that all of the classes which extends this interface have a treat method
    */
    void treat();
}
