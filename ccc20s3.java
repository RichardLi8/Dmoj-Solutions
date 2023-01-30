import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean check(int [] freq1, int [] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1 [i] != freq2 [i]) return false;
        }
        return true;
    }
    static long getHash(long [] p, long [] hash, long mod, int st, int ed){
        return (hash [ed]-hash [st-1] + mod)*p[p.length - st] % mod;
    }
    public static void main(String [] args) throws IOException{
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() > b.length()) {
            System.out.println(0);
            return;
        }
        int n = a.length(), h = b.length();
        int [] one = new int [n+1], two = new int [h+1];
        for(int i = 1; i <= n; i++){
            one [i] = a.charAt(i-1)-'a';
        }
        for(int i = 1; i <= h; i++){
            two [i] = b.charAt(i-1)-'a';
        }
        int [] freq1 = new int [26], freq2 = new int [26];
        long [] p1 = new long[h+1], p2 = new long [h+1], hash1 = new long [h+1], hash2 = new long[h+1];
        long mod1 = (long)1e9 + 7, mod2 = (long)1e9 + 9;
        p1[1] = p2 [1] = 1; hash1 [1] = hash2 [1] = two [1];
        for(int i = 2; i <= h; i++){
            p1 [i] = p1 [i-1] * 131 % mod1;
            p2 [i] = p2 [i-1] * 137 % mod2;
            hash1 [i] = (p1 [i] * two [i] + hash1 [i-1])%mod1;
            hash2 [i] = (p2 [i] * two [i] + hash2 [i-1])%mod2;
        }
        for(int i = 1; i <= n; i++){
            freq1 [one [i]]++;
            freq2 [two [i]]++;
        }
        freq2 [two [n]]--;
        TreeSet <pair> combos = new TreeSet();
        for(int i = n; i <= h; i++){
            freq2 [two [i]]++;
            if(check(freq1, freq2)){
                combos.add(new pair(getHash(p1, hash1, mod1,  i-n+1, i), getHash(p2, hash2, mod2, i-n+1, i)));
            }
            freq2 [two [i-n+1]]--;
        }
        System.out.println(combos.size());
    }
    static class pair implements Comparable <pair>{
        long v, i;
        pair(long a, long b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            if (v != p.v) return Long.compare(v, p.v);
            return Long.compare(i, p.i);
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