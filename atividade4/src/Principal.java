import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private static List<Integer> tabuada = new ArrayList<Integer>();

    public static List<Integer> tabuada(int n) {
        for (int i = 0; i < 10; i++) {
            int num = (i + 1) * n;
            tabuada.add(num);
        }
        return tabuada;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o número da tabuada desejada");
        int tab = in.nextInt();
        System.out.println("Tabuada do " + tab + ": " + tabuada(tab));

    }
}
