//Davin Chua A0234351N
// 3 5 1 9
import java.util.*;

public class Teque {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in, System.out);
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        MapTracker trackLeft = new MapTracker(0, 0, left);
        MapTracker trackRight = new MapTracker(1000000, 1000000, right);
        int lines = in.getInt();
        for (int i = 0; i < lines; i++) {
            String cmd = in.getWord();
            int val = in.getInt();
            int res = 0;
            switch(cmd) {
                case "push_front":
                    trackLeft.addFront(val);
                    break;
                case "push_back":
                    trackRight.addBack(val);
                    break;
                case "push_middle":
                    trackLeft.addBack(val);
                    break;
                case "get": 
                    if (val+1 > left.size()) res = trackRight.get(val-left.size());
                    else res = trackLeft.get(val);
                    in.println(res);
            }
            if (right.size() > left.size()) {//balancing lists
                trackLeft.addBack(trackRight.removeFront());
            }
            else if (left.size()-1 > right.size()) {
                trackRight.addFront(trackLeft.removeBack());
            }
        }
        in.flush();
    }
}

class MapTracker {
    int start;
    int end;
    HashMap<Integer, Integer> map;

    public MapTracker(int a, int b, HashMap<Integer, Integer> c) {
        start = a;
        end = b;
        map = c;
    }

    public void addFront(int item) {
        if (map.size() == 0) map.put(start, item); //adding to an empty map, don't update start or end
        else {
            map.put(start-1, item);
            start--;
        }
    }

    public void addBack(int item) {
        if (map.size() == 0) map.put(end,item);
        else {
            map.put(end+1, item);
            end++;
        }
    }

    public int removeFront() {
        if (map.size() == 1) {
            return map.remove(start);
        }
        else {
            start++;
            return map.remove(start-1);
        }
    }

    public int removeBack() {
        end--;
        return map.remove(end+1);
    }

    public int get(int index) {
        return map.get(start+index);
    }

}

