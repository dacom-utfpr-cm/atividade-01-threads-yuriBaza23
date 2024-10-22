package com.yb.progconc.threads;

public class Exercise3 {
    public static void main(String[] args) {
        HeaderProgram.showMainHeader();

        // Exercise nº 3
        HeaderProgram.showSubHeader("Exercício 3");

        // Exercise 1 Threads
        Thread t1 = new Thread(new MyThreadSleep("abc1"));
        Thread t2 = new Thread(new MyThreadSleep("abc2"));
        Thread t3 = new Thread(new MyThreadSleep("abc3"));

        t1.start();
        t2.start();
        t3.start();

        try {
            // Wait 1 second
            Thread.sleep(1000);
            System.out.println("Enviando interrupções para as threads do Exercício 1...");
            t1.interrupt();
            t2.interrupt();
            t3.interrupt();

            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida.");
        }

        // Exercise 2 Threads
        Thread phraseReaderThread = new Thread(new MyPhraseReaderThread("quotes.txt", 10000));
        phraseReaderThread.start();

        try {
            // Wait 15 seconds
            Thread.sleep(15000);
            System.out.println("Enviando interrupção para a thread do Exercício 2...");
            phraseReaderThread.interrupt();

            phraseReaderThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida.");
        }

        System.out.println("Todas as threads terminaram.");
    }
}
