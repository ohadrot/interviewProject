package persons;

public class Person {
    private String Name;
    private int age;
    private int id;

    public Person(String name, int age, int id) {
        Name = name;
        this.age = age;
        this.id = id;
    }

    public String getJob() {
        return null;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}
