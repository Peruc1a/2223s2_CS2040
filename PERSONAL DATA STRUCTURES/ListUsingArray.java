import java.util.*;

public class ListUsingArray implements ListInterface {
    public int capacity = 1000;
    public int num_items;
    public int[] arr = new int[capacity];

    public void insert(int index, int item) {
        if (num_items + 1 > capacity) {
            enlargeArr();
        }
    }
}
