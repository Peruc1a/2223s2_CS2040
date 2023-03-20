//Davin Chua A0234351N

public class AlmostUnionFind {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        StringBuilder sb = new StringBuilder();
        while (k.hasMoreTokens()) {
            int arrSize = k.getInt()+1, cmds = k.getInt();
            AlmostUFDS a = new AlmostUFDS(arrSize);
            for (int i = 0; i < cmds; i++) {
                int cmd = k.getInt();
                if (cmd == 1) a.Union(k.getInt(), k.getInt());
                else if (cmd == 2) a.Move(k.getInt(), k.getInt());
                else {
                    int index = k.getInt();
                    sb.append(a.getSize(index));
                    sb.append(" ");
                    sb.append(a.getSum(index));
                    sb.append("\n");
                }
            }
        }
        k.print(sb);
        k.flush();
    }
}

class AlmostUFDS {
    int[] unionArr, moveArr, size, rank;
    long[] sum;
    
    public AlmostUFDS(int N) {
        unionArr = new int[N];
        moveArr = new int[N];
        size = new int[N];
        rank = new int[N];
        sum = new long[N];
        for (int i = 0; i < N; i++) {
            unionArr[i] = i;
            moveArr[i] = i;
            sum[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findSet(int i) {
        if (i == unionArr[i]) return i;
        return unionArr[i] = findSet(unionArr[i]);
    }

    public boolean isSameSet(int i, int j) { return findSet(moveArr[i]) == findSet(moveArr[j]);}

    public void Union(int i, int j) {
        int i_root = findSet(moveArr[i]), j_root = findSet(moveArr[j]);
        if (i_root != j_root) {
            if (rank[i_root] > rank[j_root]) {
                unionArr[j_root] = i_root;
                size[i_root] += size[j_root];
                sum[i_root] += sum[j_root];
            }
            else {
                unionArr[i_root] = j_root;
                size[j_root] += size[i_root];
                sum[j_root] += sum[i_root];
                if (rank[i_root] == rank[j_root]) rank[j_root]++;
            }
        }
    }

    public void Move(int i, int j) {
        int i_root = findSet(moveArr[i]), j_root = findSet(moveArr[j]);
        if (i_root != j_root) {
            moveArr[i] = j_root;
            sum[i_root] -= i;
            sum[j_root] += i;
            size[i_root] -= 1;
            size[j_root] += 1;
            if (rank[j_root] == 0) rank[j_root]++;
        }
    }

    public int getSize(int i) { return size[findSet(moveArr[i])];}
    public long getSum(int i) { return sum[findSet(moveArr[i])];}
}