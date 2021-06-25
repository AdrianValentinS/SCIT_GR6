

public class StudentByLastNameComparator implements Comparable<Student> {


    @Override
    public int compareTo(Student o) {
        return o.getLastName().compareTo(o.getLastName());
    } // this was @NotNull before Student o
}
