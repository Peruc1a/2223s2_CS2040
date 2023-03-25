class BST {
    public BSTVertex root;

    public BST() { root = null;}

    public int search(int v) {
        BSTVertex res = search(root, v);
        return res == null ? -1 : res.key;
    }

    public BSTVertex search(BSTVertex T, int v) {
        if (T == null) return null;
        else if (T.key == v) return T;
        else if (T.key < v) return search(T.right, v);
        else return search(T.left, v);
    }

    public int findMin() { return findMin(root);}

    public int findMin(BSTVertex T) {
        if (T.left == null) return T.key;
        return findMin(T.left);
    }

    public int findMax() { return findMax(root);} 

    public int findMax(BSTVertex T) {
        if (T.right == null) return T.key;
        return findMax(T.right);
    }

    public int successor(int v) {
        BSTVertex vPos = search(root, v);
        return vPos == null ? -1 : successor(vPos);
    }

    public int successor(BSTVertex T) {
        if (T.right != null) return findMin(T.right);
        else {
            BSTVertex par = T.parent;
            BSTVertex cur = T;
            while ((par != null) && (cur == par.right)) { //if parent is not root and current is its right child
                cur = par;
                par = cur.parent;
            }
            return par == null ? -1 : par.key;
        }
    }

    public int predecessor(int v) {
        BSTVertex vPos = search(root, v);
        return vPos == null ? -1 : predecessor(vPos);
    }

    public int predecessor(BSTVertex T) {
        if (T.left != null) return findMax(T.left);
        else {
            BSTVertex par = T.parent;
            BSTVertex cur = T;
            while ((par != null) && (cur == par.left)) {
                cur = par;
                par = cur.parent;
            }
            return par == null ? -1 : par.key;
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    public void inorder(BSTVertex T) {
        if (T == null) return;
        inorder(T.left);
        System.out.printf(" %d", T.key);
        inorder(T.right);
    }

    public void insert(int v) { root = insert(root, v);}

    public BSTVertex insert(BSTVertex T, int v) {
        if (T == null) return new BSTVertex(v); //insertion point is found
        if (T.key < v) {
            T.right = insert(T.right, v);
            T.right.parent = T;
        }
        else {
            T.left = insert(T.left, v);
            T.left.parent = T;
        }
        T.height = updateHeight(T);

        return rebalance(T);
    }

    public void delete(int v) { root = delete(root, v);}

    public BSTVertex delete(BSTVertex T, int v) {
        if (T == null) return T;
        if (T.key < v) T.right = delete(T.right, v);
        else if (T.key > v) T.left = delete(T.left, v);
        else {
            if (T.left == null && T.right == null) T = null;
            else if (T.left == null && T.right != null) {
                T.right.parent = T.parent;
                T = T.right;
            }
            else if (T.left != null && T.right == null) {
                T.left.parent = T.parent;
                T = T.left;
            }
            else {
                int successorV = successor(v);
                T.key = successorV;
                T.right = delete(T.right, successorV);
            }
        }
        if (T == null) return T;
        else {
            T.height = updateHeight(T);
            return rebalance(T); 
        }
    }
    public int height(BSTVertex T) { return T != null ? T.height : -1;}

    public int updateHeight(BSTVertex T) {
        int leftHeight = height(T.left);
        int rightHeight = height(T.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public int balanceFactor(BSTVertex T) {
        return height(T.left) - height(T.right);
    }

    public BSTVertex rotateLeft(BSTVertex T) {
        BSTVertex rightChild = T.right;
        rightChild.parent = T.parent;
        T.parent = rightChild;
        T.right = rightChild.left;
        if (rightChild.left != null) rightChild.left.parent = T;
        rightChild.left = T;
        updateHeight(T);
        updateHeight(rightChild);
        return rightChild;
    }

    public BSTVertex rotateRight(BSTVertex T) {
        BSTVertex leftChild = T.left;
        leftChild.parent = T.parent;
        T.parent = leftChild;
        T.left = leftChild.right;
        if (leftChild.right != null) leftChild.right.parent = T;
        leftChild.right = T;
        updateHeight(T);
        updateHeight(leftChild);
        return leftChild;
    }

    public BSTVertex rebalance(BSTVertex T) {
        int bf = balanceFactor(T);
        if (bf == 2) {
            int leftBF = balanceFactor(T.left);
            if (leftBF == -1) T.left = rotateLeft(T.left);
            T = rotateRight(T);
        }
        else if (bf == -2) {
            int rightBF = balanceFactor(T.right);
            if (rightBF == 1) T.right = rotateRight(T.right);
            T = rotateLeft(T);
        }
        return T;
    }
}

class BSTVertex {
    int key;
    BSTVertex parent, left, right;
    int height;
    int size;
    
    BSTVertex(int v) {
        key = v;
        parent = left = right = null;
        height = 0;
    }
}