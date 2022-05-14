//I worked on the homework assignment alone, using only course materials

/**
*This class represents an abstract LibraryItem object.
*@author Owen Huggins
*@version 1.0
*/

public abstract class LibraryItem implements Summarizable, Comparable<LibraryItem> {
    private String title;
    private int libraryCode;
/**
*A getter method for the title which returns the getTitle.
*@return title.
*/
    public String getTitle() {
        return title;
    }
/**
*A getter method for the libraryCode
*@return libraryCode
*/
    public int getLibraryCode() {
        return libraryCode;
    }
/**
*A setter for the title.
*@param title the only variable
*/
    public void setTitle(String title) {
        this.title = title;
    }

/**
*A constructor for LibraryItem that sets the title and libraryCode.
*@param title the first one
*@param libraryCode the second one
*/
    public LibraryItem(String title, int libraryCode) {
        this.title = title;
        this.libraryCode = libraryCode;
    }
    @Override
    public String summarize() {
        return ("This item is called " + this.title + ".");
    }
/**
*A method that compares one LibraryItem to another
*@param another an object of the class LibraryItem
*@return returns either a positive, negative number if it's less than or greater than and 0 if they're equal
*/
    public int compareTo(LibraryItem another) {
        return -(this.libraryCode - another.libraryCode);

    }
}
