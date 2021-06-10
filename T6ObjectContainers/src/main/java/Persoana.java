public class Persoana {

    private int age;
    private String name;
    private String cnp;


    public Persoana(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Persoana: " + "age = " + age + ", name = " + "'" + name;
    }

}

