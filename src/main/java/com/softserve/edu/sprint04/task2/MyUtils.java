package com.softserve.edu.sprint04.task2;

import java.util.*;

public class MyUtils {
    //TEST
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();

        list1.add(new Student(1, "Ivan"));
        list1.add(new Student(2, "Petro"));
        list1.add(new Student(3, "Stepan"));

        list2.add(new Student(1, "Ivan"));
        list2.add(new Student(3, "Stepan"));
        list2.add(new Student(4, "Andriy"));

        System.out.println("===List1");
        for (Student s : list1
        ) {
            System.out.println(s.id + " " + s.name);
        }

        System.out.println("===List2");
        for (Student s : list2
        ) {
            System.out.println(s.id + " " + s.name);
        }

        MyUtils m = new MyUtils();

        Set<Student> result = m.commonStudents(list1, list2);

        System.out.println("===Result List");

        for (Student s : result
        ) {
            System.out.println(s.id + " " + s.name);
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        // Code
        Set<Student> result = new HashSet<>();
        for (Student s : list1) {
            if (list2.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static class Student {
        private final int id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
        // Constructor, methods, Code
    }
}
