//Davin Chua A0234351N
import java.util.*;

public class ClassyProblem {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int cases = k.getInt();
        for (int i = 0; i < cases; i++) {
            ArrayList<Person> arr = new ArrayList<>();
            int people = k.getInt();
            for (int j = 0; j < people; j++) {
                String name = k.getWord().replace(":", "");
                String[] ranks = k.getWord().split("-");
                String extra = k.getWord();
                arr.add(new Person(name, ranks));
            }
            Collections.sort(arr, new classySort());
            for (int j = 0; j < people; j++) {
                k.println(arr.get(j).name);
            }
            k.println("==============================");
        }
        k.flush();
    }
}

class Person {
    String name;
    ArrayList<Integer> rank = new ArrayList<>();
    public Person(String s, String[] val) {
        name = s;
        for (int i = val.length-1; i >= 0; i--) {
            if (val[i].equals("upper")) rank.add(3);
            else if (val[i].equals("middle")) rank.add(2);
            else rank.add(1);
        }
        for (int i = 0; i < 10; i++) {
            rank.add(2);
        }
    }
}

class classySort implements Comparator<Person> {
    public int compare(Person a, Person b) {
        ArrayList<Integer> aRank = a.rank;
        ArrayList<Integer> bRank = b.rank;
        for (int i = 0; i < 10; i++) {
            if (aRank.get(i) == bRank.get(i)) continue;
            else return bRank.get(i).compareTo(aRank.get(i));
        }
        return a.name.compareTo(b.name);
    }
}

