//Davin Chua A0234351N
import java.util.*;

public class FerryLoading {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int cases = k.getInt();
        for (int i = 0; i < cases; i++) {
            int ferryLen = k.getInt()*100;
            int cars = k.getInt();
            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();
            for (int j = 0; j < cars; j++) {
                int carLen = k.getInt();
                String side = k.getWord();
                if (side.equals("left")) left.add(carLen);
                else right.add(carLen);
            }
            int leftTrips = parseQueue(ferryLen, left);
            int rightTrips = parseQueue(ferryLen, right);
            if (leftTrips > rightTrips) k.println(leftTrips*2-1);
            else k.println(rightTrips*2);
        }
        k.flush();
    }

    public static int parseQueue(int ferryLength, Queue<Integer> q) {
        int trips = 1;
        int length = ferryLength;
        if (q.size() == 0) return 0;
        while(q.size() > 0) {
            if (length >= q.peek()) length -= q.remove();
            else {
                length = ferryLength;
                trips++;
            }
        }
        return trips;
    }
}
