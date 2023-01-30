import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int [] bit, int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] ^= v;
        }
    }
    static int query(int [] bit, int i){
        int ret = 0;
        for(; i > 0; i -= i&-i){
            ret ^= bit [i];
        }
        return ret;
    }
    static int [] odd, even;
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [] a = new int [n+1]; even = new int [n+1]; odd = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            if(i%2 == 0) update(even, i, a [i]);
            else update(odd, i, a [i]);
        }
        for(int i = 0; i < q; i++){
            int c = readInt();
            if(c == 1){
                int idx = readInt(), v = readInt();
                if(idx%2 == 0){
                    update(even, idx, a [idx]);
                    a [idx] = v;
                    update(even, idx, v);
                }
                else{
                    update(odd, idx, a [idx]);
                    a [idx] = v;
                    update(odd, idx, v);
                }
            }
            else{
                int l = readInt(), r = readInt();
                int cnt = r-l+1;
                if(cnt%2==1){
                    if(l%2 == 1){
                        System.out.println(query(odd, r)^query(odd, l-1));
                    }
                    else{
                        System.out.println(query(even, r)^query(even, l-1));
                    }
                }
                else System.out.println(0);
            }
        }
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