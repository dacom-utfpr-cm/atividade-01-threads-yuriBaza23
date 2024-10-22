package com.yb.progconc.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SumThread implements Runnable {
    private final List<Integer> numbers;
    private int sum;

    public SumThread(List<Integer> numbers) {
        this.numbers = numbers;
        this.sum = 0;
    }

    @Override
    public void run() {
        // Realizar a soma dos números
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("A soma dos números digitados é: " + sum);
    }

    public int getSum() {
        return sum;
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        // Ler os números digitados pelo usuário
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Digite uma sequência de números inteiros:");
        System.out.println("(digite qualquer valor não numérico para encerrar ou somar)");

        // Continuar lendo até que o usuário pare de digitar números válidos
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        // Criar a thread para realizar a soma
        SumThread sumTask = new SumThread(numbers);
        Thread sumThread = new Thread(sumTask);

        // Iniciar a thread de soma
        sumThread.start();

        try {
            // Aguardar a conclusão da thread de soma usando join()
            sumThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread principal foi interrompida.");
        }

        // Continuar o fluxo após a soma ser finalizada
        System.out.println("Thread de soma finalizada. Resultado exibido.");
    }
}
