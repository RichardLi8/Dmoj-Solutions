import java.io.*;
import java.util.*;
public class HelloWorld {
    static long subGrids(int n, int [][] a, int min){
        int [] h = new int [n+1];
        long ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(a [i][j] >= min) h [j]++;
                else h [j] = 0;
            }
            for(int j = 1; j <= n; j++){
                ans += h [j]; int low = h [j];
                for(int k = j-1; k >= 1; k--){
                    low = Math.min(low, h [k]);
                    ans += low;
                }
            }
        }
        return ans;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [][] a = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a [i][j] = readInt();
            }
        }
        System.out.println(subGrids(n, a, 100)-subGrids(n, a, 101));
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