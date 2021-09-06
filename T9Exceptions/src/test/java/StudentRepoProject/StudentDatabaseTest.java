package StudentRepoProject;

import org.junit.Test;

public class StudentDatabaseTest {

    @Test(expected = IllegalArgumentException.class) // Test checks failure state if ID is empty.
    public void studentsDeletedByIDTest1 () {
        StudentDatabase test = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 1998, "Male", 0);
        test.addToStudentDatabase(testStudent0);
        test.removeFromDBUsingID(383855401);
        System.out.println(test);
    }
    @Test(expected = IllegalArgumentException.class) // Test checks failure state if there is no student.
    public void studentsDeletedByIDTest2 () {
        StudentDatabase test = new StudentDatabase();
        test.removeFromDBUsingID(383855401);
        System.out.println(test);
    }

    @Test(expected = IllegalArgumentException.class) // Test checks failure state if there are no students.
    public void studentsSortedByAge0 () {
        StudentDatabase studentDBInstanceTest2 = new StudentDatabase();
        studentDBInstanceTest2.printStudentsByAge(23);

    }

    @Test(expected = IllegalArgumentException.class) // Test checks age discrepancies. Note: Birth year check always takes priority over age check. You cannot throw an error for age being invalid if your birth year is invalid.
    public void studentsSortedByAge2 () {
        StudentDatabase studentDBInstanceTest3 = new StudentDatabase();
        Student testStudent0 = new Student("Xamolxes", "Davidson", 2000, "Male", 383855401);
        Student testStudent1 = new Student("Xamolxes", "Davidson", 1800, "Male", 383855401);
        studentDBInstanceTest3.addToStudentDatabase(testStudent0);
        studentDBInstanceTest3.addToStudentDatabase(testStudent1);
        testStudent0.calculateAge();
        testStudent1.calculateAge();
        studentDBInstanceTest3.printStudentsByAge(23);

    }

    @Test(expected = IllegalArgumentException.class) // Test checks if input is empty.
    public void studentsSortedByLastNameTest0 () {
        StudentDatabase studentDBInstanceTest0Empty = new StudentDatabase();
        StudentDatabase.compareLastNameJava8(studentDBInstanceTest0Empty.studentDatabase);
    }

}