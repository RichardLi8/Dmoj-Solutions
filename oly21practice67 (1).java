import java.io.*;
import java.util.*;
public class HelloWorld {
    static int mod1 = (int)1e9+7, mod2 = (int)1e9+9;
    static long getSub(int l, int r, long [] hash, long [] p, int mod){
        return ((hash [r]-hash [l-1] * p [r-l+1])%mod + mod)%mod;
    }
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            String s = br.readLine();
            long [] hash1 = new long [s.length()+1], p1 = new long [s.length()+1], hash2 = new long [s.length()+1], p2 = new long [s.length()+1];
            p1 [0] = 1; p2 [0] = 1;
            for(int i = 1; i <= s.length(); i++){
                hash1 [i] = (hash1 [i-1] * 131 + s.charAt(i-1))%mod1;
                p1 [i] = (p1 [i-1] * 131) % mod1;
                hash2 [i] = (hash2 [i-1] * 137 + s.charAt(i-1))%mod2;
                p2 [i] = (p2 [i-1] * 137) % mod2;
            }
            int best = 1;
            for(int len = 1; len <= s.length()/2; len++){
                if(s.length() % len != 0) continue;
                boolean flag = true;
                long cur1 = getSub(1, 1+len-1, hash1 , p1, mod1);
                long cur2 = getSub(1, 1+len-1, hash2, p2, mod2);
                for(int i = 1+len; i <= s.length(); i+=len){
                    long now1 = getSub(i, i+len-1, hash1, p1, mod1);
                    long now2 = getSub(i, i+len-1, hash2, p2, mod2);
                    if(cur1 != now1 || cur2 != now2) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    best = s.length()/len;
                    break;
                }
            }
            System.out.println(best);
        }
    }
    static class pair implements Comparable <pair>{
        long v, w;
        pair(long a, long b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Long.compare(p.w, w);
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