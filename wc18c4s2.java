import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), h = readInt();
        pair [] holes = new pair [n+1]; holes [0] = new pair(0, 0);
        int dp [] = new int [n+1];
        for(int i = 1; i <= n; i++){
            holes [i] = new pair(readInt(), readInt());
        }
        Arrays.sort(holes);
        for(int i = 1; i <= n; i++){
            dp [i] = Integer.MAX_VALUE;
            int maxwait = 0;
            for(int j = i; j >= 1; j--){
                // 2 * (i-j) is equal to the time passed, k -> i + i -> k + k -> j + j -> k
                //k -> i + k -> j = i-j; i -> k + j -> k = i-j
                int dist = holes [i].pos - holes [j].pos;
                maxwait = Math.max(holes [j].wait, maxwait);
                dp [i] = Math.min(dp [i], dp [j-1] + Math.max(maxwait, dist * 2));
            }
        }
        System.out.println(dp [n] + h);
    }
    static class pair implements Comparable <pair>{
        int pos, wait;
        public pair(int p, int w){
            pos = p;
            wait = w;
        }
        public int compareTo(pair p){
            return Integer.compare(pos, p.pos);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}