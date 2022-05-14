import java.util.Arrays;
/**
*This class represents a Library object.
*@author Owen Huggins
*@version 1.0
*/
public class Library {
    private LibraryItem[] bookshelf;
    private static final LibraryItem[] DEFAULTBOOKSHELF = new LibraryItem[0];
/**
*This method is the first constructor for Library
*/
    public Library() {
      this(DEFAULTBOOKSHELF);
    }
/**
*This method is the second constructor for Library
*@param bookshelf that is an array of LibraryItem objects
*/
    public Library(LibraryItem[] bookshelf) {
        Arrays.sort(bookshelf);
        this.bookshelf = bookshelf;
    }
/**
*A method to print out all of the books on the bookshelf
*/
    public void browseLibraryItems() {
        for (int i = 0; i < bookshelf.length; i++) {
            System.out.println(bookshelf[i].getLibraryCode() + ": " + bookshelf[i].summarize());
        }
    }
/**
*A method to create a new bookshelf with one extra book
*@param newItem is a LibraryItem object that is added on to bookshelf
*/
    public void addLibraryItem(LibraryItem newItem) {
        LibraryItem[] newbookshelf = new LibraryItem[bookshelf.length + 1];
        for (int i = 0; i < bookshelf.length; i++) {
            newbookshelf[i] = bookshelf[i];
        }
        newbookshelf[newbookshelf.length - 1] = newItem;
        Arrays.sort(newbookshelf);
        this.bookshelf = newbookshelf;
    }
/**
*A method that finds the first LibraryItem with the given libraryCode
*@param code the only variable
*@return a Library item if it can find one or null if it can't
*/

    public LibraryItem getLibraryItem(int code) {
        for (int i = 0; i < bookshelf.length; i++) {
            if (code == bookshelf[i].getLibraryCode()) {
                return (bookshelf[i]);
            }

        }
        return (null);
    }
/**
*A method that finds the number of books on the bookshelf
*@return the number of books on the bookshelf
*/
    public int getNumberOfItems() {
        return (bookshelf.length);
    }




}
