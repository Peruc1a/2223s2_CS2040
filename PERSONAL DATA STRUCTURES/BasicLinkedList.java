class BasicLinkedList implements ListInterface {
    public ListNode head;
    public int num_nodes;

    //Interface methods
    public boolean isEmpty() {
        return (num_nodes == 0);
    }

    public int size() {
        return num_nodes;
    }

    public int indexOf(int item) {
        int index = 0;
        for (ListNode cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getItem() == item) 
                return index;
            else 
                index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        if (indexOf(item) != -1) return true; else return false;
    }

    public int getItemAtIndex(int index) {
        int counter = 0;
        int item = 0;
        if (index < 0 || index > num_nodes) {
            System.out.println("Invalid Index");
            System.exit(1);
        }
        for (ListNode cur = head; cur != null; cur = cur.getNext(), counter++) {
            if (counter == index) {
                item = cur.getItem();
            }
        }
        return item;
    }

    public int getFirst() {
        return getItemAtIndex(0);
    }

    public int getLast() {

        return getItemAtIndex(num_nodes-1);
    }

    public void addAtIndex(int index, int item) {
        ListNode newNode = new ListNode(item);
        if (index < 0 || index > num_nodes) {
            System.out.println("Invalid Index");
            System.exit(1);
        }
        if (index == 0) {
            insert(null, newNode);
        }
        else {
            insert(getNodeAtIndex(index-1),newNode);
        }
    }

    public void addFront(int item) {
        addAtIndex(0, item);
    }

    public void addBack(int item) {
        addAtIndex(num_nodes, item);
    }

    public int removeAtIndex(int index) {
        int item = 0;
        if (index >= 0 && index < num_nodes) {
            if (index == 0) {
                item = remove(null);
            }
            else {
                item = remove(getNodeAtIndex(index-1));
            }
        }
        else {
            System.out.println("Invalid index or empty list");
            System.exit(1);
        }
        return item;
    }

    public int removeFront() {
        return removeAtIndex(0);
    }

    public int removeBack() {
        return removeAtIndex(num_nodes-1);
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
            n.setNext(head.getNext());
            head= n;
        }
        else {
            n.setNext(cur.getNext());
            cur.setNext(n);
        }
        num_nodes++;
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

    public ListNode getNodeAtIndex(int index) {
        int counter = 0;
        ListNode res = null;
        if (index < 0 || index > num_nodes-1) {
            System.out.println("Invalid Index");
            System.exit(1);
        }
        for (ListNode cur = head; cur != null; cur = cur.getNext(), counter++) {
            if (counter == index) {
                res = cur;
                break;
            }
        }
        return res;
    }

}
