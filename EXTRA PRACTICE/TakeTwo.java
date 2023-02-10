import java.util.Scanner;

public class TakeTwo {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String res = ((inp.nextInt() % 2) == 1) ? "Alice" : "Bob";
        System.out.println(res);;
        inp.close();
    }
}