//Davin Chua A0234351N

public class Teque2 {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in, System.out);

        int leftStart = 1000000, leftEnd = 1000001, rightStart = 1000000, rightEnd = 1000001;
        int[] left = new int[2000000];
        int[] right = new int[2000000];
        int lines = in.getInt();
        for (int i = 0; i < lines; i++) {
            String cmd = in.getWord();
            int val = in.getInt();
            switch(cmd) {
                case "push_front":
                    left[leftStart] = val;
                    leftStart--;
                    break;
                case "push_back":
                    right[rightEnd] = val;
                    rightEnd++;
                    break;
                case "push_middle":
                    left[leftEnd] = val;
                    leftEnd++;
                    break;
                case "get":
                    int leftSize = leftEnd-leftStart-1;
                    if (val+1 <= leftSize) in.println(left[val+leftStart+1]);
                    else in.println(right[val-leftSize+rightStart+1]);
            }
            int leftSize = leftEnd-leftStart-1, rightSize = rightEnd-rightStart-1;
            if (rightSize > leftSize) {
                left[leftEnd] = right[rightStart+1]; //set end of left to 1st elem of right
                right[rightStart+1] = 0; //update 1st elem of right to 0
                leftEnd++; //update leftEnd
                rightStart++; //update rightStart
            }
            else if (leftSize - 1 > rightSize) {
                right[rightStart] = left[leftEnd-1]; //update start of right to last elem of left
                left[leftEnd-1] = 0; //update last elem of left to 0
                leftEnd--;
                rightStart--;
            }
        }
        in.flush();
    }
}
