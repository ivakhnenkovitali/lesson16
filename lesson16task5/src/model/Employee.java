package model;

public class Employee extends Person {
    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toFileLine() {
        return super.toFileLine() + " " + salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", salary=" + salary +
                '}';
    }
}
