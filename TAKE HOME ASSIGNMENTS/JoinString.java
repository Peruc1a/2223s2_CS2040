//Davin Chua A0234351n
import java.io.*;
import java.util.*;

class LNode {
    public LNode next;
    public String item;
    public LNode(String val, LNode n) {
        item = val;
        next = n;
    }

    public LNode(String item){
        this(item, null);
    }

    public void setNext(LNode n) {
        next = n;
    }

    public LNode getNext() {
        return next;
    }
    public String getItem() {
        return item;
    }
}

class TLL {
    LNode head;
    LNode tail;
    int num_items;

    public void addFront(String item) {
        LNode node = new LNode(item);
        head = node;
        tail = node;
        num_items++;
    }
}

public class JoinString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<TLL> list = new ArrayList<>();
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            TLL tll = new TLL();
            tll.addFront(br.readLine());
            list.add(tll);
        }
        int first = 0;
        for (int j = 0; j < cases-1; j++) {
            String[] temp = br.readLine().split(" ");
            first = Integer.parseInt(temp[0])-1;
            int second = Integer.parseInt(temp[1])-1;
            TLL firstList = list.get(first);
            TLL secondList = list.get(second);
            firstList.tail.setNext(secondList.head);
            firstList.tail = secondList.tail;
        }
        LNode node = list.get(first).head;
        while (node != null) {
            pw.print(node.getItem());
            node = node.getNext();
        }
        pw.flush();
    }
}
