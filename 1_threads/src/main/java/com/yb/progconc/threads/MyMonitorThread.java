package com.yb.progconc.threads;

class MyMonitorThread implements Runnable {
    private final Thread[] threads;

    public MyMonitorThread(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {
            for (Thread t : threads) {
                if (t.isAlive() && t.isInterrupted()) {
                    System.out.println("minha nossa");
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("A thread de monitoramento foi interrompida.");
                break;
            }
        }
    }
}