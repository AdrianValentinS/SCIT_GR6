import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class University {

    private static Logger logger = Logger.getLogger(University.class.getName());

    List<Student> studentList;

    public University() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentbyID(List<Student> students,int ids) throws Validation {
        if (!students.removeIf(student -> student.getID() == ids)) {
            logger.log(Level.SEVERE, "error, the student doesn't exist , wrong ID input");
            throw new Validation("Student doesn't exist");
        }
        students.removeIf(student -> student.getID() == ids);
    }


    public void studentsAge(int age) {

        if (age < 0) {
            logger.log(Level.SEVERE, "Age negative problem" + logger.getName());
            throw new IllegalArgumentException("Age cannot be negative");
        }
        for (Student student : studentList) {
            if (student.getAge() == age) {
                System.out.println("Student: " + student.getFirstName());
            }
        }
    }

    public void listStudentByLastName(List<Student> students) {
        if (students.isEmpty()) {
            logger.log(Level.SEVERE, "List empty, sort by last name" + logger.getName());
            throw new IllegalArgumentException("In this list there are not students! Please add another list!");
        }
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println(students);
    }

    public void listStudentByBirthDate(List<Student> students) {
        if (students.isEmpty()) {
            logger.log(Level.SEVERE, "There is no list to sort it , by birthday ");
            throw new IllegalArgumentException("In this list there are not students! Please add another list!");
        }
        students.sort((o1, o2) -> o2.getDateBirthValue() - o1.getDateBirthValue());
        System.out.println(students);
    }
}


