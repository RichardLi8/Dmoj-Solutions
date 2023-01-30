import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int m [][] = new int [n+1][n+1], a [] = new int [n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                m [i][j] = readInt();
                a [i] = Math.max(m [i][j], a[i]);
                a [j] = Math.max(m [i][j], a[j]);
            }
        }
        for(int i = 1; i <= n; i++) System.out.print(a [i] + " ");
        System.out.println("");
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