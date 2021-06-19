package StudentRepoProject;

import org.junit.Test;

public class StudentDatabaseTest {

    @Test  // Test checks normal method functionality. If method prints testStudent1, it works.
    public void StudentsDeletedByIDTest0 () {
        StudentDatabase test = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 1998, "Male", 383855401);
        Student testStudent1 = new Student("Xamolxes", "Davidson", 1998, "Male", 383855432);
        test.addToStudentDatabase(testStudent0);
        test.addToStudentDatabase(testStudent1);
        test.removeFromDBUsingID(383855401);
        System.out.println(test);
    }

    @Test // Test checks failure state if ID is empty.
    public void StudentsDeletedByIDTest1 () {
        StudentDatabase test = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 1998, "Male", 0);
        test.addToStudentDatabase(testStudent0);
        test.removeFromDBUsingID(383855401);
        System.out.println(test);
    }
    @Test // Test checks failure state if there is no student.
    public void StudentsDeletedByIDTest2 () {
        StudentDatabase test = new StudentDatabase();
        test.removeFromDBUsingID(383855401);
        System.out.println(test);
    }

    @Test // Test checks failure state if there are no students.
    public void StudentsSortedByAge0 () {
        StudentDatabase studentDBInstanceTest2 = new StudentDatabase();
        studentDBInstanceTest2.printStudentsByAge(23);

    }

    @Test // Test checks normal functionality.
    public void StudentsSortedByAge1 () {
        StudentDatabase studentDBInstanceTest3 = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 1990, "Male", 383855401);
        Student testStudent1 = new Student("Xamolxes", "Davidson", 1998, "Male", 383855401);
        Student testStudent2 = new Student("Xamolxes", "Davidson", 1943, "Male", 383855401);
        Student testStudent3 = new Student("Xamolxes", "Davidson", 1964, "Male", 383855401);


        studentDBInstanceTest3.addToStudentDatabase(testStudent0);
        studentDBInstanceTest3.addToStudentDatabase(testStudent1);
        studentDBInstanceTest3.addToStudentDatabase(testStudent2);
        studentDBInstanceTest3.addToStudentDatabase(testStudent3);
        studentDBInstanceTest3.printStudentsByAge(23);
    }

    @Test // Test checks age discrepancies. Note: Birth year check always takes priority over age check. You cannot throw an error for age being invalid if your birth year is invalid.
    public void StudentsSortedByAge2 () {
        StudentDatabase studentDBInstanceTest3 = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 2000, "Male", 383855401);
        Student testStudent1 = new Student("Xamolxes", "Davidson", 1800, "Male", 383855401);
        studentDBInstanceTest3.addToStudentDatabase(testStudent0);
        studentDBInstanceTest3.addToStudentDatabase(testStudent1);
        testStudent0.calculateAge();
        testStudent1.calculateAge();
        studentDBInstanceTest3.printStudentsByAge(23);

    }

    @Test // Test checks if input is empty.
    public void StudentsSortedByLastNameTest0 () {
        StudentDatabase studentDBInstanceTest0Empty = new StudentDatabase();
        StudentDatabase.compareLastNameJava8(studentDBInstanceTest0Empty.studentDatabase);
    }

    @Test // Test checks normal functionality.
    public void StudentsSortedByLastNameTest1 () {
        StudentDatabase studentDBInstanceTest1 = new StudentDatabase();
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "f", 1999, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "e", 1998, "female", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "d", 1997, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "c", 1996, "female", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "b", 1995, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "a", 1994, "female", 787782674));
        StudentDatabase.compareLastNameJava8(studentDBInstanceTest1.studentDatabase);

    }

    @Test // Test checks normal functionality.
    public void StudentsSortedByBirthDate0 () {

        StudentDatabase studentDBInstanceTest1 = new StudentDatabase();
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "f", 1954, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "e", 1943, "female", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "d", 1963, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "c", 1923, "female", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Dave", "b", 1989, "Male", 787782674));
        studentDBInstanceTest1.addToStudentDatabase(new Student("Ada", "a", 1934, "female", 787782674));
        StudentDatabase.compareBirthDateJava8(studentDBInstanceTest1.studentDatabase);

    }

}