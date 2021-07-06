package StudentRepoProject;


import java.util.logging.Logger;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        // See unit tests for method/object functionality checks. Main class proves normal logger functionality.

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        LOGGER.info("Logger initialized.");

        StudentDatabase studentDB0 = new StudentDatabase();
        studentDB0.addToStudentDatabase(new Student("Dave", "f", 1954, "Male", 787782674));
        studentDB0.addToStudentDatabase(new Student("Ada", "e", 1998,"female", 787782674));
        studentDB0.addToStudentDatabase(new Student("Dave", "d", 1963, "Male", 787782674));
        studentDB0.addToStudentDatabase(new Student("Ada", "c", 1923,"female", 787782674));
        studentDB0.addToStudentDatabase(new Student("Dave", "b", 1989, "Male", 787782674));
        studentDB0.addToStudentDatabase(new Student("Ada", "a", 1934,"female", 787782674));
        studentDB0.addToStudentDatabase(new Student("Xamolxes", "Davidson", 1998, "Male", 383855401));

        studentDB0.removeFromDBUsingID(383855401);

        for (Student student : studentDB0.studentDatabase) {
            student.calculateAge();
        }
        studentDB0.printStudentsByAge(23);

        StudentDatabase.compareLastNameJava8(studentDB0.studentDatabase);
        StudentDatabase.compareBirthDateJava8(studentDB0.studentDatabase);

    }
}
