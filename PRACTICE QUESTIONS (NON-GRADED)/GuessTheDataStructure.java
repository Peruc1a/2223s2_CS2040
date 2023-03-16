import java.io.*;
import java.util.*;

public class GuessTheDataStructure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        while ((st = br.readLine()) != null) {
            int cases = Integer.parseInt(st);
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> s = new Stack<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            boolean[] arr = new boolean[3];
            Arrays.fill(arr, true);
            int size = 0;
            for (int i = 0; i < cases; i++) {
                String[] temp = br.readLine().split(" ");
                int cmd = Integer.parseInt(temp[0]);
                if (cmd == 1) {
                    int ele = Integer.parseInt(temp[1]);
                    q.add(ele);
                    s.add(ele);
                    pq.add(ele);
                    size++;
                }
                else {
                    if (size == 0) {
                        Arrays.fill(arr, false);
                        continue;
                    }
                    int value = Integer.parseInt(temp[1]);
                    if (arr[0] && q.poll() != value) arr[0] = false;
                    if (arr[1] && s.pop() != value) arr[1] = false;
                    if (arr[2] && pq.poll() != value) arr[2] = false;
                    size--;
                }
            }
            int counter = 0;
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[j]) {
                    counter++;
                    idx = j;
                }
            }
            if (counter > 1) System.out.println("not sure");
            else if (counter == 1) {
                if (idx == 0) System.out.println("queue");
                else if (idx == 1) System.out.println("stack");
                else System.out.println("priority queue");
            }
            else System.out.println("impossible");
        }
    }
}
