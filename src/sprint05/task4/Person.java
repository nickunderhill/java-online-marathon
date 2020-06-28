package sprint05.task4;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public void setFirstName(String firstName) throws NameException {
        if (validateName(firstName)) {
            this.firstName = firstName;
        } else throw new NameException("Incorrect value " +
                firstName +
                " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)");
    }

    public void setLastName(String lastName) throws NameException {
        if (validateName(lastName)) {
            this.lastName = lastName;
        } else throw new NameException("Incorrect value " +
                lastName +
                " for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)");
    }

    public void setIdCode(String idCode) throws CodeException {
        if (validateId(idCode)) {
            this.idCode = idCode;
        } else throw new CodeException("Incorrect value " +
                idCode +
                " for code (should contains exactly 10 digits)");
    }

    static Person buildPerson(String firstName, String lastName, String idCode) throws IllegalArgumentException {
        Person p = new Person();
        String exceptionsMessages = "";
        try {
            p.setFirstName(firstName);
        } catch (NameException e) {
            exceptionsMessages += e.getMessage() + "; ";
        }
        try {
            p.setLastName(lastName);
        } catch (NameException e) {
            exceptionsMessages += e.getMessage() + "; ";
        }
        try {
            p.setIdCode(idCode);
        } catch (CodeException e) {
            exceptionsMessages += e.getMessage();
        }
        if (exceptionsMessages.length() == 0) {
            return p;
        } else {
            throw new IllegalArgumentException(exceptionsMessages);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }

    private boolean validateName(String s) {
        boolean result = false;
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z' || c == '-' || c == ' ')) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        } else {
            return false;
        }
        return result;
    }

    private boolean validateId(String s) {
        boolean result = false;
        if (s.length() != 10) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9')) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}
