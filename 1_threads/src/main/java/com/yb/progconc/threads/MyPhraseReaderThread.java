package com.yb.progconc.threads;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyPhraseReaderThread implements Runnable {
    final private String filePath;
    final private int ms;

    public MyPhraseReaderThread(String filePath, int ms) {
        this.filePath = filePath;
        this.ms = ms;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String phrase;
            while ((phrase = reader.readLine()) != null) {
                System.out.println("Frase: " + phrase);
                Thread.sleep(ms);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread foi interrompida: " + e.getMessage());
        }
    }
}
