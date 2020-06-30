package sprint06.task4;

public class TestResults {

    public static void main(String[] args) {
        Shop s = new Shop();
        Person p1 = new Person("John");
        s.clients.add(p1.goShopping);
        Person p2 = new Person("Jack");
        s.clients.add(p2.goShopping);
        Person p3 = new Person("George");
        s.clients.add(p3.goShopping);
        Person p4 = new Person("Brad");
        System.out.println(s.sale("product1", 101));
    }
}
