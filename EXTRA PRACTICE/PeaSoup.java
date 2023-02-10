import java.util.*;

public class PeaSoup {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int rests = Integer.parseInt(inp.nextLine());
        for (int i = 0; i < rests; i++) {
            Set<String> checker = new HashSet<String>();
            int menuItems = Integer.parseInt(inp.nextLine());
            String resName = inp.nextLine();
            for (int j = 0; j < menuItems; j++) {
                String dish = inp.nextLine();
                if (dish.equals("pea soup") || dish.equals("pancakes")) {
                    checker.add(dish);
                }
            }
            inp.close();
            if (checker.size() == 2) {
                System.out.println(resName);
                return;
            }
        }
        System.out.println("Anywhere is fine I guess");
    }
}