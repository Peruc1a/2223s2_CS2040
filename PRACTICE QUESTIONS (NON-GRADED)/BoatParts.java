import java.util.HashSet;

//Davin Chua A0234351N

public class BoatParts {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int numParts = k.getInt();
        int days = k.getInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < days; i++) {
            String part = k.getWord();
            set.add(part);
            if (set.size() == numParts) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println("paradox avoided");
    }
}
