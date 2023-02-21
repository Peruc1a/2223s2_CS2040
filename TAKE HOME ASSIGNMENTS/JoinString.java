//Davin Chua A0234351n
import java.util.*;

class StringNode {
    public StringNode next;
    public String item;
    public StringNode(String val, StringNode n) {
        item = val;
        next = n;
    }

    public StringNode(String item){
        this(item, null);
    }

    public void setNext(StringNode n) {
        next = n;
    }

    public StringNode getNext() {
        return next;
    }
    public String getItem() {
        return item;
    }
}

class TLL {
    StringNode head;
    StringNode tail;
    int num_items;

    public void addFront(String item) {
        StringNode node = new StringNode(item);
        head = node;
        tail = node;
        num_items++;
    }
}

public class JoinString {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        ArrayList<TLL> list = new ArrayList<>();
        int cases = k.getInt();
        for (int i = 0; i < cases; i++) {
            TLL tll = new TLL();
            tll.addFront(k.getWord());
            list.add(tll);
        }
        int first = 0;
        for (int j = 0; j < cases-1; j++) {
            first = k.getInt()-1;
            int second = k.getInt()-1;
            TLL firstList = list.get(first);
            TLL secondList = list.get(second);
            firstList.tail.setNext(secondList.head);
            firstList.tail = secondList.tail;
        }
        StringNode node = list.get(first).head;
        while (node != null) {
            k.print(node.getItem());
            node = node.getNext();
        }
        k.flush();
    }
}
