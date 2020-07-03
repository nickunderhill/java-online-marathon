package sprint07.task1;

public class testResult {
    public static void main(String[] args) {
      System.out.println(CheckCamelCase.checkAndPrint(Class1.class));
        System.out.println(CheckCamelCase.checkAndPrint(Class2.class));
        System.out.println(CheckCamelCase.checkAndPrint(ClassForAnnot.class));
        CheckCamelCase.checkAndPrint(Class1.class);
        CheckCamelCase.checkAndPrint(Class2.class);
        CheckCamelCase.checkAndPrint(ClassForAnnot.class);
    }
}
