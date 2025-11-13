public class Employee {
    private static int nextId = 1;

    private int id;
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary) {
        this.id = nextId++;
        this.fullname = fullname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, fullname='%s', salary=%.2f}",
                id, fullname, salary);
    }
}