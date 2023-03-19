import java.util.*;

public class BinaryHeap {
    public ArrayList<Integer> A;
    public int size;

    BinaryHeap() {
        A = new ArrayList<Integer>();
        size = 0;
    }

    BinaryHeap(int[] arr) {
        CreateHeap(arr);
    }

    int parent(int i) { return i>>1;}
    int left(int i) {return i<<1;}
    int right(int i) {return (i<<1) + 1;}

    void shiftUp(int i) {
        while (i > 1 && A.get(parent(i)) < A.get(i)) {
            int temp = A.get(i);
            A.set(i,A.get(parent(i)));
            A.set(parent(i), temp);
            i = parent(i);
        }
    }

    void Insert(int key) {
        size++;
        if (size >= A.size()) A.add(key);
        else A.set(size, key);
        shiftUp(size);
    }

    void shiftDown(int i) {
        while (i <= size) {
            int maxV = A.get(i), max_id = i;
            if (left(i) <= size && maxV < A.get(left(i))); {
                maxV = A.get(left(i));
                max_id = left(i);
            }

            if (right(i) <= size && maxV < A.get(right(i))) {
                maxV = A.get(right(i));
                max_id = right(i);
            }

            if (max_id != i) {
                int temp = A.get(i);
                A.set(i, A.get(max_id));
                A.set(max_id, temp);
                i = max_id;
            }
            else break;
        }
    }

    int ExtractMax() {
        int maxV = 0;
        if (size != 0) {
            maxV = A.get(1);
            A.set(1,A.get(size));
            size--;
            shiftDown(1);
        }
        else {
            System.out.println("Heap is empty!");
            System.exit(1);
        }
        return maxV;
    }

    void CreateHeapSlow(int[] arr) {
        A = new ArrayList<Integer>();
        A.add(0);
        for (int i = 1; i <= size; i++) Insert(arr[i-1]);
    }

    void CreateHeap(int[] arr) {
        size = arr.length;
        A = new ArrayList<Integer>();
        A.add(0);
        for (int i = 1; i <= size; i++) A.add(arr[i-1]);
        for (int i = parent(size); i >= 1; i--) shiftDown(i);
    }
    ArrayList<Integer> HeapSort(int[] arr) {
        CreateHeap(arr);
        int N = arr.length;
        for (int i = 1; i <= N; i++) A.set(N-i+1, ExtractMax());
        return A;
    }

    int size() { return size;}
    boolean isEmpty() { return size == 0;}
}
