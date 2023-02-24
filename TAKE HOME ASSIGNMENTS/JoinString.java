//Davin Chua A0234351N

class StringNode {
    public StringNode next;
    public StringNode last;
    public String item;
    public StringNode(String val, StringNode n, StringNode l) {
        item = val;
        next = n;
        last = l;
    }

    public StringNode(String item){ this(item, null, null);}

    public void setNext(StringNode n) { next = n;}
    public StringNode getNext() { return next;}

    public void setLast(StringNode n) { last = n;}
    public StringNode getLast() { return last;}

    public void setItem(String i) { item = i;}
    public String getItem() { return item;}
}

public class JoinString {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int cases = k.getInt();
        StringNode[] lst = new StringNode[cases];
        for (int i = 0; i < cases; i++) {
            StringNode n = new StringNode(k.getWord());
            lst[i] = n;
            lst[i].setLast(n);
        }
        int first = 0;
        for (int j = 0; j < cases-1; j++) {
            first = k.getInt()-1;
            int second = k.getInt()-1;
            StringNode cur = lst[first];
            StringNode next = lst[second];
            cur.getLast().setNext(next);
            cur.setLast(next.getLast());
        }
        StringNode node = lst[first];
        while (node != null) {
            k.print(node.getItem());
            node = node.getNext();
        }
        k.flush();
    }
}
