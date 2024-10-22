package com.yb.progconc.threads;

public class Exercise2 {
    public static void main(String[] args) {
        HeaderProgram.showMainHeader();

        // Exercise nº 2
        HeaderProgram.showSubHeader("Exercicio 2");
        new Thread(new MyPhraseReaderThread("quotes.txt", 10000)).start();
    }
}
