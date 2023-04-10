import java.util.*;

public class MillionaireMadness {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int row = k.getInt();
        int col = k.getInt();
        int[][] weight = new int[row][col];
        int[][] idx = new int[row][col];
        int t = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                weight[i][j] = k.getInt();
                idx[i][j] = t;
                t++;
            }
        }
        ArrayList<ArrayList<IntegerPair>> adjList = new ArrayList<ArrayList<IntegerPair>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ArrayList<IntegerPair> arr = new ArrayList<IntegerPair>();
                if (i > 0) arr.add(new IntegerPair(idx[i-1][j], weight[i-1][j]-weight[i][j])); //top
                if (i < row-1) arr.add(new IntegerPair(idx[i+1][j], weight[i+1][j]-weight[i][j]));//bottom
                if (j > 0) arr.add(new IntegerPair(idx[i][j-1], weight[i][j-1]-weight[i][j]));//left
                if (j < col-1) arr.add(new IntegerPair(idx[i][j+1], weight[i][j+1]-weight[i][j])); //right
                adjList.add(arr);
            }
        }
        int res = 0;
        boolean[] done = new boolean[row*col];
        PriorityQueue<IntegerPair> pq = new PriorityQueue<IntegerPair>();
        pq.add(new IntegerPair(0, 0));
        while (!pq.isEmpty()) {
            IntegerPair curr = pq.poll(); //get current vertex to BFS from
            res = curr.w;
            Queue<Integer> q = new LinkedList<Integer>();
            done[curr.v] = true;
            q.add(curr.v);

            while (!q.isEmpty()) {
                int currIdx = q.poll(); //index of current vertex
                if (currIdx == idx[row-1][col-1]) break; //endpoint has been reached

                for (IntegerPair searchCurr: adjList.get(currIdx)) {
                    if (!done[searchCurr.v]) {
                        if (!(res >= searchCurr.w)) {
                            pq.add(searchCurr);
                            continue;
                        }
                        done[searchCurr.v] = true;
                        q.add(searchCurr.v);
                    }
                }
            }
            if (done[row*col-1]) break;
        }
        System.out.println(res);
    }
}
