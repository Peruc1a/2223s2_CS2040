//Davin Chua A0234351N
public class Islands {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int row = k.getInt();
        int col = k.getInt();
        Coord[][] map = new Coord[row][col];
        int counter = 0;
        for (int i = 0; i < row; i++) {
            String[] temp = k.getWord().split("");
            for (int j = 0; j < col; j++) {
                map[i][j] = new Coord(i, j, temp[j]);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Coord cur = map[i][j];
                if (cur.checked || cur.key.equals("C")) continue;
                if (cur.key.equals("L")) {
                    search(cur, map, row, col);
                    counter++;
                }
                else if (cur.key.equals("W")) cur.checked = true;
            }
        }
        System.out.println(counter);
    }

    public static void search(Coord c, Coord[][] m, int row, int col) {
        c.checked = true;
        Coord cur;
        if (c.x > 0) {//search left
            cur = m[c.x-1][c.y];
            if (!cur.checked && !cur.key.equals("W")) search(cur, m, row ,col);
        }
        if (c.x < row-1) {//search right
            cur = m[c.x+1][c.y];
            if (!cur.checked && !cur.key.equals("W")) search(cur, m, row ,col);
        }
        if (c.y > 0) {//search up
            cur = m[c.x][c.y-1];
            if (!cur.checked && !cur.key.equals("W")) search(cur, m, row ,col);
        }
        if (c.y < col-1) {//search down
            cur = m[c.x][c.y+1];
            if (!cur.checked && !cur.key.equals("W")) search(cur, m, row ,col);
        }
    }
}

class Coord {
    String key;
    int x, y;
    boolean checked;

    public Coord(int a, int b, String s) {
        x = a;
        y = b;
        key = s;
        checked = false;
    }
}
