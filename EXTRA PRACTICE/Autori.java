import java.util.*;

public class Autori {
    public static void main(String[] args) {
        String a,out;
        char b;
        Scanner inp = new Scanner(System.in);

        a = inp.next();
        out = "";

        for (int i = 0; i < a.length(); i++) {
            b = a.charAt(i);
            if (b == a.toUpperCase().charAt(i) && b != '-') {
                out += b;
            }
        }
        System.out.println(out);
        inp.close();
    }
}