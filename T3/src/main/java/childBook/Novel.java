package childBook;

import parentBook.Book;

public class Novel extends Book {
    private String bookType;        // Aici sunt definiti parametri specifici unei Nuvele.

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return super.toString() + " Genre: " + getBookType(); // Acest toString permite compilatorului sa comunice utilizatorului informatie legata exclusiv de Nuvele.
    }

}
