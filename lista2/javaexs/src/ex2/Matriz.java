package ex2;

import java.util.ArrayList;
import java.util.List;

public class Matriz<T> {

    private int linhas;
    private int colunas;
    private Object[][] elementos;

    public Matriz(int n, int m) {
        this.linhas = n;
        this.colunas = m;
        this.elementos = new Object[n][m];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public boolean set(T objeto, int i, int j) {
        if (i < 0 || i >= linhas || j < 0 || j >= colunas) {
            return false;
        }
        elementos[i][j] = objeto;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int j) {
        if (i < 0 || i >= linhas || j < 0 || j >= colunas) {
            return null;
        }
        return (T) elementos[i][j];
    }

    public List<T> getLinha(int linha) {
        List<T> lista = new ArrayList<T>();

        if (linha < 0 || linha >= linhas) {
            return lista;
        }

        for (int j = 0; j < colunas; j++) {
            lista.add(get(linha, j));
        }
        return lista;
    }

    public List<T> getColuna(int coluna) {
        List<T> lista = new ArrayList<T>();

        if (coluna < 0 || coluna >= colunas) {
            return lista;
        }

        for (int i = 0; i < linhas; i++) {
            lista.add(get(i, coluna));
        }
        return lista;
    }

    public List<T> getDiagonalPrincipal() {
        List<T> lista = new ArrayList<T>();

        int tamanho = linhas;
        if (colunas < linhas) {
            tamanho = colunas;
        }

        for (int i = 0; i < tamanho; i++) {
            lista.add(get(i, i));
        }
        return lista;
    }
}