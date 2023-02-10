import java.util.*;

public class Tarifa {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int totalData = inp.nextInt();
        int months = inp.nextInt();
        totalData = totalData*(months+1);
        for (int i = 0; i < months; i++) {
            totalData = totalData - inp.nextInt();
        }
        System.out.println(totalData);
        inp.close();
    }
}
