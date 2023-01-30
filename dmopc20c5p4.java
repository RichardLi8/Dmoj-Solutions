import java.io.*;
import java.util.*;
public class HelloWorld {
    static long getSub(int l, int r, long [] hash, long [] p, long mod){
        return ((hash [r] - hash [l-1] * p [r-l+1])%mod + mod)%mod;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int [][] g = new int [n+1][m+1];
        long mod = (int) 1e9 + 7;
        for(int i = 1; i <= n; i++){
            String s = next();
            for(int j = 1; j <= m; j++){
                g [i][j] = (s.charAt(j-1) == 'B'? 0 : 1);
            }
        }
        if(n > m){
            int [][] newg = new int [m+1][n+1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    newg [j][i] = g [i][j];
                }
            }
            int temp = n;
            n = m;
            m = temp;
            g = newg;
        }
        long [][] hash = new long [m+1][n+1];
        long [] p = new long [n+1]; p [0] = 1;
        for(int i = 1; i <= n; i++){
            p [i] = (p [i-1] * 3)%mod;
            for(int j = 1; j <= m; j++){
                hash [j][i] = (hash [j][i-1] * 3 + g [i][j])%mod;
            }
        }
        Map <Long, Integer> pre = new HashMap();
        long ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                pre = new HashMap();
                for(int k = 1; k <= m; k++){
                    if(g [i][k] == g [j][k]){
                        long cur = getSub(i, j, hash [k], p, mod);
                        ans += pre.getOrDefault(cur, 0);
                        pre.put(cur, pre.getOrDefault(cur, 0) + 1);
                    }
                    else{
                        pre = new HashMap();
                    }
                }
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        long f, s;
        pair(long a, long b){
            f = a;
            s = b;
        }
        public int compareTo(pair p){
            if(f == p.f) return Long.compare(s, p.s);
            return Long.compare(f, p.f);
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