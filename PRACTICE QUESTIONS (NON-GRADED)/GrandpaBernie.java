//Davin Chua A0234351N
import java.util.*;

public class GrandpaBernie {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        HashMap<String, Country> map = new HashMap<>();
        int travels = k.getInt();
        for (int i = 0;  i < travels; i++) {
            String loc = k.getWord();
            int year = k.getInt();
            if (map.containsKey(loc)) map.get(loc).addEntry(year);
            else map.put(loc, new Country(year));
        }
        int queries = k.getInt();
        for (int j = 0; j < queries; j++) {
            String loc = k.getWord();
            int time = k.getInt();
            k.println(map.get(loc).getEntry(time));
        }
        k.flush();
    }
}

class Country {
    boolean sorted = false;
    ArrayList<Integer> lst = new ArrayList<>();
    public Country(int year) {
        lst.add(year);
    }

    public void addEntry(int year) {
        lst.add(year);
    }

    public Integer getEntry(int index) {
        if (!sorted) {
            Collections.sort(lst);
            sorted = true;
        }
        return lst.get(index-1);
    }
}