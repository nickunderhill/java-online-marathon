package com.softserve.edu.sprint03.task6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder {
    ASC,
    DESC
}

@SuppressWarnings("unchecked")
class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;
    private SortOrder sortOrder;

    public AddressBook(int capacity) {
        this.addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if (counter == size()) {
            addressBook = Arrays.copyOf(addressBook, size() * 2);
        }
        if (findIndex(firstName, lastName) == -1) {
            addressBook[counter++] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
            return true;
        }
        return false;
    }

    public String read(String firstName, String lastName) {
        int i = findIndex(firstName, lastName);
        if (size() > 0) {
            if (i > -1) {
                return addressBook[i].address;
            }
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        int i = findIndex(firstName, lastName);
        if (i > -1) {
            addressBook[i].address = address;
            return true;
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        int i = findIndex(firstName, lastName);
        if (i > -1) {
            System.arraycopy(addressBook, i + 1, addressBook, i, size() - i - 1);
            addressBook[size() - 1] = null;
            counter--;
            return true;
        }
        return false;
    }

    public int size() {
        return addressBook.length;
    }

    /**
     * Loops through addressList to find person by given keys pair.
     * Returns index if found and -1 if not.
     *
     * @param firstName - first name to search
     * @param lastName  - last name to search
     * @return int
     */
    private int findIndex(String firstName, String lastName) {
        NameAddressPair.Person tempPerson = new NameAddressPair.Person(firstName, lastName);
        for (int i = 0; i < size(); i++) {
            if (addressBook[i] != null && addressBook[i].person.equals(tempPerson)) {
                return i;
            }
        }
        return -1;
    }

    public void sortedBy(SortOrder order) {

        Arrays.sort(addressBook, 0, counter, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                int result = o1.person.firstName.compareTo(o2.person.firstName);
                if (result == 0) {
                    result = o1.person.lastName.compareTo(o2.person.lastName);
                }
                return sortOrder == SortOrder.ASC ? result : -result;
            }
        });

    }

    @Override
    public Iterator<AddressBook> iterator() {
        return new AddressBookIterator();
    }

    public String getFirstName(int i) {
        return addressBook[i].person.firstName;
    }

    public String getLastName(int i) {
        return addressBook[i].person.lastName;
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) &&
                        Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size() && addressBook[counter] != null;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                String s = "First name:"
                        + addressBook[counter].person.firstName
                        + ",Last name:"
                        + addressBook[counter].person.lastName
                        + ",Address:"
                        + addressBook[counter].address;
                this.counter++;
                return s;
            } else throw new IndexOutOfBoundsException(
            );
        }
    }
}

