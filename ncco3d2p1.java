import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt(), max = (int) (Math.log(n)/Math.log(2));
        int [][] stmin = new int [n][max+1], stmax = new int [n][max+1];;
        for(int i = 0; i < n; i++){
            stmax [i][0] = stmin [i][0] = readInt();
            
        }
        for(int j = 1; j <= max; j++){
            for(int i = 0; i < n; i++){
                if(i + (1<<j)-1 >= n) break;
                stmin [i][j] = Math.min(stmin [i][j-1], stmin [i + (1<<j-1)][j-1]);
                stmax [i][j] = Math.max(stmax [i][j-1], stmax [i + (1<<j-1)][j-1]);
            }
        }
        for(int i = 0; i < q; i++){
            int l = readInt()-1, r = readInt()-1;
            int k = (int) (Math.log(r-l+1)/Math.log(2));
            int low = Math.min(stmin [l][k], stmin [r-(1<<k)+1][k]);
            int high = Math.max(stmax [l][k], stmax [r-(1<<k)+1][k]);
            System.out.println(high-low);
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