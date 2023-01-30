import java.io.*;
import java.util.*;
public class HelloWorld {
    static int bsearch(int l, int r, long v){
        int s = l;
        while(l <= r){
            int mid = (l+r)/2;
            if(query(s, mid) > v){
                l = mid+1;
            }
            else r = mid-1;
        }
        return l;
    }
    static long query(int l, int r){
        int k = (int) (Math.log(r-l+1)/Math.log(2));
        return Math.min(stmin [l][k], stmin [r-(1<<k)+1][k]);
    }
    static long [][] stmin;
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt(), max = (int) (Math.log(n)/Math.log(2));
        stmin = new long [n+1][max+1];
        for(int i = 1; i <= n; i++){
            stmin [i][0] = readLong();
            
        }
        for(int j = 1; j <= max; j++){
            for(int i = 0; i < n; i++){
                if(i + (1<<j)-1 > n) break;
                stmin [i][j] = Math.min(stmin [i][j-1], stmin [i + (1<<j-1)][j-1]);
            }
        }
        for(int i = 0; i < q; i++){
            long v = readLong(); int l = readInt(), r = readInt();
            while((l = bsearch(l, r, v)) <= r){
                v %= stmin [l][0];
            }
            System.out.println(v);
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
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