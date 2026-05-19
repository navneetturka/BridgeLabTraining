public class FacultyMember extends LibraryMember {

    public FacultyMember(String name, int memberId) {
        super(name, memberId);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}
