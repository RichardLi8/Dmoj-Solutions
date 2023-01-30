import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        long hash1 = 0, hash2 = 0, p1 [] = new long [m+1], p2 [] = new long [m+1], full1 = 0, full2 = 0, mod1 = (int)1e9+7, mod2 = (int)1e9+9;
        p1 [0] = 1; p2 [0] = 1;
        for(int i = 1; i <= m; i++){
            full1 = (full1 * 100007 + 1) % mod1;
            full2 = (full2 * 100009 + 1) % mod2;
            p1 [i] = (p1 [i-1] * 100007) % mod1;
            p2 [i] = (p2 [i-1] * 100009) % mod2;
        }
        TreeMap <Integer, Integer> min = new TreeMap();
        TreeMap <pair, Integer> pre = new TreeMap();
        int [] freq = new int [100001];
        min.put(0, m); pre.put(new pair(0, 0), 1); long ans = 0;
        for(int i = 0; i < n; i++){
            int v = readInt();
            min.put(freq [v], min.get(freq [v])-1);
            if(min.get(freq [v]) == 0) min.remove(freq [v]);
            freq [v]++;
            min.put(freq [v], min.getOrDefault(freq [v], 0) + 1);
            hash1 += p1 [v-1];
            hash2 += p2 [v-1];
            long find1 = ((hash1 - full1 * min.firstKey()) % mod1 + mod1) % mod1;
            long find2 = ((hash2 - full2 * min.firstKey()) % mod2 + mod2) % mod2;
            pair p = new pair(find1, find2);
            int cnt = pre.getOrDefault(p, 0);
            ans += cnt;
            pre.put(p, cnt + 1);
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        long v, w;
        pair(long a, long b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Long.compare(w, p.w);
            return Long.compare(v, p.v);
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