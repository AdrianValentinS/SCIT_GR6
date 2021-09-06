package StudentRepoProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import static StudentRepoProject.Main.LOGGER;

public class StudentDatabase extends Student{

    // Basic setup for a list or Student type objects.

    List<Student> studentDatabase;

    public StudentDatabase() {
        studentDatabase = new ArrayList<>();
    }

    public void addToStudentDatabase(Student student) {
        studentDatabase.add(student);
    }

    public void removeFromStudentDatabase(Student student) {
        studentDatabase.remove(student);
    }

    /**@param ID Takes in ID and returns true if a student is deleted.
     */

    public void removeFromDBUsingID(int ID) {
        if(!studentDatabase.removeIf(student -> student.getID() == ID)) {
            LOGGER.log(Level.WARNING, "Log error: cannot parse illegal ID OR no student object.");
            throw new IllegalArgumentException("Cannot parse: no ID or no student object.");
        }
        System.out.println("Student with ID " + ID + " deleted.");
    }

    /** @param age This method takes in age after it has been calculated by the calculateAge method and returns
     *              students whose age confirms to the requested age entry parameter.
     */

    public void printStudentsByAge(int age) {
        if(studentDatabase.isEmpty()){
            LOGGER.log(Level.WARNING, "Log error: cannot parse empty database.");
            throw new IllegalArgumentException("Database cannot be empty.");
        }
        for (Student student : studentDatabase) {
            if(student.calculateAge() == age){
                System.out.println("Students listed by specified age: " + student);
            } else if(age < 0){
                throw new IllegalArgumentException("Age cannot be 0.");
            } else if(age < 18){
                throw new IllegalArgumentException("Student must be 18+.");
            } else if(age > 100){
                throw new IllegalArgumentException("Student must be under 100 years old.");
            }
        }
    }

    // Both methods use method references to sort and print a list of students by last name and birth date respectively.

    public static void compareLastNameJava8(List<Student> studentDatabaseTemp) {
        if (studentDatabaseTemp.isEmpty()){
            LOGGER.log(Level.WARNING, "Log error: cannot parse empty database.");
            throw new IllegalArgumentException("Cannot sort, student database is empty.");
        }
        Comparator<Student> lastNameComparator = Comparator.comparing(Student::getLastName);
        studentDatabaseTemp.sort(lastNameComparator);
        System.out.println("Students by last name: " + studentDatabaseTemp);
    }

    public static void compareBirthDateJava8(List<Student> studentDatabaseTemp) {
        if (studentDatabaseTemp.isEmpty()){
            LOGGER.log(Level.WARNING, "Log error: cannot parse empty database.");
            throw new IllegalArgumentException("Cannot sort, student database is empty.");
        }
        Comparator<Student> birthDateComparator = Comparator.comparing(Student::getBirthDate);
        studentDatabaseTemp.sort(birthDateComparator);
        System.out.println("Students by birth date: " + studentDatabaseTemp);
    }

    @Override
    public String toString() {
        return "Student database contents: {" + studentDatabase + '}';
    }
}