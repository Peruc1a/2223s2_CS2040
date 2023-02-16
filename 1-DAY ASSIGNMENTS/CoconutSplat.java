//Davin Chua A0234351N
import java.util.*;
import java.io.*;

class Hand {
    public int playerNo;
    public int lives;
    boolean flag;
    public Hand (int a, int lives) {
        this.playerNo = a;
        this.lives = lives;
    }
    public void loseLife() {
        this.lives--;
    }
}
public class CoconutSplat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        int s = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);
        ArrayList<Hand> q = new ArrayList<Hand>();
        for (int i = 0; i < n; i++) {
            q.add(new Hand(i+1, 3));
        }

        int index = 0;
        while (q.size() > 1) {
            index = (index + s -1) % q.size();
            Hand a = q.get(index);
            a.loseLife();
            if (a.lives == 2) {
                q.add(index, new Hand(a.playerNo, 2));
            }
            else if (a.lives == 1) {
                index++;
            }
            else if (a.lives == 0) {
                q.remove(index);
            }
        }
        System.out.println(q.get(0).playerNo);
    }
}
