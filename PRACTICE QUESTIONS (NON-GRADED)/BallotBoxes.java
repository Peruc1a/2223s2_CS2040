//Davin Chua A0234351N
import java.util.*;

public class BallotBoxes {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        while (true) {
            int c = k.getInt();
            int b = k.getInt();
            if (c == -1) break;
            int[] arr = new int[c];
            int high = 0;
            for (int i = 0; i < c; i++) {
                int temp = k.getInt();
                arr[i] = temp;
                high = high > temp ? high : temp;
            }
            int low = 1;
            while (low < high) {
                int mid = (low+high) / 2;
                int count = 0;
                for (int j = 0; j < c; j++) count += (arr[j]+mid-1) / mid;
                if (count > b) low = mid+1;
                else high = mid;
            }
            k.println(low);
        }
        k.flush();
    }
}



