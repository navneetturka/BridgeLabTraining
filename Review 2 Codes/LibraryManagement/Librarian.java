
public class Librarian {

    public void IssueBook(LibraryMember member, Book book) {
        if (member == null || book == null) {
            System.out.println("Issue failed: member or book missing.");
            return;
        }

        if (!book.availability) {
            System.out.println("Issue failed: Book is not available.");
            return;
        }

        if (member.borrowedCount() >= member.getBorrowLimit()) {
            System.out.printf("Issue failed: %s reached borrow limit (%d).%n", member.name, member.getBorrowLimit());
            return;
        }

        member.getBorrowedBooks().add(book);
        book.availability = false;
        System.out.printf("Book issued: %s to %s%n", book.title, member.name);
    }

    public void ReturnBook(LibraryMember member, Book book) {
        if (member == null || book == null) {
            System.out.println("Return failed: member or book missing.");
            return;
        }

        boolean removed = member.getBorrowedBooks().remove(book);
        if (!removed) {
            System.out.println("Return failed: this book was not borrowed by the member.");
            return;
        }

        book.availability = true;
        System.out.printf("Book returned: %s by %s%n", book.title, member.name);
    }
}
