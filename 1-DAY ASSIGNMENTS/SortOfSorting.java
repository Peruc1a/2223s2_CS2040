//Davin Chua A0234351N
import java.util.*;
import java.io.*;

public class SortOfSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int numNames = Integer.parseInt(br.readLine());
        while (numNames != 0) {
            List<String> lstNames = new ArrayList<String>();
            for (int i = 0; i < numNames; i++) {
                lstNames.add(br.readLine());
            }
            Collections.sort(lstNames, new sortByFirstTwo());
            for (int i = 0; i < numNames; i++) {
                pr.println(lstNames.get(i));;
            }
            numNames = Integer.parseInt(br.readLine());
            if (numNames != 0) {
                pr.println();
            }
            pr.flush();
        }
    }
}

class sortByFirstTwo implements Comparator<String> {
    public int compare(String a, String b) {
        return a.substring(0,2).compareTo(b.substring(0,2));
    }
}
