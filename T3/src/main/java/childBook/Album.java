package childBook;

import parentBook.Book;

public class Album extends Book {
    private String bookPaperQuality;    // Aici sunt definiti parametri specifici unui Album.

    public String getBookPaperQuality() {
        return bookPaperQuality;
    }

    public void setBookPaperQuality(String bookPaperQuality) {
        this.bookPaperQuality = bookPaperQuality;
    }

    @Override
    public String toString() {
        return super.toString() + " Quality: " + bookPaperQuality; // Acest toString permite compilatorului sa comunice utilizatorului informatie legata exclusiv de Nuvele.
    }
}
