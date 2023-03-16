//DavinChua A0234351N
import java.util.TreeSet;

public class KattisQuest {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        TreeSet<Quest> set = new TreeSet<>();
        int cmds = k.getInt();
        for (int i = 0; i < cmds; i++) {
            String cmd = k.getWord();
            if (cmd.equals("add")) {
                set.add(new Quest(k.getInt(), k.getInt(), i+1));
            }
            else {
                int x = k.getInt();
                long reward = 0;
                while (true) {
                    Quest q = set.floor(new Quest(x, 100001, 0));
                    if (q == null) break;
                    x -= q.energy;
                    reward += q.gold;
                    set.remove(q);
                }
                k.println(reward);
            }
        }
        k.flush();
    }
}

class Quest implements Comparable<Quest> {
    int energy;
    int gold;
    int temp;
    public Quest (int e, int g, int t) {
        energy = e;
        gold = g;
        temp = t;
    }
    public int compareTo (Quest q) {
        if (energy == q.energy) {
            if (gold == q.gold) {
                return Integer.compare(temp, q.temp);
            }
            return Integer.compare(gold, q.gold);
        }
        return Integer.compare(energy, q.energy);
    }
}
