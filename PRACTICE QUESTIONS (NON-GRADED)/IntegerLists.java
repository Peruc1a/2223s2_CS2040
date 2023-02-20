import java.util.*;

//Davin Chua A0234351N

public class IntegerLists {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        int cases = k.getInt();
        for (int i = 0; i < cases; i++) {

            String[] cmds = k.getWord().split("");
            Deque<Integer> dq = new LinkedList<>();
            int num = k.getInt();
            String temp = k.getWord();
            String[] temp2 = temp.substring(1,temp.length()-1).split(",");
            for (String s : temp2) {
                if (s.equals("")) break;
                dq.add(Integer.parseInt(s));
            }
            boolean flag = true; //true = drop elements from front, false = drop elements from back
            boolean err = false;
            for (String s : cmds) {
                if (s.equals("R")) flag = !flag;
                else { //drop elements
                    if (dq.size() == 0) {
                        err = true;
                        break;
                    }
                    else if (flag) dq.removeFirst();
                    else dq.removeLast();
                }
            }
            if (err) {
                k.println("error");
            }
            else{
                k.print("[");
                int sz = dq.size();
                for (int n = 0; n < sz; n++) {
                    if (n > 0) {
                        k.print(",");
                    }
                    if (flag) k.print(dq.removeFirst());
                    else k.print(dq.removeLast());
                }
                k.print("]");
                k.println();
            }
        }
    k.flush();
    }
}
