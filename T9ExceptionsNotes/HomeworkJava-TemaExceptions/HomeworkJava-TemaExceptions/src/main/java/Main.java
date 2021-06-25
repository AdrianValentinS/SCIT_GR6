import java.util.logging.Logger;

public class Main {

    public static Logger logger = Logger.getLogger(University.class.getName());

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Main.logger = logger;
    }

    public static void main(String[] args) throws Validation {


        Student s1 = new Student("Vasile", "Non", "1998", 12334155, "M");
        Student s2 = new Student("Cristina", "S", "1997", 1233415235, "f");
        Student s3 = new Student("Maria", "Bop", "1997", 12355122, "F");
        Student s4 = new Student("Marcel", "AG", "1960", 26324244, "M");
        Student s5 = new Student("Ion", "Zurs", "1980", 2634244, "M");
        Student s6 = new Student("Mircea", "Yurs", "1980", 2634244, "M");
        University university2 = new University();

        University university = new University();
        university.addStudent(s1);
        university.addStudent(s2);
        university.addStudent(s3);
        university.addStudent(s4);
        university.addStudent(s5);
        university.addStudent(s6);

        //delete a specific student search by ID
       university.deleteStudentbyID(university.studentList,2634244);

        // search a students by age from the university and list all
        university.studentsAge(231);

        // list students from a specific university  by name or by birthyear
        university.listStudentByLastName(university.studentList);
        university.listStudentByBirthDate(university.studentList);

        //list students from a university that has no students xD
        university2.listStudentByBirthDate(university2.studentList);

//        System.out.println(university.studentList);

    }


}
