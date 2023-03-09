//Davin Chua A0234351N
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class AssigningWorkstations {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int rs = k.getInt();
        int lockTime = k.getInt();
        int counter = 0;
        ArrayList<Researcher> arr = new ArrayList<Researcher>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < rs; i++) {
            arr.add(new Researcher(k.getInt(), k.getInt()));
        }
        Collections.sort(arr);
        for (Researcher r : arr) {
            int a = r.getArrive();
            while (pq.size() > 0) {
                if (a < pq.peek()) break;
                else {
                    int b = pq.poll();
                    if (a - b <= lockTime) {
                        counter++;
                        break;
                    }
                }
            }
            pq.add(r.leaveTime());
        }
        System.out.println(counter);
    }
}

class Researcher implements Comparable<Researcher> {
    int arrive;
    int usage;
    public Researcher(Integer a, Integer s) {
        arrive = a;
        usage = s;
    }
    
    public int compareTo(Researcher a) {return Integer.compare(arrive, a.arrive);}
    public int leaveTime() { return arrive+usage;}
    public int getArrive() { return arrive;}
}