package sprint08.task1;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {
    int operand1, operand2;
    public int result;
    BinaryOperator<Integer> operator;

    public ParallelCalculator(BinaryOperator<Integer> operator, int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    @Override
    public void run() {
        result = operator.apply(operand1, operand2);
    }
}
