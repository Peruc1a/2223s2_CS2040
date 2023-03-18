//Davin Chua A0234351N

public class BallotBoxes {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        while (true) {
            int cities = k.getInt();
            int boxes = k.getInt();
            if (cities == -1 && boxes == -1) break;
            else if (cities == 1) {
                k.println((int) Math.ceil(k.getDouble() / boxes));
                continue;
            }
            int[] arr = new int[500000];
            int low = 1, high = 0, mid;
            for (int i = 0; i < cities; i++) {
                arr[i] = k.getInt();
                if (arr[i] > high) high = arr[i];
            }
            while (low < high) {
                mid = (high + low) / 2;
                int counter = 0;
                for (int j = 0; j < cities; j++) {
                    counter += (int) Math.ceil((double) arr[j] / mid);
                }
                if (counter > boxes) low = mid+1;
                else high = mid;
            }
            k.println(low);
        }
        k.flush();
    }
    
}



