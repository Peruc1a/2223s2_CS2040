//Davin Chua A0234351N
import java.util.*;
import java.io.*;

public class Akcija {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numBooks = Integer.parseInt(br.readLine());
        ArrayList<Integer> bookPrices = new ArrayList<Integer>();
        for (int i = 0; i < numBooks; i++) {
            bookPrices.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bookPrices, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < numBooks; i++) {
            if (i % 3 == 2) {
                continue;
            }
            sum += bookPrices.get(i);
        }
        System.out.println(sum);
    }
}
