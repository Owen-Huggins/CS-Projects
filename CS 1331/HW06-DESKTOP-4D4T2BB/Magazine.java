/**
*This class represents a Magazine object.
*@author Owen Huggins
*@version 1.0
*/
public class Magazine extends LibraryItem {
    private String coverDescription;
/**
*A constructor for Magazine
*@param title the titel of the Magazine
*@param libraryCode the code for the Magazine
*@param coverDescription the description of the Magazine
*/
    public Magazine(String title, int libraryCode, String coverDescription) {
        super(title, libraryCode);
        this.coverDescription = coverDescription;

    }
/**
*A method that overides summarize adding the coverDescription
*@return a string with the Magazine's information
*/
    public String summarize() {
        return (super.summarize() + "This cover looks like " + coverDescription + ".");
    }
}
