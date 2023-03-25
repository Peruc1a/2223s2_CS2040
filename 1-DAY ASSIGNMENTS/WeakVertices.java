//Davin Chua A0234351N

public class WeakVertices {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int v = k.getInt();
        while (v > 0) {
            StringBuilder sb = new StringBuilder();
            int[][] AM = new int[v][v];
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    AM[i][j] = k.getInt();
                }
            }
            for (int a = 0; a < v; a++) {
                boolean flag = false;
                for (int b = 0; b < v; b++) {
                    if (b == a) continue;
                    for (int c = 0; c < v; c++) {
                        if (c == b || c == a) continue;
                        else if (AM[a][b] == 1 && AM[b][c] == 1 && AM[a][c] == 1) flag = true;
                    }
                }
                if (!flag) sb.append(a + " ");
            }
            k.println(sb);
            v = k.getInt();
        }
        k.flush();
    }
}
