import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int i, int v, int [] bit){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i, int bit []){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), val = 0, zero = 0;
        int [] a = new int [n+1], psa = new int [n+1], neg = new int [150001], pos = new int [150001];
        for(int i = 1; i <= n; i++) {
            val += a [i] = readInt() == 2? -1 : 1;
            psa [i] = psa [i-1] + a [i];
            if(psa [i] < 0){
                update(psa [i]*-1, 1, neg);
            }
            else if(psa [i] > 0){
                update(psa [i], 1, pos);
            }
            else zero++;
        }
        long ans = 0;
        if(val > 0){
            ans++;
            ans += query(neg.length-1, neg);
            ans += query(val-1, pos);
            ans += zero;
        }
        else if(val < 0){
            ans += query(neg.length-1, neg)-query(val*-1, neg);
        }
        else{
            ans += query(neg.length-1, neg);
        }
        for(int i = n; i > 1; i--){
            if(psa [i] < 0){
                update(psa [i] * -1, -1, neg);
            }
            else if(psa [i] > 0){
                update(psa [i], -1, pos);
            }
            else zero--;
            val -= a [i];
            if(val > 0){
                ans++;
                ans += query(neg.length-1, neg);
                ans += query(val-1, pos);
                ans += zero;
            }
            else if(val < 0){
                ans += query(neg.length-1, neg)-query(val*-1, neg);
            }
            else{
                ans += query(neg.length-1, neg);
            }
        }
        System.out.println(ans);
    }        
    static class pair implements Comparable <pair>{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
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