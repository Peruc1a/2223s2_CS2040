//Davin Chua A0234351N
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class WhatDoesTheFoxSay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            StringBuilder sb = new StringBuilder();
            HashSet<String> set = new HashSet<>();
            String[] noises = br.readLine().split(" ");
            String next = br.readLine();
            while (!next.equals("what does the fox say?")) {
                String[] temp = next.split(" ");
                set.add(temp[2]);
                next = br.readLine();
            }
            for (String s : noises) {
                if (set.contains(s)) continue;
                sb.append(s);
                sb.append(" ");
            }
            pw.println(sb);
        }
        pw.flush();
    }
}
