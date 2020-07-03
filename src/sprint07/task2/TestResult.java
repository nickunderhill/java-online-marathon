package sprint07.task2;

public class TestResult {
    public static void main(String[] args) throws ClassNotFoundException {
        Util.review("sprint07.task2.Class1");
        Util.review("sprint07.task2.Class2");
        Util.review("sprint07.task2.Class3");
        Util.review("sprint07.task2.Class4");

    }
}

@Review(reviewer = "me")
class Class1 {
}

@Review(reviewer = "he", date = "2020-07-01")
class Class2 {
}

class Class3 {
}


