package sprint04.task6;

public class Test {
    public static void main(String[] args) {
        Person[] peopleArray = new Person[]{
                new Person("John", 40),
                new Person("John", 23),
                new Employee("Fred Worker", 25, 1000),
                new Employee("Emma Worker", 30, 1400),
                new Developer("Lucy Coder", 25, 1000,Level.JUNIOR),
                new Developer("James Coder", 31, 2000, Level.MIDDLE)
        };

        Employee[] employeeArray = new Employee[]{
                new Employee("Fred Worker", 25, 1000),
                new Employee("Fred Worker", 25, 4000),
                new Employee("Emma Worker", 30, 1400),
                new Developer("Lucy Coder", 25, 1000,Level.JUNIOR),
                new Developer("James Coder", 31, 2000, Level.MIDDLE)
        };

        System.out.println("===Person Before:");
        for (Person p:peopleArray) {
            System.out.println("Name: " + p.name + ", Age: " + p.age);
        }

        Utility.sortPeople(peopleArray, new PersonComparator());

        System.out.println("===Person After:");
        for (Person p:peopleArray) {
            System.out.println("Name: " + p.name + ", Age: " + p.age);
        }

        System.out.println("===Employee Before:");
        for (Employee e:employeeArray) {
            System.out.println("Name: " + e.name + ", Age: " + e.age + ", Salary: " + e.getSalary());
        }

        Utility.sortPeople(employeeArray, new EmployeeComparator());

        System.out.println("===Employee After:");
        for (Employee e:employeeArray) {
            System.out.println("Name: " + e.name + ", Age: " + e.age + ", Salary: " + e.getSalary());
        }
    }

}
