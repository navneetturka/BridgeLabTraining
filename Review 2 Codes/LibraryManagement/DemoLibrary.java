public class DemoLibrary {
    public static void main(String[] args) {
        Book b1 = new Book("New World", "Robert C. Martin", "ISBN-111");
        Book b2 = new Book("Java Basics", "Someone", "ISBN-222");
        Book b3 = new Book("Data Structures", "MK Rama", "ISBN-333");

        StudentMember student = new StudentMember("Navneet", 201);
        FacultyMember faculty = new FacultyMember("Anshika", 301);

        Librarian librarian = new Librarian();

        librarian.IssueBook(student, b1);
        librarian.IssueBook(student, b2);
        librarian.ReturnBook(student, b1);

        librarian.IssueBook(faculty, b1);
        librarian.IssueBook(faculty, b3);
    }
}
