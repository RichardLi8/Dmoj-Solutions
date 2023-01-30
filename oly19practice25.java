import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [][] a;
    public static long query(int x1, int y1, int x2, int y2){
        return a [x2][y2] - a [x1-1][y2] - a [x2][y1-1] + a [x1-1][y1-1];
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        a = new long [n+2][m+2];
        for(int i = 0; i < k; i++){
            int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
            a [x1][y1] += 1;
            a [x2+1][y1] -= 1;
            a [x1][y2+1] -= 1;
            a [x2+1][y2+1] += 1;
        }
        for(int b = 0; b < 2; b++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    a [i][j] += a [i-1][j] + a [i][j-1] - a [i-1][j-1];
                }
            }
        }
        int q = readInt();
        for(int i = 0; i < q; i++){
            int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
            System.out.println(query(x1, y1, x2, y2));
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