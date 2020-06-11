package sprint01.task2;

import java.util.Arrays;

public class Employee {
    public String fullName;
    public float salary;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        emp1.fullName = "John Snow";
        emp1.salary = 350.5F;
        emp2.fullName = "Jack Black";
        emp2.salary = 500.1F;

        Employee[] employees = new Employee[]{emp1, emp2};

        String employeesInfo = "";
        String[] employeesStringArr = new String[employees.length];

        int forIndex = 0;
        for (Employee emp:employees) {
            employeesStringArr[forIndex] = "{fullName: \"" + emp.fullName + "\", salary: " + emp.salary + "}";
            forIndex++;
        }

        employeesInfo = Arrays.toString(employeesStringArr);

        System.out.println(employeesInfo); // debug
    }
}
