import java.util.Scanner;

public class ex1 {
    public static void main() {
        int[] nums = new int[5];
        Scanner in = new Scanner(System.in);
        System.out.println("Média de 5 números");
        float media=0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Digite o " + (i+1) + "° número");
            nums[i] = Integer.parseInt(in.nextLine());
            media = media+nums[i];
        }
        System.out.println("Média: " + media/5);
    }
}
