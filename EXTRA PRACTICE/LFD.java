import java.util.*;

public class LFD {
    public static void main(String[] args) {
        int hold,res;
        Scanner inp = new Scanner(System.in);
        int a = inp.nextInt();
        for (int i = 0; i < a; i++) {
            hold = 1;
            int b = inp.nextInt();
            for (int j = 1; j < b+1; j++) {
                res = hold*j;
                hold = res%10;
            }
            System.out.println(hold);
        }
        inp.close();
    }
}
