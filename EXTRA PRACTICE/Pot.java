import java.util.*;

public class Pot {
    public static void main(String[] args) {
        int sum = 0;
        Scanner inp = new Scanner(System.in);
        int runs = inp.nextInt();
        while (runs > 0) {
            int a = inp.nextInt();
            sum += Math.pow(a/10, a%10);
            runs--;
        }
        System.out.println(sum);
        inp.close();
    }
}
