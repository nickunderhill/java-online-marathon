package com.softserve.edu.sprint05.task5;

class CheckingAccount {
    private double balance;
    private final int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientAmountException(needs);
        }
    }
}

class BankDemo {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }

    //Test
    public static void main(String[] args) {
        doOperations();
    }
}

//Task Answer Body Start
class InsufficientAmountException extends Exception {
    double amount;

    public InsufficientAmountException(double amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }

    @Override
    public String getMessage() {
        return "Sorry, but you are short $" + getAmount();
    }
}
//Task Answer Body End
