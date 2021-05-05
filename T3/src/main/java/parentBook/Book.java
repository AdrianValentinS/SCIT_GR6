package parentBook;

public class Book {

    @Override
    public String toString() {
        return "Book: " + bookName + ";" + " Pages: " + pageNumber + ";"; // Acest toString permite compilatorului sa comunice utilizatorului informatia necesara pentru identificarea cartilor.
    }

    private String bookName;        // Aici sunt definiti parametri de baza a unei carti.
    private int pageNumber;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
