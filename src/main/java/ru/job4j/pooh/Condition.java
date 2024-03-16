package ru.job4j.pooh;

public class Condition {
    private volatile boolean flag = false;

    synchronized void on() {
        flag = true;
        notifyAll();
    }

    synchronized void off() {
        flag = false;
        notifyAll();
    }

    synchronized void await() throws InterruptedException {
        while (!flag) {
            wait();
        }
    }

    boolean check() {
        return flag;
    }
}