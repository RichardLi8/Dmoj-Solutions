import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [][] psa = new int [n+1][11];
        int [] a = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            for(int j = 1; j <= 10; j++){
                psa [i][j] = psa [i-1][j];
            }
            psa [i][a[i]]++;
        }
        int [] pre = new int [n+1], suf = new int [n+2];
        for(int i = 1; i <= n; i++){
            pre [i] = Math.max(pre [i-1], a [i]);
        }
        for(int i = n; i >= 1; i--){
            suf [i] = Math.max(suf [i+1], a [i]);
        }
        for(int i = 0; i < q; i++){
            int l = readInt()-1, r = readInt()+1;
            int ans = Math.max(pre [l], suf [r]);
            System.out.println(ans + " " + (psa[l][ans]+psa[n][ans]-psa[r-1][ans]));
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