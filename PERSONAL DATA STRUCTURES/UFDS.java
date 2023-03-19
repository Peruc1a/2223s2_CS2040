public class UFDS {
    public int[] p;
    public int[] rank;

    public UFDS(int N) {
        p = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    public int findSet(int i) {
        if (p[i] == i) return i;
        else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }

    public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j);}

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) p[y] = x;
            else {
                p[x] = y;
                if (rank[x] == rank[y]) rank[y] = y+1;
            }
        }
    }
}
