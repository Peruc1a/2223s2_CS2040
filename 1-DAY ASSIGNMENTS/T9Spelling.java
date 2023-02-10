import java.util.*;
import java.io.*; 

public class T9Spelling {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> alphas  = new HashMap<String, String>();
        String[] lst = "abc def ghi jkl mno pqrs tuv wxyz".split(" ");
        alphas.put(" ","0");
        int num = 2;
        for (String i : lst) {
            List<String> temp = Arrays.asList(i.split(""));
            for (String j : temp) {
                alphas.put(j, Integer.toString(num).repeat(temp.indexOf(j)+1));
            }
            num++;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int wordNo = Integer.parseInt(br.readLine());
        for (int i = 0; i < wordNo; i++) {
            char hold = 'A';
            String[] ln = br.readLine().split("");
            StringBuilder res = new StringBuilder("Case #" + (i+1) + ": ");
            for (String j : ln) {
                char x = alphas.get(j).charAt(0);
                res.append(x == hold ? " " : "").append(alphas.get(j));
                hold = x;
            }
            out.println(res);
            out.flush();
        }
        br.close();
    }
}
