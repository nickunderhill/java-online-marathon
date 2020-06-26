package sprint05.task4;

public class TestResult {
    public static void main(String[] args) throws NameException, CodeException {
        Person p = Person.buildPerson("John", "Doe", "1111111111");
        Person p1 = Person.buildPerson("John", "Doe", "1111111111");
        System.out.println(p1.equals(p));


    }

}
/*
IllegalArgumentException with message Incorrect value io for firstName (should start from upper case and contains only alphabetic characters and symbols -, _); Incorrect value 23 for code (should contains exactly 10 digits)
IllegalArgumentException with message Incorrect value io for firstName (should start from upper case and contains only alphabetic characters and symbols -, _);Incorrect value 23 for code (should contains exactly 10 digits)
*/