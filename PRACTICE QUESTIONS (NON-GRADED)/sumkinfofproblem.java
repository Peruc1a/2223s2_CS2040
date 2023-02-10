import java.io.*;

public class sumkinfofproblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sets = Integer.parseInt(br.readLine());
        for (int i = 0; i < sets; i++) {
            String[] temp = br.readLine().split(" ");
            double prob = Double.parseDouble(temp[1]);
            double case1 = prob/2 * (2*1+prob-1), case2 = prob/2 * (2*1 + (prob-1)*2), case3 = prob/2 * (2*2 + (prob-1)*2);
            System.out.println(i+1 + " " + (long) case1 + " " + (long) case2 + " " + (long) case3);
        }
    }
}
