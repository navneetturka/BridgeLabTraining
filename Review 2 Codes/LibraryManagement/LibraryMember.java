
import java.util.ArrayList;
import java.util.List;

public abstract class LibraryMember {

    protected String name;
    protected int memberId;
    protected List<Book> borrowedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public int borrowedCount() {
        return borrowedBooks.size();
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public abstract int getBorrowLimit();
}
