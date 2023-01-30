import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt(), k = readInt();
        pair [] a = new pair [n];
        for(int i = 0; i < n; i++){
            a [i] = new pair(readInt(), readInt());
        }
        Arrays.sort(a, (pair x, pair y) ->{
            if(x.y != y.y) return Long.compare(x.y, y.y);
            return Long.compare(x.x, y.x);
        });
        PriorityQueue <pair> pq = new PriorityQueue<>((pair x, pair y) -> {
            return -Long.compare(x.x, y.x);
        });
        long x = 0, y = 0, ans = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            x += a [i].x;
            y = a [i].y;
            pq.add(a [i]);
        }
        ans = Math.min(ans, x*y);
        for(int i = k; i < n; i++){
            pq.add(a [i]);
            x += a [i].x;
            y = a[i].y;
            pair p = pq.poll();
            x -= p.x;
            ans = Math.min(ans, x*y);
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(long a, long b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Long.compare(x, p.x);
            return Long.compare(y, p.y);
        }
    }
    static PrintWriter pr = new PrintWriter(System.out);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}