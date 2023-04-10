import java.util.*;

public class DFS {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adjL) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean[] done = new boolean[adjL.size()];
        for (int i = 0; i < adjL.size(); i++) {
            if (!done[i]) DFStopo(i, done, adjL, res);
        }
        return res;
    }

    public static void DFStopo(int i, boolean[] done, ArrayList<ArrayList<Integer>> adjL, ArrayList<Integer> res) {
        done[i] = true;
        ArrayList<Integer> tests = adjL.get(i);
        for (int j = 0; j < tests.size(); j++) {
            int cur = tests.get(j);
            if (!done[cur]) DFStopo(cur, done, adjL, res);
        }
        res.add(i);
    }

    public static void DFSrec(int i, boolean[] done, ArrayList<ArrayList<Integer>> adjL) {
        done[i] = true;
        ArrayList<Integer> tests = adjL.get(i);
        for (int j = 0; j < tests.size(); j++) {
            int cur = tests.get(j);
            if (!done[cur]) DFSrec(cur, done, adjL);
        }
    }

    public static int topoEval(ArrayList<ArrayList<Integer>> adjL, ArrayList<Integer> topo) {
        boolean[] done = new boolean[topo.size()];
        int res = 0;
        for (int i = topo.size()-1; i > -1; i--) {
            int cur = topo.get(i);
            if (!done[cur]) {
                DFSrec(cur, done, adjL);
                res++;
            }
        }
        return res;
    }
}
