
public class StudentMember extends LibraryMember {

    public StudentMember(String name, int memberId) {
        super(name, memberId);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}
