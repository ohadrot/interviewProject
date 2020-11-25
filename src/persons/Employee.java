package persons;

import persons.Person;

public class Employee extends Person {
    private String Job;

    public Employee(String name, int age, int id) {
        super(name, age, id);
    }

    public Employee(String name, int age, int id, String job) {
        super(name, age, id);
        Job = job;
    }

    public String getJob() {
        return Job;
    }
}

