/*Davin Chua A0234351N */

import java.util.*;
import java.io.*;

public class CardTradingV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = inp.readLine().split(" ");
        int antNum = Integer.parseInt(temp[0]); //Number of cards anthony has
        int numTypes = Integer.parseInt(temp[1]); //Number of types of cards available
        int reqTypes = Integer.parseInt(temp[2]); //Number of types of cards required

        //Counting the number of each type of card anthony has
        int[] lst = new int[numTypes];
        temp = inp.readLine().split(" ");
        for (int i = 0; i < antNum; i++) {
            int a = Integer.parseInt(temp[i]);
            lst[a-1]++;
        }

        //Creating card instances
        ArrayList<Card> arr = new ArrayList<Card>();
        for (int i = 0; i < numTypes; i++) {
            temp = inp.readLine().split(" ");
            int buyPrice = Integer.parseInt(temp[0]);
            int sellPrice = Integer.parseInt(temp[1]);
            arr.add(new Card(lst[i], buyPrice, sellPrice));
        }
        inp.close();
        Collections.sort(arr, new sortByValue());

        long profit = 0;
        for (int i = 0; i < reqTypes; i++) {
            int count = arr.get(i).count;
            profit = profit - arr.get(i).buy*(2-count);
        }
        for (int i = reqTypes; i < numTypes; i++) {
            int count = arr.get(i).count;
            profit = profit + arr.get(i).sell*count;
        }
        System.out.println(profit);
    }
}

class Card {
    int count;
    int buy;
    int sell;
    int value;

    public Card(int count, int buy, int sell) {
        this.count = count;
        this.buy = buy;
        this.sell = sell;
        this.value = count*sell+(2-count)*buy;
    }
}

class sortByValue implements Comparator<Card> {
    public int compare(Card a, Card b) {
        int res = Integer.compare(a.value, b.value);
        if (res == 0) {
            res = Integer.compare(a.buy, b.buy);
        }
        return res;
    }
}