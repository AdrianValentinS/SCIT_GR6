package StudentRepoProject;

import org.junit.Test;


public class StudentTest {

    @Test(expected = IllegalArgumentException.class)
    public void studentFirstNameTest () {
        Student testStudent0 = new Student("", "Smith", 1987, "Male", 787782674);
    }

    @Test(expected = IllegalArgumentException.class)
    public void studentLastNameTest () {
        Student testStudent0 = new Student("John", "", 1987, "Male", 787782674);
    }

    @Test(expected = IllegalArgumentException.class)
    public void studentBirthDateTest () {
        Student testStudent0 = new Student("John", "Smith", 2021, "Male", 787782674);
    }
    @Test(expected = IllegalArgumentException.class)
    public void studentGenderTest () {
        Student testStudent0 = new Student("John", "Smith", 1976, "helicopter", 787782674);
    }

}