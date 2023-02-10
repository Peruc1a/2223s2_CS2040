import java.util.*;

public class DetailedDiff {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int runs = inp.nextInt();
        for (int i = 0; i < runs; i++) {
            String str1, str2, res;
            res = "";
            str1 = inp.next();
            str2 = inp.next();
            System.out.println(str1);
            System.out.println(str2);
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == str2.charAt(j)) {
                    res += ".";
                }
                else {
                    res += "*";
                }
            }
            System.out.println(res);
            inp.close();
        }
    }
}
