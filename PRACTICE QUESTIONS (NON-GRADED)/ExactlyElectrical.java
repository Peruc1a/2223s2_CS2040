import java.io.*;

public class ExactlyElectrical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] coord1 = br.readLine().split(" ");
        String[] coord2 = br.readLine().split(" ");
        int moves = Integer.parseInt(br.readLine());
        br.close();
        int reqMoves = Math.abs(Integer.parseInt(coord1[0])-Integer.parseInt(coord2[0])) + Math.abs(Integer.parseInt(coord1[1])-Integer.parseInt(coord2[1]));
        if (reqMoves <= moves && (moves-reqMoves) % 2 == 0) {
            System.out.println("Y");
        }
        else {
            System.out.println("N");
        }
    }
}
