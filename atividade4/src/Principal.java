import java.util.ArrayList;
import java.util.List;

public class Principal {

    private static List<Integer> tabuada = new ArrayList<Integer>();

    public static List<Integer> tabuada(int n) {
        for (int i = 0; i < 10; i++) {
            int num = (i+1) * n;
            tabuada.add(num);
        }
        return tabuada;
    }

    public static void main(String[] args) {
        System.out.println("Tabuada do 2: " + tabuada(2));

    }
}
