/**
*This class represents a Book object.
*@author Owen Huggins
*@version 1.0
*/
public class Book extends LibraryItem {
    private String backcoverBlurb;
    private int pages;
/**
*A constructor method for Book
*@param title the title of the book
*@param libraryCode the code of the book
*@param backcoverBlurb a description of the book
*@param pages the number of pages in the book
*/
    public Book(String title, int libraryCode, String backcoverBlurb, int pages) {
        super(title, libraryCode);
        this.backcoverBlurb = backcoverBlurb;
        this.pages = pages;

    }

/**
*A method that overides summarize adding its pages and backcoverBlurb to the description
*@return a string with the information of the book
*/
    public String summarize() {
        return  (super.summarize() + " The book is " + this.pages + " long. " + this.backcoverBlurb);
    }


}
