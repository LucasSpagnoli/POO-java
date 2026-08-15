import java.util.Scanner;

public class ex2 {
    public static void main() {
        int[] idade = new int[5];
        String[] nomes = new String[5];
        Scanner in = new Scanner(System.in);
        System.out.println("Digite 5 nomes e 5 idades");
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o " + (i + 1) + "° nome");
            nomes[i] = in.nextLine();
            System.out.println("Digite a " + (i + 1) + "° idade");
            idade[i] = Integer.parseInt(in.nextLine());
        }
        int idadeTemp;
        String nomeTemp;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (idade[j] < idade[j + 1]) {
                    idadeTemp = idade[j];
                    idade[j] = idade[j + 1];
                    idade[j + 1] = idadeTemp;

                    nomeTemp = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = nomeTemp;
                }
            }
        }

        System.out.println("Lista:");
        for (int i = 0; i < 5; i++) {
            System.out.println(nomes[i] + " - " + idade[i]);
        }

    }
}
