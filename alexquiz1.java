import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        int [] w = new int [n], v = new int [n];
        for(int i = 0; i < n; i++) {
            w [i] = readInt();
            v [i] = readInt();
        }
        deal [] deals = new deal [m];
        for(int i = 0; i < m; i++) deals [i] = new deal(readInt(), readInt(), readInt(), readInt());
        long dp [] = new long [k+1];
        for(int i = 0; i < n; i++){
            int c = w [i], s = v [i];
            for(int j = c; j <= k; j++){
                dp [j] = Math.max(dp [j], dp [j-c] + s);
            }
        }
        for(int i = 0; i < m; i++){
            int c = deals [i].cost;
            long s = v [deals [i].type-1] * (long) deals [i].qty;
            int u = deals [i].uses;
            for(int j = 1; j <= u; j*=2){
                u -= j;
                for(int a = k; a >= c*j; a--){
                    dp [a] = Math.max(dp [a], dp [a-c*j] + s * j);
                }
            }
            if(u > 0){
               for(int a = k; a >= c*u; a--){
                    dp [a] = Math.max(dp [a], dp [a-c*u] + s * u);
                } 
            }
        }
        System.out.println(dp [k]);
    }
    static class deal{
        int qty, type, cost, uses;
        public deal(int a, int b, int c, int d){
            qty = a;
            type = b;
            cost = c;
            uses = d;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}