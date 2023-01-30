import java.io.*;
import java.util.*;
public class HelloWorld {
    static long qpow(long b, int x){
        if(x == 0) return 1;
        long a = qpow(b, x/2);
        a = a*a%mod;
        if((x&1) == 1) return a*b%mod;
        else return a;
    }
    static int mod = (int)1e9+7;
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n+1]; long [] fac = new long [n+1], inv = new long [n+1];
        fac [0] = 1; inv [0] = 1;
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            fac [i] = (fac [i-1] * i)%mod;
            inv [i] = qpow(fac [i], mod-2);
        }
        Arrays.sort(a, 1, n+1);
        long ans = 0;
        for(int i = n; i >= k; i--){
            ans = (ans + a [i] * (fac [i-1]*inv [i-1-(k-1)]%mod*inv [k-1]%mod) % mod)%mod;
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
            return -Integer.compare(x, p.x);
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