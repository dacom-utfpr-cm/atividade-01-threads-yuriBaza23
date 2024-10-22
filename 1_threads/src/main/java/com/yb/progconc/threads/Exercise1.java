package com.yb.progconc.threads;

public class Exercise1 {
    public static void main(String[] args) {
        HeaderProgram.showMainHeader();

        // Exercise nº 1
        HeaderProgram.showSubHeader("Exercício 1");
        new Thread(new MyThreadSleep("abc1")).start();
        new Thread(new MyThreadSleep("abc2")).start();
        new Thread(new MyThreadSleep("abc3")).start();
    }
}
