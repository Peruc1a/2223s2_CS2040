import java.io.*;
import java.util.*;


//Davin Chua A0234351N

public class DelimiterSoup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int index = 0;
        for (String i : arr) {
            if (i.equals("{") || i.equals("(") || i.equals("[")) stack.add(i);
            else if (i.equals("}") || i.equals(")") || i.equals("]")) {
                String x = "";
                if (i.equals("}")) x = "{";
                else if (i.equals(")")) x = "(";
                else x = "[";
                if(stack.size() == 0 || !x.equals(stack.pop())) {
                    System.out.println(i + " " + index);
                    return;
                }
            }
            index++;
        }
        System.out.println("ok so far");
    }
}
