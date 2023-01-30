import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), a [][] = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                a [i][j] = readInt();
            }
        }
        System.out.println(cntSubGrids(n, a, 100) - cntSubGrids(n, a, 101));
    }
    static long cntSubGrids(int n, int [][] a, int min){
        int h [] = new int [n+1]; long ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(a [i][j] >= min) h [j]++;
                else h [j] = 0;
            }
            for(int j = 1; j <= n; j++){
                int cnt = h [j], low = h [j];
                for(int k = j-1; k >= 1; k--){
                    low = Math.min(low, h [k]);
                    cnt+=low;
                }
                ans+=cnt;
            }
        }
        return ans;
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