/*Davin Chua A0234351N */

import java.util.*;
import java.io.*;
//Class to represent runners and their respective times for leg 1 and 2
class Runner {
    double leg1, leg2;
    String name;

    public Runner (String name, double leg1, double leg2) {
        this.name = name;
        this.leg1 = leg1;
        this.leg2 = leg2;
    }
}
//Sorts by running time for leg2
class sortByLeg2 implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        return Double.compare(a.leg2, b.leg2);
    }
}
public class BestRelay {
    public static void main(String[] args) throws IOException {
        //Reading input and finding name, leg1, and leg2 of each runner
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Runner> runners = new ArrayList<Runner>();
        int num = Integer.parseInt(inp.readLine());
        for (int i = 0; i < num; i++) {
            String[] details = inp.readLine().split(" ");
            runners.add(new Runner(details[0], Double.parseDouble(details[1]), Double.parseDouble(details[2])));
        }
        inp.close();
        
        //Finding fastest combination of runners
        Collections.sort(runners, new sortByLeg2()); //sorts the arraylist by fastest 2nd leg runners
        double hold = runners.get(0).leg1 + runners.get(1).leg2 + runners.get(2).leg2 + runners.get(3).leg2; //time taken for first 4 runners
        int best = 0;
        for (int i = 1; i < runners.size(); i++) {
            double time = runners.get(i).leg1;
            for (int j = 0; j < 3; j++) {
                time = time + (i == j ? runners.get(3).leg2 : runners.get(j).leg2);
            }
            if (time < hold) {
                hold = time;
                best = i;
            }
        }

        //Outputting fastest combination of numbers
        System.out.println(hold);
        System.out.println(runners.get(best).name);
        runners.remove(runners.get(best));
        int counter = 0;
        while (counter < 3) {
            System.out.println(runners.get(counter).name);
            counter++;
        }
    }
}
