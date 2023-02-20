import java.util.ArrayList;
import java.util.Collections;

//Davin Chua A234351N


public class PasswordHacking {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        ArrayList<Password> arr = new ArrayList<>();
        int tries = k.getInt();
        for (int i = 0; i < tries; i++) {
            String n = k.getWord();
            double prob = k.getDouble();
            arr.add(new Password(n, prob));
        }
        Collections.sort(arr);
        double res = 0;
        for (int i = 1; i < tries+1; i++) {
            res += arr.get(i-1).prob*i;
        }
        System.out.println(res);
    }
}

class Password implements Comparable<Password>{
    String name;
    double prob;
    public Password(String n, double p) {
        this.name = n;
        this.prob = p;
    }

    public int compareTo(Password a) {
        return Double.compare(a.prob, this.prob); 
    }
}