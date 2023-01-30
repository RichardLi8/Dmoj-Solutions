import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [][] nums = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                nums [i][j] = readInt();
            }
        }
        int rowsum = 0;
        for(int i = 0; i <n; i++){
            int sums [] = new int [2];
            for(int j = 0; j < n; j++){
                sums [j%2] += nums [i][j];
            }
            rowsum += Math.max(sums [0], sums [1]);
        }
        int colsum = 0;
        for(int i = 0; i <n; i++){
            int sums [] = new int [2];
            for(int j = 0; j < n; j++){
                sums [j%2] += nums [j][i];
            }
            colsum += Math.max(sums [0], sums [1]);
        }
        System.out.println(Math.max(colsum, rowsum));
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}