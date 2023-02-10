import java.util.*;

public class NumberFun {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int runs = inp.nextInt();
        for (int i = 0; i < runs; i++) {
            String res = "impossible";
            int a = inp.nextInt();
            int b = inp.nextInt();
            int c = inp.nextInt();
            //Addition & Multiplication
            if (a+b == c || a*b == c) {
                res = "possible";
            }
            //Division
            else if (b*c == a || a*c == b) {
                res = "possible";
            }
            //Subtraction
            else if (c+b == a || c+a == b) {
                res = "possible";
            }
            System.out.println(res);
        }
        inp.close();
    }
}
