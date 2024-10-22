package com.yb.progconc.threads;

import java.util.Random;

public class MyThreadSleep implements Runnable {
    private final String threadName;

    public MyThreadSleep(String threadName) {
        this.threadName = threadName;
    }

    public String getName() {
        return threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + threadName + " executed!");

            Random random = new Random();
            int sleepTime = random.nextInt(5000) + 1000;

            System.out.println("Sleeping for " + sleepTime + " ms");
            Thread.sleep(sleepTime);

            System.out.println("Thread " + threadName + " finished!");
        } catch (InterruptedException exception) {
            System.out.println("MyThreadSleep " + getName() + " interrupted");
        }
    }
}
