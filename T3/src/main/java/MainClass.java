import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import parentBook.Book;
import childBook.Novel;
import childBook.Album;         // Importam pachete (packages) de care putem avea nevoie.

public class MainClass {
    public static void main(String[] args) {

        Library Library1 = new Library();   // Se cheama vectorul (array-ul).

        Novel Novel1 = new Novel();     //Se instantiaza prima carte, se introduc atributiile obiectului.

        Novel1.setBookName("Catch-22");
        Novel1.setPageNumber(453);
        Novel1.setBookType("War Story");

        Album Album1 = new Album();     //Se initializeaza a doua carte.
        Album1.setBookName("Family Memories");
        Album1.setPageNumber(120);
        Album1.setBookPaperQuality("Premium");

        Library1.addBook(Novel1);       //Se adauga cartile in array.
        Library1.addBook(Album1);

        System.out.println(Arrays.toString(Library1.getBookArray()));       // Printare: Exista 2 carti. Aici aflam ce contine libraria (lista cartilor) si atributiile cartilor.

        Library1.deleteBook(1);    // Aici stergem orice carte intr-un array aflata in orice pozitie in index.

        System.out.println(Arrays.toString(Library1.getBookArray()));       // Printare: Exista o carte.

        Library1.deleteBook(0);

        System.out.println(Arrays.toString(Library1.getBookArray()));       // Printare: Libraria este goala.

    }
}
