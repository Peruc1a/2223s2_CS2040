import java.io.*;

public class ShatteredCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        int pcs = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < pcs; i++) {
            String[] temp = br.readLine().split(" ");
            sum += Integer.parseInt(temp[0])*Integer.parseInt(temp[1]);
        }
        System.out.println((int) sum/w);
    }
}
