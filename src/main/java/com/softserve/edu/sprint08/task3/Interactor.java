package com.softserve.edu.sprint08.task3;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class Interactor {

    static final String SERV_RUN = "Serving thread running";
    static final String SERV_INIT = "Serving thread initializes the key";
    static final String SERV_KEY_VALUE = "key = %s";
    static final String SERV_RESUME = "Serving thread resumed";
    static final String CONS_GET_KEY = "Consuming thread received the key. key = %s";
    static final String CONS_UPDATE_KEY = "Consuming thread changed the key. key = %s";

    int x;

    public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
        printMsg(SERV_RUN);
        printMsg(SERV_INIT);
        x = uo.apply(initializer);
        printMsg(SERV_KEY_VALUE, x);
        synchronized (this) {
            notify();
            wait();
            printMsg(SERV_RESUME);
        }
    }

    public synchronized void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
        wait(3000);
        printMsg(CONS_GET_KEY, x);
        x = bo.apply(x, operand2);
        printMsg(CONS_UPDATE_KEY, x);
        notify();
    }

    void printMsg(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
