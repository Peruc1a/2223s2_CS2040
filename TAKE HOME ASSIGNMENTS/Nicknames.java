//Davin Chua A0234351N

public class Nicknames {
    public static void main(String[] args) {
        BSTring nameTree = new BSTring();
        Kattio k = new Kattio(System.in,System.out);
        int numNames = k.getInt();
        for (int i = 0; i < numNames; i++) {
            nameTree.insert(k.getWord());
        }
        int numNicks = k.getInt();
        for (int j = 0; j < numNicks; j++) {
            String nick = k.getWord();
            StringVertex first = nameTree.search(nick);
            if (first == null) k.println(0);
            else k.println(1 + nameTree.searchLeft(first.left, nick) + nameTree.searchRight(first.right, nick));
        }
        k.flush();
    }
}

class BSTring {
    public StringVertex root;

    public BSTring() { root = null;}

    public int height(StringVertex T) {return T == null ? -1 : T.height;}

    public void updateHeight(StringVertex T) {
        T.height = Math.max(height(T.left), height(T.right)) +1;
    }

    public int size(StringVertex T) {return T == null ? 0 : T.size;}

    public void updateSize(StringVertex T) {
        T.size = size(T.left) + size(T.right) + 1;
    }

    public int balanceFactor(StringVertex T) { return T == null ? 0 : height(T.left) - height(T.right);}

    public StringVertex search(String v) { return search(root, v);}

    public StringVertex search(StringVertex T, String v) {
        if (T == null) return T;
        if (T.key.indexOf(v) == 0) return T;
        else if (v.compareTo(T.key) > 0) return search(T.right, v);
        else return search(T.left, v);
    }

    public int searchLeft(StringVertex T, String v) {
        if (T == null) return 0;
        if (T.key.indexOf(v) == 0) return searchLeft(T.left, v) + size(T.right) + 1;
        else return searchLeft(T.right, v);
    }

    public int searchRight(StringVertex T, String v) {
        if (T == null) return 0;
        if (T.key.indexOf(v) == 0) return searchRight(T.right, v) + size(T.left) + 1;
        else return searchRight(T.left, v);
    }

    public void insert(String v) { root = insert(root, v);}

    public StringVertex insert(StringVertex T, String v) {
        if (T == null) return new StringVertex(v);
        if (v.compareTo(T.key) > 0) {
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        else {
            T.left = insert(T.left, v);
            T.left.parent = T;
        }
        updateHeight(T);
        updateSize(T);
        return rebalance(T);
    }

    public StringVertex rotateLeft(StringVertex T) {
        StringVertex R = T.right;
        R.parent = T.parent;
        T.parent = R;
        T.right = R.left;
        if (R.left != null) R.left.parent = T;
        R.left = T;
        updateHeight(T);
        updateSize(T);
        updateHeight(R);
        updateSize(R);
        return R;
    }

    public StringVertex rotateRight(StringVertex T) {
        StringVertex L = T.left;
        L.parent = T.parent;
        T.parent = L;
        T.left = L.right;
        if (L.right != null) L.right.parent = T;
        L.right = T;
        updateHeight(T);
        updateSize(T);
        updateHeight(L);
        updateSize(L);
        return L;
    }

    public StringVertex rebalance(StringVertex T) {
        int bf = balanceFactor(T);
        if (bf == 2) {
            if (balanceFactor(T.left) == -1) T.left = rotateLeft(T.left);
            T = rotateRight(T);
        }
        else if (bf == -2) {
            if (balanceFactor(T.right) == 1) T.right = rotateRight(T.right);
            T = rotateLeft(T);
        }
        return T;
    }
}

class StringVertex {
    String key;
    StringVertex parent, left, right;
    int height, size;

    StringVertex(String v) {
        key = v;
        parent = left = right = null;
        height = 0;
        size = 1;
    }
}
