package sprint08.task2;

import sprint08.task1.ParallelCalculator;

public class Accountant {

    public static int sum(int x, int y) {
        ParallelCalculator calc = new ParallelCalculator(Integer::sum, x, y);
        Thread calcThread = new Thread(calc);
        calcThread.start();
        try {
            calcThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calc.result;
    }
}
