import java.util.List;

class BasicLinkedList implements ListInterface {
    public ListNode head;
    public int num_nodes;

    public boolean isEmpty() {
        return (num_nodes == 0);
    }

    public int size() {
        return num_nodes;
    }

    public int indexOf(int item) {
        int counter = 0;
        for (ListNode cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getItem() == item) return counter; else counter++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return (indexOf(item) != -1);
    }

    public int getItemAtIndex(int index) {
        int counter = 0;
        int item = 0;
        if (index < 0 || index >= size()) {
            System.out.println("Invalid Index");
            System.exit(1);
        }
        for (ListNode cur = head; cur != null; cur = cur.getNext(), counter++) {
            if (counter == index) {
                item = cur.getItem();
                break; 
            }
        }
        return item;
    }

    public int getFirst() {
        return getItemAtIndex(0);
    }

    public int getLast() {
        return getItemAtIndex(size()-1);
    }

    public void addAtIndex(int index, int item) {
        ListNode cur;
        ListNode node = new ListNode(item);
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                insert(null,node);
            }
            else {
                cur = getNodeAtIndex(index-1);
                insert(cur,node);
            }
        }
        else {
            System.out.println("Invalid Index");
            System.exit(1);
        }
    }

    public void addFront(int item) {
        addAtIndex(0, item);
    }

    public void addBack(int item) {
        addAtIndex(size(), item);
    }

    public int removeAtIndex(int index) {
        ListNode cur;
        int value = 0;
        if (index >= 0 || index < size()) {
            if (index == 0) {
                value = remove(null);
            }
            else {
                cur = getNodeAtIndex(index-1);
                value = remove(cur);
            }
        }
        else {
            System.out.println("Invalid index or empty list");
            System.exit(1);
        }
        return value;
    }

    public int removeFront() {
        return removeAtIndex(0);
    }

    public int removeBack() {
        return removeAtIndex(size()-1);
    }

    public void print() {
        if (head == null)
            System.out.println("Nothing to print...");
        else {
            ListNode cur = head;
            System.out.print("List is: " + cur.getItem());
            for (int i=1; i < num_nodes; i++) {
                cur = cur.getNext();
                System.out.print(", " + cur.getItem());
            }
            System.out.println(".");
        }
      }

    public void insert(ListNode cur, ListNode n) {
        if (cur == null) {
            n.setNext(head);
            head = n;
        }
        else {
            n.setNext(cur.getNext());
            cur.setNext(n);
        }
        num_nodes++;
    }

    public ListNode getNodeAtIndex(int index) {
        ListNode node = null;
        int counter = 0;
        if (index < 0 || index >= size()) {
            System.out.println("Invalid Index");
            System.exit(1);
        }
        for (ListNode cur = head; cur != null; cur = cur.getNext()) {
            if (counter == index) {
                node = cur;
                break;
            }
            counter++;
        }
        return node;
    }

    
    public int remove(ListNode cur) {
        int value;
        if (cur == null) {
            value = head.getItem();
            head = head.getNext();
        }
        else {
            value = cur.getNext().getItem();
            cur.setNext(cur.getNext().getNext());
        }
        num_nodes--;
        return value;
    }
}