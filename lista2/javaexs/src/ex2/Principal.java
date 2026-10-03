package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int ordem = 5;

        Matriz<Integer> matriz = new Matriz<Integer>(ordem, ordem);

        System.out.println("Digite os " + (ordem * ordem) + " valores inteiros da matriz:");
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                int valor = teclado.nextInt();
                matriz.set(valor, i, j);
            }
        }

        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                lista.add(matriz.get(i, j));
            }
        }

        Collections.sort(lista);

        int posicao = 0;
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matriz.set(lista.get(posicao), i, j);
                posicao++;
            }
        }

        System.out.println();
        System.out.println("Matriz ordenada:");
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print(matriz.get(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Linhas:");
        for (int i = 0; i < ordem; i++) {
            System.out.println("Linha " + i + ": " + matriz.getLinha(i));
        }

        System.out.println();
        System.out.println("Colunas:");
        for (int j = 0; j < ordem; j++) {
            System.out.println("Coluna " + j + ": " + matriz.getColuna(j));
        }

        System.out.println();
        System.out.println("Diagonal principal:");
        System.out.println(matriz.getDiagonalPrincipal());

        teclado.close();
    }
}