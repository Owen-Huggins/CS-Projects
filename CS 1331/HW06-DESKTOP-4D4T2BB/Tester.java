public class Tester {
    public static void main(String[] args) {
      LibraryItem[] bookshelf1 = new LibraryItem[4];

      Book book1 = new Book("Book1", 8, "A book", 99);
      Book book2 = new Book("Book2", 7, "The second book", 100);
      Book book3 = new Book("Book3", 9, "The Third book", 99);
      Book book4 = new Book("Book4", 10, "The Fourth book", 10);


      addLibraryItem(bookshelf1);
      browseLibraryItems();
    }
}
