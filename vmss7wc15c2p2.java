import java.io.*;
import java.util.*;
public class HelloWorld {
    static long getSub1(int l, int r, long [] hash, long [] p){
        return ((hash [r]-hash [l-1] * p [r-l+1])%mod + mod)%mod;
    }
    static long getSub2(int l, int r, long [] hash, long [] p){
        return ((hash [l]-hash [r+1] * p [r-l+1])%mod + mod)%mod;
    }
    static int bsearch(int l, int r, long [] hash1, long [] hash2, long [] p){
        int lo = 1, hi = Math.min(l-1, n-r);
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(getSub1(l-mid, l, hash1, p) != getSub2(r, r+mid, hash2, p)){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return hi;
    }
    static long mod = (int)1e9+9;
    static int n;
    public static void main(String [] args) throws IOException{
        n = readInt(); String s = br.readLine();
        long [] hash1 = new long [n+1], hash2 = new long [n+2], p = new long [n+1];
        p [0] = 1;
        for(int i = 1; i <= n; i++){
            hash1 [i] = (s.charAt(i-1) + hash1 [i-1] * 131)%mod;
            p [i] = (p [i-1] * 131)%mod;
        }
        for(int i = n; i >= 1; i--){
            hash2 [i] = (hash2 [i+1]*131 + s.charAt(i-1))%mod;
        }
        int max = 1, idx = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                int v = bsearch(i, i+1, hash1, hash2, p);
                if((v+1)*2 > max){
                    max = (v+1)*2;
                    idx = i-v-1;
                }  
            }
            int v = bsearch(i, i, hash1, hash2, p);
            if((v+1)*2-1 > max){
                max = (v+1)*2-1;
                idx = i-v-1;
            }
        }
        System.out.println(s.substring(idx, + idx+max));
        System.out.println(max);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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