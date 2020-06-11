package sprint01.task2;

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

        int forIndex = 0;
        for (Employee emp:employees) {
            employeesInfo += (String.format("{fullName: \"%s\", salary: %s}", emp.fullName, emp.salary ));
            if(forIndex != employees.length - 1) {
                employeesInfo += ", ";
            }
            forIndex++;
        }

        employeesInfo = "[" + employeesInfo + "]";

        System.out.println(employeesInfo); // debug
    }
}
