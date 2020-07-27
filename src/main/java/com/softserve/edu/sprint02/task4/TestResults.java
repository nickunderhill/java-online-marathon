package sprint02.task4;

import java.math.BigDecimal;
import java.util.*;

public class TestResults {
    public static void main(String[] args) {
        MyUtils test = new MyUtils();

        List<Employee> workers = new java.util.ArrayList<>(Collections.emptyList());
        workers.add(new Employee("Ivan",10,new BigDecimal("3000.00")));
        workers.add(new Manager("Petro",9,new BigDecimal("3000.00"),1.5));
        workers.add(new Employee("Stepan",8,new BigDecimal("4000.00")));
        workers.add(new Employee("Andriy",7,new BigDecimal("3500.00")));
        workers.add(new Employee("Ihor",5,new BigDecimal("4500.00")));
        workers.add(new Manager("Vasyl",8,new BigDecimal("2000.00"),2.0));

        System.out.println("===Test base===");
        List<Employee> newWorkers;
        newWorkers = test.largestEmployees(workers);
        for (Employee e: newWorkers) {
            System.out.print("Name: " + e.getName());
            System.out.print(", Salary: " + e.getPayment());
            System.out.print(", Experience: " + e.getExperience());
            System.out.println();
        }

        List<Employee> originList = new ArrayList<>();
        originList.add(new Employee("Ivan",10,new BigDecimal("3000.00")));
        originList.add(new Manager("Petro",9,new BigDecimal("3000.00"),1.5));

        System.out.println("===Test One employee");

        List<Employee> oneEmp = new ArrayList<>();
        oneEmp.add(new Employee("Ivan",10,new BigDecimal("3000.00")));

        new MyUtils().largestEmployees(oneEmp);
        System.out.println(oneEmp.get(0).getName());


        System.out.println("===Test Duplicate Emp===");
        List<Employee> dupEmp = new ArrayList<>();
        dupEmp.add(new Employee("Ivan",10,new BigDecimal("3000.00")));
        dupEmp.add(new Employee("Ivan",10,new BigDecimal("3000.00")));

        List<Employee> newdupEmp;
        newdupEmp = test.largestEmployees(dupEmp);
        for (Employee e: newdupEmp) {
            System.out.print("Name: " + e.getName());
            System.out.print(", Salary: " + e.getPayment());
            System.out.print(", Experience: " + e.getExperience());
            System.out.println();
        }

        System.out.println("===Test checkDuplicatePayment===");
        List<Employee> checkDuplicatePayment = new ArrayList<>();
        checkDuplicatePayment.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
        checkDuplicatePayment.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
        checkDuplicatePayment.add(new Employee("Ihor", 5, new BigDecimal(4500.00)));
        checkDuplicatePayment.add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));

        List<Employee> newCheckDuplicatePayment;
        newCheckDuplicatePayment = test.largestEmployees(checkDuplicatePayment);
        for (Employee e: newCheckDuplicatePayment) {
            System.out.print("Name: " + e.getName());
            System.out.print(", Salary: " + e.getPayment());
            System.out.print(", Experience: " + e.getExperience());
            System.out.println();
        }

    }
}

/* For example, for a given list
 [Employee [name=Ivan, experience=10, basePayment=3000.00],
 Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
 Employee [name=Stepan, experience=8, basePayment=4000.00],
 Employee [name=Andriy, experience=7, basePayment=3500.00],
 Employee [name=Ihor, experience=5, basePayment=4500.00],
 Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
you should get
[Employee [name=Ivan, experience=10, basePayment=3000.00],
Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
Employee [name=Ihor, experience=5, basePayment=4500.00]].*/
