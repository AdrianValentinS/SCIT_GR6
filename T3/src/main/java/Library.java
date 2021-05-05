import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import parentBook.Book;
import childBook.Novel;
import childBook.Album;

public class Library {

    Book[] bookArray;  // Am declarat array-ul.

    public Library() {

        bookArray= new Book[0]; // Am declarat ca array-ul stocheaza carti.

    }

    public Book[] getBookArray() {
        return bookArray;      // Prin aceasta metoda aflam lista cartilor.
    }

    public void addBook(Book book){
        this.bookArray = ArrayUtils.add(bookArray, book);           // Prin aceasta metoda introducem carti.
    }

    public void deleteBook(int index) {
        this.bookArray = ArrayUtils.remove(bookArray, index);    // Prin aceasta metoda stergem carti.
    }


}
