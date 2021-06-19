package StudentRepoProject;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import static StudentRepoProject.Main.LOGGER;

// Student class defines object fields and some methods for functionality.

public class Student {

    private String firstName;
    private String lastName;
    private int birthDate;
    private String gender;
    private int ID;

    // Method for processing object fields. Each field has a checker for correct input and crashes the program if input is incorrect.

    public Student(String firstName, String lastName, int birthDate, String gender, int ID) {
        if(firstNameChecker(firstName)){
            this.firstName = firstName;
        }
        if(lastNameChecker(lastName)){
            this.lastName = lastName;
        }
        if(birthDateChecker(birthDate)){
            this.birthDate = birthDate;
        }
        if(genderChecker(gender)){
            this.gender = gender;
        }
        this.ID = ID;

    }

    public Student() {

    }

    /**@param gender Takes in gender and checks if Male/Female uppercase or lowercase, else throws error.
     */

    public boolean genderChecker(String gender) {
        if((!gender.equalsIgnoreCase("Male") && (!gender.equalsIgnoreCase("Female")))){
            LOGGER.log(Level.WARNING, "Log error: cannot parse illegal gender.");
            throw new IllegalArgumentException("Illegal gender.");
        } else {
            return true;
        }
    }

    /**@param firstName Takes in name and throws error if it's empty or whitespace.
     */

    public boolean firstNameChecker(@NotNull String firstName) {
        if(firstName.equals("") || firstName.equals(" ")){
            LOGGER.log(Level.WARNING, "Log error: cannot parse illegal first name.");
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        return true;
    }

    /**@param lastName Takes in name and throws error if it's empty or whitespace.
     */

    public boolean lastNameChecker(String lastName) {
        if(lastName.equals("") || lastName.equals(" ")){
            LOGGER.log(Level.WARNING, "Log error: cannot parse illegal last name.");
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        return true;
    }

    /**@param birthDate Takes in birthDate, forbids entry of invalid birth dates.
     */

    public boolean birthDateChecker(int birthDate) {
        if(birthDate < 1900 || birthDate > 2003){
            LOGGER.log(Level.WARNING, "Log error: cannot parse illegal birth date.");
            throw new IllegalArgumentException("Student is either too young or too old to be a student.");
        }
        return true;
    }

    // Calculates age for further use in a StudentDatabase method.

    public int calculateAge() {
        return Math.abs(getBirthDate() - 2021);
    }

    // Getters, setters, toString.

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", ID=" + ID +
                '}';
    }

}
