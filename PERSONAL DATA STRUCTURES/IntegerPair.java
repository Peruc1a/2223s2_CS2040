public class IntegerPair implements Comparable<IntegerPair> {
    int v;
    int w;
    public IntegerPair(int a, int b) {
        v = a;
        w = b;
    }
    public int compareTo(IntegerPair a) {
        return w - a.w;
    }
}
