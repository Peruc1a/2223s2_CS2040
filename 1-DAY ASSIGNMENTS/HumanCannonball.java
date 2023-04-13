//Davin Chua A0234351N
import java.lang.Math;
import java.util.*;

public class HumanCannonball {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        cannonCoord start = new cannonCoord(k.getDouble(), k.getDouble());
        cannonCoord end = new cannonCoord(k.getDouble(), k.getDouble());
        int cNum = k.getInt();

        cannonCoord[] cannons = new cannonCoord[cNum];
        for (int i = 0; i < cNum; i++) cannons[i] = new cannonCoord(k.getDouble(), k.getDouble());

        int s = 0, e = cNum+1;
        double[][] mat = new double[cNum+2][cNum+2];
        mat[s][e] = mat[e][s] = Math.hypot(start.y-end.y, start.x-end.x) / 5;

        for (int i = 0; i < cNum; i++) {
            cannonCoord curr1 = cannons[i];
            mat[s][i+1] = Math.hypot(start.y-curr1.y, start.x-curr1.x) / 5;
            mat[i+1][e] = Math.abs(50 - Math.hypot(curr1.y-end.y, curr1.x-end.x)) / 5 + 2;

            for (int j = i+1; j < cNum; j++) {
                cannonCoord curr2 = cannons[j];
                double disp = Math.hypot(curr1.y-curr2.y, curr1.x-curr2.x);
                double run = disp / 5;
                double launch = Math.abs(disp - 50) / 5 + 2;
                mat[i+1][j+1] = mat[j+1][i+1] = Math.min(run, launch);
            }
        }

        double[] d = new double[cNum+2];
        for (int i = 1; i < cNum+2; i++) d[i] = 10000000000D;
        
        PriorityQueue<Cannon> pq = new PriorityQueue<Cannon>();
        pq.add(new Cannon(0, d[0]));

        while (!pq.isEmpty()) {
            Cannon curr = pq.poll();
            if (curr.w == d[curr.i]) {
                for (int i = 0; i < d.length; i++) {
                    if (i != curr.i && d[i] > d[curr.i] + mat[curr.i][i]) {
                        d[i] = d[curr.i] + mat[curr.i][i];
                        pq.add(new Cannon(i, d[i]));
                    }
                }
            }
        }

        System.out.println(d[e]);
    }
}

class cannonCoord {
    double x;
    double y;

    public cannonCoord(double a, double b) {
        x = a;
        y = b;
    }
}

class Cannon implements Comparable<Cannon> {
    int i;
    double w;

    public Cannon(int a, double b) {
        i = a;
        w = b;
    }

    public int compareTo(Cannon o) { return Double.compare(w, o.w);}
}

