package com.softserve.edu.sprint01.task3;

public class Employee {
    private String fullName;
    private float salary;

    public Employee() {
    }

    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    //debug
    public static void main(String[] args) {
        Employee e1 = new Employee();
        System.out.println(e1.fullName);
        System.out.println(e1.salary);

        Employee e2 = new Employee("John Doe", 1);
        System.out.println(e2.fullName);
        System.out.println(e2.salary);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
