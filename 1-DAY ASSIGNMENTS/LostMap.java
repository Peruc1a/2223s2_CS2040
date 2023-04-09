import java.util.*;

public class LostMap {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int villages = k.getInt();
        UFDS roads = new UFDS(villages+1);
        ArrayList<villagEdge> arr = new ArrayList<>();
        for (int i = 0; i < villages; i++) {
            for (int j = 0; j < villages; j++) {
                int l = k.getInt();
                if (i == j) continue;
                arr.add(new villagEdge(i+1, j+1, l));
            }
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            villagEdge temp = arr.get(i);
            if (roads.isSameSet(temp.v1, temp.v2)) continue;
            roads.unionSet(temp.v1, temp.v2);
            k.println(temp.v1 + " " + temp.v2);
        }
        k.flush();
    }

}

class villagEdge implements Comparable<villagEdge> {
    int v1;
    int v2;
    int weight;
    public villagEdge(int a, int b, int c) {
        v1 = a;
        v2 = b;
        weight = c;
    }

    public int compareTo(villagEdge a) { return weight - a.weight;}
}
