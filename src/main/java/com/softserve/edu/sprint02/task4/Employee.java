package com.softserve.edu.sprint02.task4;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private final String name;
    private final int experience;
    private final BigDecimal basePayment;


    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience(), basePayment);
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public BigDecimal getPayment() {
        return this.basePayment.setScale(2);
    }

}

class Manager extends Employee {
    private final double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return this.coefficient;
    }

    @Override
    public BigDecimal getPayment() {
//        return super.getPayment().multiply(new BigDecimal(Double.toString(coefficient)),new MathContext(6));
        return (super.getPayment().multiply(BigDecimal.valueOf(coefficient))).setScale(2);
    }
}

class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> result = new java.util.ArrayList<Employee>(Collections.emptyList());
        BigDecimal maxPayment;
        int maxExp;

        if (workers.isEmpty() || workers.size() == 1) {
            return workers;
        }

        try {
            maxPayment = workers
                    .stream()
                    .max(Comparator.comparing(Employee::getPayment))
                    .get().getPayment();

            maxExp = workers
                    .stream()
                    .max(Comparator.comparing(Employee::getExperience))
                    .get().getExperience();
        } catch (NoSuchElementException exception) {
            return result;
        }

        for (Employee e : workers) {
            if (e == null) {
                return result;
            } else if (e.getExperience() == maxExp && e.getPayment().equals(maxPayment)) {
                result.add(e);
            }
            if (e.getExperience() == maxExp || e.getPayment().equals(maxPayment)) {
                result.add(e);
            }
        }

        List<Employee> distinctEmp = result.stream().distinct().collect(Collectors.toList());
        result = distinctEmp;

        return result;
    }
}