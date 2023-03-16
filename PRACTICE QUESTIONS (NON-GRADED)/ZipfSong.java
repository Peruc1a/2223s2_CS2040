import java.util.PriorityQueue;

public class ZipfSong {
    public static void main(String[] args) {
        Kattio k = new Kattio(System.in, System.out);
        PriorityQueue<Song> pq = new PriorityQueue<>();
        int songs = k.getInt();
        int rank = k.getInt();
        for (int i = 1; i < songs+1; i++) {
            Song a = new Song(i, k.getLong() * i,k.getWord());
            pq.add(a);
        }
        for (int i = 0; i < rank; i++) {
            k.println(pq.poll().name);
        }
        k.flush();
    }
}

class Song implements Comparable<Song> {
    String name;
    int songNum;
    long quality;
    public Song (int s, long d, String n) {
        songNum = s;
        name = n;
        quality = d;
    }


    public int compareTo(Song a) {
        if (quality == a.quality) return Integer.compare(songNum, a.songNum);
        return Double.compare(a.quality, quality);
    }
}
