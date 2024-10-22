package com.yb.progconc.threads;

public class Exercise4 {
    public static void main(String[] args) {
        HeaderProgram.showMainHeader();

        // Exercise nº 4
        HeaderProgram.showSubHeader("Exercício 4");

        Thread t1 = new Thread(new MyThreadSleep("abc1.1"));
        Thread t2 = new Thread(new MyThreadSleep("abc2.1"));
        Thread t3 = new Thread(new MyThreadSleep("abc3.1"));

        t1.start();
        t2.start();
        t3.start();

        Thread monitorThread = new Thread(new MyMonitorThread(
                new Thread[]{t1, t2, t3}
        ));
        monitorThread.start();

        try {
            // Wait 0.5 second
            Thread.sleep(500);
            System.out.println("Enviando interrupções...");
            t1.interrupt();
            t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida.");
        }

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida.");
        }
    }
}
