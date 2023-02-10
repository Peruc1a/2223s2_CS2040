import java.util.*;
import java.io.*;

public class Testing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(";");
        int sum = 0;
        for (String i : word) {
            if (i.contains("-")) {
                String[] a = i.split("-");
                sum += Integer.parseInt(a[1]) - Integer.parseInt(a[0]) + 1;
                continue;
            }
            sum++;
        }
        System.out.println(sum);
    }
}