//Davin Chua A0234351N
import java.io.*;
import java.util.*;

public class Conformity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int frosh = Integer.parseInt(br.readLine());
        int highest = 1;
        for (int i = 0; i < frosh; i++) {
            String[] arr = br.readLine().split(" ");
            Arrays.sort(arr);
            String str = Arrays.toString(arr);
            if (map.containsKey(str)) {
                int occ = map.get(str);
                if (occ == highest) highest++;
                map.put(str, occ+1);
            }
            else map.put(str,1);
        }
        if (highest == 1) System.out.println(frosh);
        else {
            Collection<Integer> lst = map.values();
            System.out.println(Collections.frequency(lst, highest)*highest);
        }
    }
}
