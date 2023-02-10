import java.util.*;

public class TimeLoop {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println(i+1 + " Abracadabra");
        }
        inp.close();
    }
}
