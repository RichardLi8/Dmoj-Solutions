import java.io.*;
import java.util.*;
public class HelloWorld {
    static int circle(int row, int r){
        return (int) Math.sqrt(r*r-row*row);
    }
    public static void main(String [] args) throws IOException{
        int m = readInt(), n = readInt(), k = readInt();
        int [][] d = new int [n+2][m+2];
        for(int i = 0; i < k; i++){
            int x = readInt(), y = readInt(), r = readInt(), b = readInt();
            for(int j = Math.max(1, x-r); j <= Math.min(n, x+r); j++){
                int idx = circle(x-j, r);
                int left = Math.max(1, y-idx), right = Math.min(m, y+idx);
                d [j][left] += b; d [j][right+1] -= b;
            }
        }
        int ans = 0, cnt = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                d [i][j] += d [i][j-1];
                if(d [i][j] > ans){
                    ans = d [i][j];
                    cnt = 1;
                }
                else if(d [i][j] == ans){
                    cnt++;
                }
            }
        }
        System.out.println(ans + "\n" + cnt);
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