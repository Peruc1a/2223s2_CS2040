//Davin Chua A0234351N
import java.util.*;

public class Dominos {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int cases = k.getInt();
        for (int i = 0; i < cases; i++) {
            int dominos = k.getInt();
            int lines = k.getInt();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < dominos; j++) adjList.add(new ArrayList<Integer>());
            for (int j = 0; j < lines; j++) adjList.get(k.getInt()-1).add(k.getInt()-1);
            ArrayList<Integer> topoList = DFS.topoSort(adjList);
            k.println(DFS.topoEval(adjList, topoList)); 
        }   
        k.flush();
    }
}


