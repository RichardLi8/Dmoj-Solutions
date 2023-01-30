import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), t = readInt();
        int times [] = new int [n+1];
        for(int i = 1; i <= n; i++){
            times [i] = readInt();
        }
        double [] s = new double [n+1];
        int full = 0;
        for(int i = 0; i < m; i++){
            int k = readInt();
            for(int a = 0; a < k; a++){
                int u = readInt();
                s [u] += (double) 1/k;
            }
            if(k == 0) full++;
        }
        double dp [] = new double [t+1];
        for(int i = 1; i <= n; i++){
            int w = times [i]; double v = s [i];
            for(int j = t; j >= w; j--){
                dp [j] = Math.max(dp [j], dp [j-w] + v);
            }
        }
        System.out.printf("%.2f\n", dp [t] + full);
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