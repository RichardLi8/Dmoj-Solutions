import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int k = readInt(), m = readInt(), n = readInt();
        pair [] grass = new pair [k]; int [] cow = new int [m];
        for(int i = 0; i < k; i++){
            grass [i] = new pair(readInt(), readInt());
        }
        for(int i = 0; i < m; i++){
            cow [i] = readInt();
        }
        Arrays.sort(grass);
        Arrays.sort(cow);
        int pos = 0;
        PriorityQueue <Long> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 1; i < m; i++){
            while(grass [pos].x < cow [i-1] && pos < k){
                pos++;
            }
            if(grass [pos].x > cow [i]) continue;
            int r = pos;
            long sum = 0, max = 0, cur = 0;
            while(r < k && grass [r].x < cow [i]){
                sum += grass [r].y;
                cur += grass [r].y;
                while(grass [r].x-grass [pos].x+1 > (cow [i]-cow [i-1])/2){
                    cur -= grass [pos].y;
                    pos++;
                }
                max = Math.max(max, cur);
                r++;
            }
            pq.add(max); pq.add(sum-max); 
        }
        long sum = 0;
        for(int i = 0; i < k; i++){
            if(grass [i].x < cow [0]) sum += grass [i].y;
            else break;
        }
        pq.add(sum);
        sum = 0;
        for(int i = k-1; i >= 0; i--){
            if(grass [i].x > cow [m-1]) sum += grass [i].y;
            else break;
        }
        pq.add(sum);
        long cnt = 0, ans = 0;
        while(cnt < n && !pq.isEmpty()){
            ans += pq.poll();
            cnt++;
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}